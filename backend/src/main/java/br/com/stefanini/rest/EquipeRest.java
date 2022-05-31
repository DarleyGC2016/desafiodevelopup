package br.com.stefanini.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.dto.AtualizarPessoaDTO;
import br.com.stefanini.dto.EquipeDTO;
import br.com.stefanini.exceptions.ErroNegocialException;
import br.com.stefanini.models.Equipe;
import br.com.stefanini.models.Pessoa;
import br.com.stefanini.services.EquipeService;

@RequestScoped
@Path("/equipe")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EquipeRest {
    //./mvnw compile quarkus:dev
	@Inject
	EquipeService service;
	
    @POST
    @Operation(summary = "Insere uma equipe",
            description = "Com os dados faz a validação e insereção na base de dados")
    @APIResponse(
            responseCode = "201",
            description = "Equipe",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EquipeDTO.class))})
    public Response inserirEquipe(EquipeDTO equipe) throws Exception {
        service.inserir(equipe);
        return  Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/listar")
    @Operation(summary = "Listar Equipe",
            description = "Retorna uma lista de equipes sem a necessidade de parametros")
    @APIResponse(
            responseCode = "200",
            description = "Equipe",
            content = { @Content(mediaType = "application/json",
                          schema = @Schema(implementation = EquipeDTO.class, type = SchemaType.ARRAY))})
    public Response listar() {
   
        return Response.status(Response.Status.OK).entity(service.listar()).build();
        
    }
    
    @PUT
    @Path("/editar/{id}")
    @Operation(summary = "Listar Equipe",
    description = "Retorna uma lista de equipes sem a necessidade de parametros")
    @APIResponse(
			    responseCode = "200",
			    description = "Equipe",
			    content = { @Content(mediaType = "application/json",
			                  schema = @Schema(implementation = EquipeDTO.class, type = SchemaType.ARRAY))})
    public Response updateEquipe(@PathParam("id") Long id, EquipeDTO equipe) {
        
    	equipe.setId(id);
    	service.updateEquipe(equipe);

    	return Response
                      .status(Response.Status.OK)
    		      .build();
    }
    
    @GET
    @Path("{id}") 
    @Operation(summary = "buscar uma pessoa por id",
            description = "Retorna uma lista de equipes sem a necessidade de parametros")
    @APIResponse(
            responseCode = "200",
            description = "equipe",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EquipeDTO.class))})
    public Response findById (@PathParam("id") Long id) {
    	
        return  Response.status(Response.Status.OK).entity(service.findById(id)).build();
    }
}
