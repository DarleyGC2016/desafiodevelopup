package br.com.stefanini.rest;

import br.com.stefanini.dto.AtualizarPessoaDTO;
import br.com.stefanini.dto.ListarPessoaDto;
import br.com.stefanini.dto.NovaPessoaDto;
import br.com.stefanini.exceptions.ErroNegocialException;
import br.com.stefanini.models.Pessoa;
import br.com.stefanini.services.PessoaService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 21/09/2021 on 07:10
 */
@RequestScoped
@Path("/pessoa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaRest {
	
    @Inject
    PessoaService service;
    
    @POST
    @Transactional
    @Operation(summary = "Insere uma pessoa",
            description = "Com os dados faz a validação e insereção na base de dados")
    @APIResponse(
            responseCode = "201",
            description = "Pessoa",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = NovaPessoaDto.class))})
    public Response inserirPessoa(NovaPessoaDto pessoa)  {
        service.inserir(pessoa);
        return  Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Operation(summary = "Listar Pessoas",
            description = "Retorna uma lista de pessoas sem a necessidade de parametros")
    @APIResponse(
            responseCode = "200",
            description = "Pessoa",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ListarPessoaDto.class, type = SchemaType.ARRAY))})
    public Response listarPessoa() throws ErroNegocialException {
    	service.listar();
       return  Response.status(Response.Status.OK).entity(service.listar()).build();
    }
    
    @DELETE
    @Path("excluir/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Excluir uma pessoa",
            description = "Só pode exluir uma pessoa se não tiver uma equipe")
    @APIResponse(
            responseCode = "202",
            description = "Pessoa",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Pessoa.class))})
    public Response deletePessoa(@PathParam("id") Long id) {
    	service.excluir(id);
    	return Response.status(Response.Status.ACCEPTED).build();
    }
    
    @PUT
    @Path("editar/{id}")    
    @Operation(summary = "Atualizar uma pessoa",
            description = "Editar dados do funcionario")
    @APIResponse(
            responseCode = "200",
            description = "Pessoa",
            content = { @Content(mediaType = "application/json",
                         schema = @Schema(implementation = AtualizarPessoaDTO.class))
                       }
    )
    public Response atualizarPessoa(@PathParam("id") Long id, AtualizarPessoaDTO pessoa) {

    	
    	service.atualizarPessoa(id,pessoa);

    	return Response
                      .status(Response.Status.OK)
    		      .build();
    }
 
    @GET
    @Path("{id}") 
    @Operation(summary = "buscar uma pessoa por id",
            description = "Retorna uma lista de pessoas sem a necessidade de parametros")
    @APIResponse(
            responseCode = "200",
            description = "Pessoa",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AtualizarPessoaDTO.class))})
    public Response buscarItemID (@PathParam("id") Long id) {
         //System.out.println("id busca: "+service.encontrarPessoaPorId(id));
        return  Response.status(Response.Status.OK).entity(service.encontrarPessoaPorId(id)).build();
    }
}
