package br.com.stefanini.dto;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 23/09/2021 on 21:10
 */
public class ListarPessoaDto {

    private Long id;
    
    private String nome;

    private String sobrenome;

    private String email;

    private String contato;

    private String nomeEquipe;

    private String cargo;

    private Long idEquipe;

    public Long getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }
    
}
