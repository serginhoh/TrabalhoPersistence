package br.com.fiap.repository;

import br.com.fiap.entity.Estoque;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstoqueRepository extends MongoRepository<Estoque, String> {
    public Estoque findByProduto(String Produto);
}
