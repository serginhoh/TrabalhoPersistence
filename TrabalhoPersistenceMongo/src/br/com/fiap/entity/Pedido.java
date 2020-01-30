package br.com.fiap.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Pedido  {
    @Id
    private String id;
    private Date data;
    @DBRef
    private Cliente cliente;
    private List<ItemPedido> itemPedido;

    public Pedido(Date data, Cliente cliente, List<ItemPedido> itemPedido) {
        super();
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = itemPedido;
    }

    public Pedido() { super(); }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
    
    
}
