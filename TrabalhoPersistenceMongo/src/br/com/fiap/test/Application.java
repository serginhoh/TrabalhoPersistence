package br.com.fiap.test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.fiap.entity.*;
import br.com.fiap.repository.EstoqueRepository;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.repository.ClienteRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ClienteRepository.class)
public class Application implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
	private PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TesteCliente();
        TesteProduto();
        TesteEstoque();
        TestePedido();
    }

    private void TesteCliente() {
        clienteRepository.deleteAll();

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco("Avenida Dra Ruth Cardoso", "7221", "5o Andar", "05425-902", "São Paulo", "SP"));
        enderecos.add(new Endereco("Rua Cenno Sbrighi", "170", "5o Andar", "05036-010", "São Paulo", "SP"));
        enderecos.add(new Endereco("Rua Aurélia", "628", "", "05036-010", "São Paulo", "SP"));

        clienteRepository.save(new Cliente("Cliente 1", "cpf1", enderecos));

        clienteRepository.save(new Cliente("Cliente 2", "cpf2", enderecos));


        System.out.println("Cliente:");
        System.out.println("");
        System.out.println("findAll");
        List<Cliente>  lista = clienteRepository.findAll();

        for (Cliente cliente : lista) {
            System.out.println(" - " + cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getCpf());
        }

        System.out.println("");
        System.out.println("findById");

        Cliente clienteGet = lista.get(0);

        Optional<Cliente> optCliente = clienteRepository.findById(clienteGet.getId());
        if (optCliente.isPresent())
            System.out.println(" - " + optCliente.get().getNome());
        else
            System.out.println("Não encontrado.");

        System.out.println("");
        System.out.println("findByCpf");
        Cliente cliente1 = clienteRepository.findByCpf("cpf1");
        System.out.println(" - " + cliente1.getCpf());

        System.out.println("");
        System.out.println("findByNomeLike -> Cli");

        lista = clienteRepository.findByNomeLike("Cli");
        for (Cliente cliente : lista) {
            System.out.println("Like : " + cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getCpf());
        }


    }

    private void TesteProduto() {
        produtoRepository.deleteAll();

        produtoRepository.save(new Produto("001", "Produto 001", 10.00));
        produtoRepository.save(new Produto("002", "Produto 002", 20.00));
        produtoRepository.save(new Produto("003", "Produto 003", 30.00));

        System.out.println("");
        System.out.println("Produtos");
        System.out.println("");
        System.out.println("findAll");
        List<Produto> produtos = produtoRepository.findAll();

        for (Produto produto : produtos) {
            System.out.println(" - " + produto.getCodigo() + " - " + produto.getNome());
        }
    }

    private void TesteEstoque() {
        estoqueRepository.deleteAll();
        int qtde = 1;
        List<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos) {
            estoqueRepository.save(new Estoque(produto, qtde));
            qtde++;
        }

        System.out.println("");
        System.out.println("Estoque");
        System.out.println("");
        System.out.println("findAll");
        List<Estoque> estoqueList = estoqueRepository.findAll();
        for (Estoque estoque : estoqueList) {
            Produto produto = estoque.getProduto();
            System.out.println(produto.getCodigo() + " - " + produto.getNome() + " - " + produto.getValor() + " - " + estoque.getQuantidade());
        }
    }

    private void TestePedido(){
    	pedidoRepository.deleteAll();

    	List<Cliente> clientes = clienteRepository.findAll();

    	for (Cliente cliente : clientes){
    		List<Produto> produtos = produtoRepository.findAll();

    		int qtde = 1;

			List<ItemPedido> itemPedidoList = new ArrayList<>();
    		for(Produto produto : produtos){
    			itemPedidoList.add(new ItemPedido(produto, qtde	));
    			qtde ++;
			}
    		pedidoRepository.save(new Pedido(new Date(), cliente, itemPedidoList));
		}

        System.out.println("");
        System.out.println("Pedido");
        System.out.println("");
        System.out.println("findAll");
    	List<Pedido> pedidoList = pedidoRepository.findAll();
    	for (Pedido pedido : pedidoList){

			System.out.println(pedido.getCliente().getNome() + " - " + pedido.getData() );

    		List<ItemPedido> itemPedidoList = pedido.getItemPedido();
    		for (ItemPedido itemPedido : itemPedidoList){
    			Produto produto = itemPedido.getProduto();
				System.out.println("--->" + produto.getCodigo() + " - " + produto.getNome() + " - " + itemPedido.getQuantidade());
			}
		}
	}
}
