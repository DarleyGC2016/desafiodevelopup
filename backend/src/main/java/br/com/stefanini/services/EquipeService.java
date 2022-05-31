package br.com.stefanini.services;

import br.com.stefanini.dao.EquipeDao;
import br.com.stefanini.dao.PessoaDao;
import br.com.stefanini.dto.AtualizarPessoaDTO;
import br.com.stefanini.dto.EquipeDTO;
import br.com.stefanini.exceptions.EnumMensagens;
import br.com.stefanini.exceptions.ErroNegocialException;
import br.com.stefanini.models.Equipe;
import br.com.stefanini.models.Pessoa;
import br.com.stefanini.models.parser.EquipeParser;
import br.com.stefanini.models.parser.PessoaParser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequestScoped
public class EquipeService {


    @Inject
    EquipeDao dao;

    @Transactional(rollbackOn = Exception.class)
    public void inserir(EquipeDTO  equipeDTO) {
     
      Equipe equipe =  EquipeParser.get().entity(equipeDTO);
       dao.inserir(equipe);
    }

    public Equipe findById(Long id){
        return dao.findById(id);
    }

    public List<EquipeDTO> listar() {
        
        return dao
               .listar()
               .stream()
               .map(EquipeParser.get()::dto)
               .collect(Collectors.toList());
    }

	public void updateEquipe(EquipeDTO equipeDTO) {
		
		
		Equipe equipe = EquipeParser.get().editarEntity(equipeDTO);
		dao.updateEquipe(equipe);
		
	}

    

    /**public List<Pessoa> listar() throws ErroNegocialException {
        //throw new ErroNegocialException(EnumMensagens.ERRO_SQL);
        return  dao.listar();
    }

    private void validar(Pessoa pessoaDto) throws NotFoundException{
        if(pessoaDto == null){
            throw new NotFoundException();
        }
        if(pessoaDto.getNome() == null ||  pessoaDto.getSobrenome() == null){
            throw new NotFoundException();
        }
        if(pessoaDto.getEmail() == null ){
            throw new NotFoundException();
        }
        if(pessoaDto.getContato() == null ){
            throw new NotFoundException();
        }
        if(pessoaDto.getCargo() == 0 ){
            throw new NotFoundException();
        }

    }
    
    private void validaEmailDuplicado(String email){
        System.out.println("validaEmailDuplicado: "+email);
    }
    
    public void excluir (Long id) {
    	dao.excluir(id);
    }

    @Transactional(rollbackOn = Exception.class)
	public void atualizarPessoa(Long id, AtualizarPessoaDTO pessoaAtualizarPessoaDTO) {
    	pessoaAtualizarPessoaDTO.setId(id);
		Pessoa pessoa = PessoaParser
				                   .get()
				                   .editarEntidade(pessoaAtualizarPessoaDTO);
		
		dao.atualizarPessoa(pessoa);
		
	}
    
    private Pessoa encontrarPessoaPorId(Long id) {
    	Pessoa pessoa = dao.encontrarPessoaPorId(id);
    	if(pessoa ==  null) {
    		throw new NotFoundException();
    	}
		return pessoa;
    }*/
}
