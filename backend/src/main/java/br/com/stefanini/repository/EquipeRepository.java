package br.com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.stefanini.models.Equipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EquipeRepository implements PanacheRepository<Equipe>{

}
