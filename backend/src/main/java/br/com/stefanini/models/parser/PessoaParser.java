package br.com.stefanini.models.parser;

import br.com.stefanini.dto.AtualizarPessoaDTO;
import br.com.stefanini.dto.ListarPessoaDto;
import br.com.stefanini.dto.NovaPessoaDto;
import br.com.stefanini.models.CargoEnum;
import br.com.stefanini.models.Equipe;
import br.com.stefanini.models.Pessoa;

public class PessoaParser {

	public static PessoaParser get() {
		return new PessoaParser();
	}
	
	public Pessoa editarEntidade(AtualizarPessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(dto.getId());
		pessoa.setContato(dto.getContato());
		pessoa.setEmail(dto.getEmail());
		pessoa.setCargo(CargoEnum.findByCargo(dto.getCargo()));
		return pessoa;
	}

	public AtualizarPessoaDTO antesEditarEntidade(Pessoa pessoa) {
		AtualizarPessoaDTO dto = new AtualizarPessoaDTO();
		dto.setId(pessoa.getId());
		dto.setContato(pessoa.getContato());
		dto.setEmail(pessoa.getEmail());
		dto.setCargo(CargoEnum.findByCargoStr(pessoa.getCargo()));
		return dto;
	}
		
	public AtualizarPessoaDTO entidadePessoa(Pessoa pessoa) {
		AtualizarPessoaDTO atualizarPessoaDTO = new AtualizarPessoaDTO();
		atualizarPessoaDTO.setId(pessoa.getId());
		atualizarPessoaDTO.setContato(pessoa.getContato());
		atualizarPessoaDTO.setEmail(pessoa.getEmail());
		atualizarPessoaDTO.setCargo(pessoa.getCargo().getDescricao() );
		return atualizarPessoaDTO;
	}
	
	public Pessoa entidadeNovaPessoa (NovaPessoaDto pessoaDto) {
		Pessoa pessoa = new Pessoa();

		//pessoa.setId(pessoaDto.getId());
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setSobrenome(pessoaDto.getSobrenome());
		pessoa.setEmail(pessoaDto.getEmail());
		pessoa.setContato(pessoaDto.getContato());
		pessoa.setCargo(CargoEnum.findByCargo(pessoaDto.getCargo()));		
		return pessoa;		
	}

	public Pessoa entidadeExcluirPessoa (Pessoa pessoaDto) {
		Pessoa pessoa = new Pessoa();

		//pessoa.setId(pessoaDto.getId());
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setSobrenome(pessoaDto.getSobrenome());
		pessoa.setEmail(pessoaDto.getEmail());
		pessoa.setContato(pessoaDto.getContato());
		pessoa.setCargo(pessoaDto.getCargo());		
		return pessoa;		
	}

	public Pessoa entidadeNovaPessoa (NovaPessoaDto pessoaDto, Equipe equipe) {
		Pessoa pessoa = new Pessoa();

		//pessoa.setId(pessoaDto.getId());
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setSobrenome(pessoaDto.getSobrenome());
		pessoa.setEmail(pessoaDto.getEmail());
		pessoa.setContato(pessoaDto.getContato());
		pessoa.setCargo(CargoEnum.findByCargo(pessoaDto.getCargo()));
		pessoa.setEquipe(equipe);		
		return pessoa;		
	}
	
	public ListarPessoaDto dto(Pessoa pessoa){
		ListarPessoaDto pessoaDto = new ListarPessoaDto();
		pessoaDto.setId(pessoa.getId());
		pessoaDto.setNome(pessoa.getNome());
		pessoaDto.setSobrenome(pessoa.getSobrenome());
		pessoaDto.setContato(pessoa.getContato());
		pessoaDto.setCargo(pessoa.getCargo().getDescricao());
		pessoaDto.setEmail(pessoa.getEmail());
		pessoaDto.setIdEquipe(pessoa.getEquipe().getId());
		pessoaDto.setNomeEquipe(pessoa.getEquipe().getNome());
		return pessoaDto;

	}

	
}
