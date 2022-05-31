package br.com.stefanini.dao;

import br.com.stefanini.models.Pessoa;
import br.com.stefanini.models.parser.PessoaParser;
import br.com.stefanini.repository.PessoaRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 21/09/2021 on 07:13
 */
@RequestScoped
public class PessoaDao {
    @PersistenceContext
    EntityManager em;

   @Inject
   PessoaRepository pr;

    /**@Transactional
    public int inserir(Pessoa pessoa)  {
        String nameQuery = "INSERIR_PESSOA";

        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("nome",pessoa.getNome());
        query.setParameter("sobrenome",pessoa.getSobrenome());
        query.setParameter("contato",pessoa.getContato());
        query.setParameter("email", pessoa.getEmail());
        query.setParameter("cargo", pessoa.getCargo());

        return query.executeUpdate();
    }*/
	@Transactional
    public void inserir(Pessoa pessoa)  {       
        pessoa.persistAndFlush();
    }

    /**public List<Pessoa> listar()  {
        String nameQuery = "LISTAR_PESSOA";
        TypedQuery<Pessoa> query = em
                .createNamedQuery(nameQuery, Pessoa.class);
        return query.getResultList();
    }*/

	public List<Pessoa> listar()  {
         StringBuilder hql = new StringBuilder();

         hql.append("select pessoa from Pessoa pessoa order by pessoa.nome");
         List<Pessoa> pessoas;
         TypedQuery<Pessoa> query = em.createQuery(hql.toString(), Pessoa.class);

         try {
             pessoas = query.getResultList();
         } catch (NoResultException e) {
             //TODO: handle exception
             pessoas = new ArrayList<>();
         }

        return pessoas;
    }

    @Transactional
    public void excluir(Pessoa pessoa) {
		Pessoa.deleteById(pessoa.getId());
	}

    @Transactional
	public void atualizarPessoa(Pessoa pessoa) {
		StringBuilder query = new StringBuilder();
        query
        .append("contato = '")
        .append(pessoa.getContato())
        .append("'")
        .append(", email = '")
        .append(pessoa.getEmail())
        .append("'")
        .append(",cargo = '")
        .append(pessoa.getCargo())
        .append("'")
        .append(" where id=?1");

		pr.update(query.toString(), pessoa.getId());
	}

	public Pessoa encontrarPessoaPorId(Long id) {
        return Pessoa.findById(id);
	}
}
