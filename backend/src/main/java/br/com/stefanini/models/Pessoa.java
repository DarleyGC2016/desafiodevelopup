package br.com.stefanini.models;
import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 21/09/2021 on 06:35
 */
/***/
@Entity
@Table(name = "pessoa")
public class Pessoa extends PanacheEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 255, nullable = false)
    private String sobrenome;

    @Column(name = "contato", length = 200, nullable = false)
    private String contato;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "cargo", length = 25, nullable = true)
    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name="equipe_id")
    private Equipe equipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Pessoa: "+getId());
        sb.append("\nNome: "+getNome());
        sb.append("\nSobrenome: "+getSobrenome());
        sb.append("\n Contato: "+getContato());
        sb.append("\n Cargo: "+getCargo().name());
        sb.append("\nId da Equipe: "+getEquipe().getId());
        sb.append("\nNome da Equipe: "+getEquipe().getNome()+"\n");
        return sb.toString();
    }


}
