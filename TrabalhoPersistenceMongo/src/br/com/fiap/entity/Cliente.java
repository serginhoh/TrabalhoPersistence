package br.com.fiap.entity;


import org.springframework.data.annotation.Id;

import java.util.List;

public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private List<Endereco> endereco;

    public Cliente(String nome, String cpf, List<Endereco> endereco) {
        super();
         this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
    
}
