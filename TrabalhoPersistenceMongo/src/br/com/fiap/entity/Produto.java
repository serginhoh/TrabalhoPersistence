package br.com.fiap.entity;

import org.springframework.data.annotation.Id;

public class Produto {
	@Id
	private String id;
	private String codigo;
	private String nome;
	private double valor;

	public Produto(String id, String codigo, String nome, double valor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public Produto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
