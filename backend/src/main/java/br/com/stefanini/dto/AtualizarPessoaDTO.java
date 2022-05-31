package br.com.stefanini.dto;

import java.io.Serializable;

import br.com.stefanini.models.Equipe;

public class AtualizarPessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String contato;
	
	private String email;
	
	private String cargo;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
