package br.com.fiap.entity;


import javax.naming.OperationNotSupportedException;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


public class Estoque  {
    @Id
    private String id;
	@DBRef
	private Produto produto;
	private int quantidade;

	public Estoque(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Estoque() {
		super();
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void adicionarAoEstoque(int quantidade) {
		this.quantidade += quantidade;
	}

	public void retirarDoEstoque(int quantidade) throws OperationNotSupportedException {
		if (this.quantidade < quantidade)
			throw new OperationNotSupportedException("N�o � poss�vel utilizar mais itens do que existem no estoque.");

		this.quantidade -= quantidade;
	}

}
