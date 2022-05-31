package br.com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.stefanini.models.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{
    
    
}
