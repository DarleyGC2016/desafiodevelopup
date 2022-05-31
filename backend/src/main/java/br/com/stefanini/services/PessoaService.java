package br.com.stefanini.services;

import br.com.stefanini.dao.PessoaDao;
import br.com.stefanini.dto.AtualizarPessoaDTO;
import br.com.stefanini.dto.ListarPessoaDto;
import br.com.stefanini.dto.NovaPessoaDto;
import br.com.stefanini.exceptions.EnumMensagens;
import br.com.stefanini.exceptions.ErroNegocialException;
import br.com.stefanini.models.Equipe;
import br.com.stefanini.models.Pessoa;
import br.com.stefanini.models.parser.PessoaParser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 21/09/2021 on 07:11
 */
@RequestScoped
public class PessoaService {


    @Inject
    PessoaDao dao;

    @Inject
    EquipeService es;

    @Transactional(rollbackOn = Exception.class)
    public void inserir(NovaPessoaDto pessoaDto) {
        
        /*this.validar(pessoaDto);
        this.validaEmailDuplicado(pessoaDto.getEmail());*/

         //validarPessoa(pessoaDto);
         
         Equipe equipe = es.findById(pessoaDto.getEquipe());
         Pessoa pessoa = PessoaParser
                            .get()
                            .entidadeNovaPessoa(pessoaDto,equipe);  
         dao.inserir(pessoa);
    }

    private void validarPessoa(Pessoa pessoa){
        if(pessoa == null) {
            throw new NotFoundException("Não foi possivel cadastrar Um pessoa");
        }else{           
             dao.inserir(pessoa);
        }
    }

    public List<ListarPessoaDto> listar() throws ErroNegocialException {
                
        return dao
                 .listar()
                 .stream()
                 .map(PessoaParser.get()::dto)
                 .collect(Collectors.toList());
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
        if(pessoaDto.getCargo() == null ){
            throw new NotFoundException();
        }

    }
    
    private void validaEmailDuplicado(String email){
        System.out.println("validaEmailDuplicado: "+email);
    }
    
    public void excluir (Long id) {
        Pessoa pessoa = dao.encontrarPessoaPorId(id);    
        
        if(pessoa.getId().longValue()>0){
            System.out.println(pessoa.getId());
            System.out.println(pessoa.getNome());  
            dao.excluir(pessoa);
        }
    }

    @Transactional(rollbackOn = Exception.class)
	public void atualizarPessoa(Long id, AtualizarPessoaDTO pessoaAtualizarPessoaDTO) {
       
    	pessoaAtualizarPessoaDTO.setId(id);
		Pessoa pessoa = PessoaParser
				                   .get()
				                   .editarEntidade(pessoaAtualizarPessoaDTO);
		
		dao.atualizarPessoa(pessoa);
		
	}
    
    public AtualizarPessoaDTO encontrarPessoaPorId(Long id) {
    	//PessoaParser.get().antesEditarEntidade(dao.encontrarPessoaPorId(id));
    	/**if(pessoa ==  null) {
    		throw new NotFoundException();
    	}*/
        
		return PessoaParser.get().antesEditarEntidade(dao.encontrarPessoaPorId(id));
    }

    
}
