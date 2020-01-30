package br.com.fiap.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.repository.ClienteRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ClienteRepository.class)
public class Application implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clienteRepository.deleteAll();

		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new Endereco("Avenida Dra Ruth Cardoso", "7221", "5o Andar", "05425-902", "São Paulo", "SP"));
		enderecos.add(new Endereco("Rua Cenno Sbrighi", "170", "5o Andar", "05036-010", "São Paulo", "SP"));
		enderecos.add(new Endereco("Rua Aurélia", "628", "", "05036-010", "São Paulo", "SP"));

		clienteRepository.save(new Cliente("Cliente 1", "cpf1", enderecos));

		clienteRepository.save(new Cliente( "Cliente 2", "cpf2", enderecos));
		
		Optional<Cliente> optCliente = clienteRepository.findById("1");
		if (optCliente.isPresent())
			System.out.println(optCliente.get().getNome());
		else
			System.out.println("Não encontrado.");

		Cliente cliente1 = clienteRepository.findByCpf("cpf1");
		System.out.println(cliente1.getCpf());

		List<Cliente> lista = clienteRepository.findByNomeLike("Cli");
		for (Cliente cliente : lista) {
			System.out.println("Like : " + cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getCpf() );
		}

		lista = clienteRepository.findAll();

		for (Cliente cliente : lista) {
			System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getCpf() );
		}

	}

}
