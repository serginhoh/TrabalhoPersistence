package br.com.fiap.entity;

import org.springframework.data.annotation.Id;


public class ItemPedido {
    @Id
    private String id;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;

    public ItemPedido(String id, Pedido pedido, Produto produto, int quantidade) {
        super();
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemPedido() { super(); }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
