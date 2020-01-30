package br.com.fiap.repository;

import br.com.fiap.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    public Pedido findByData(String data);
}
