package br.com.fiap.repository;

import br.com.fiap.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    public Produto findByCodigo(String codigo);
    public Produto findByNome(String nome);
}
