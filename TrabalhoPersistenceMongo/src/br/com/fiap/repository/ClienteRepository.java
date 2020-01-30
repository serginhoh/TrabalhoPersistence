package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Cliente;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
	public Cliente findByNome(String nome);
	public List<Cliente> findByNomeLike(String nome);
	public Cliente findByCpf(String cpf);
}
