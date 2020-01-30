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
		enderecos.add(new Endereco("1", "Rua 1", "Cidade 1"));
		enderecos.add(new Endereco("2", "Rua 2", "Cidade 2"));

		clienteRepository.save(new Cliente("1", "Cliente 1", "cpf1", enderecos));

		clienteRepository.save(new Cliente("2", "Cliente 2", "cpf2", enderecos));
		
		Cliente optCliente = clienteRepository.findById("1").get();

		System.out.println(optCliente.getNome());

		optCliente = clienteRepository.findByCpf("cpf1");
		System.out.println(optCliente.getCpf());

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
