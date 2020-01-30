package br.com.fiap.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Pedido  {
    @Id
    private String id;
    private Date data;
    private Cliente cliente;
    private Endereco endereco;
    private List<ItemPedido> itemPedido;

    public Pedido(String id, Date data, Cliente cliente, Endereco endereco, List<ItemPedido> itemPedido) {
        super();
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
    
    
}
