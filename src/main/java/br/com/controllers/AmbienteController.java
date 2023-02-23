package br.com.controllers;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.models.Ambiente;
import br.com.services.AmbienteService;

@Path("/api/ambiente")
public class AmbienteController {
	
	@Inject
	private AmbienteService ambienteService;

	@GET
	public List<Ambiente> buscarTodos() {
		return ambienteService.buscarTodos();
	}

	@GET
	@Path("{id}")
	public Optional<Ambiente> obterPorId(Long id) {
		
		return ambienteService.obterPorId(id);
	}

	@Transactional
	@POST
	public void adicionar(Ambiente ambiente) {
		ambienteService.adicionar(ambiente);
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, Ambiente ambiente) {
		return ambienteService.update(id, ambiente);
	}

	@Operation(summary = "Endpoint responsável por deletar um cliente")
	@DELETE
	@Transactional
	@Path("{id}")
	public void deletar(Long id) {
		Optional<Ambiente> ambientedel = Ambiente.findByIdOptional(id);

		ambientedel.ifPresentOrElse(Ambiente::delete, () -> {
			throw new NotFoundException();
		});
		

	}

}
