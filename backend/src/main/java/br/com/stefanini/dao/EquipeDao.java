package br.com.stefanini.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.stefanini.dto.EquipeDTO;
import br.com.stefanini.models.Equipe;
import br.com.stefanini.repository.EquipeRepository;

@RequestScoped
public class EquipeDao {
	
    @PersistenceContext
    EntityManager em;

    @Inject
    EquipeRepository er;

    @Transactional
    public void inserir(Equipe equipe)  {
       equipe.persistAndFlush();
    }

    public Equipe findById(Long id) {
        Equipe equipe = er.findById(id);
        return equipe;
    }

    public List<Equipe> listar() {
        StringBuilder hql = new StringBuilder();

         hql.append("from Equipe equipe order by equipe.nome");
         List<Equipe> equipes;
         TypedQuery<Equipe> query = em.createQuery(hql.toString(), Equipe.class);

         try {
             equipes = query.getResultList();
         } catch (NoSuchElementException e) {
             //TODO: handle exception
             equipes = new ArrayList<>();
         }

        return equipes;
    }

    @Transactional
	public void updateEquipe(Equipe equipe) {
		StringBuilder query = new StringBuilder();
        query
        .append("nome = '")
        .append(equipe.getNome())        
        .append("'")
        .append(" where id=?1");
        
		er.update(query.toString(), equipe.getId());
		
	}

}
