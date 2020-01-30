package br.com.fiap.repository;

import br.com.fiap.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    public List<Pedido> findByData(String data);
}
