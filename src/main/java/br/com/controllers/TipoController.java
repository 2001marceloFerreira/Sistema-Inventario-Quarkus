package br.com.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.models.Tipo;
import br.com.services.TipoService;

@Path("/api/tipo")
public class TipoController {

	@Inject
	private TipoService tipoService;

	@GET
	public List<Tipo> buscarTodos() {
		return tipoService.buscarTodos();
	}

	@GET
	@Path("{id}")
	public Optional<Tipo> obterPorId(Long id) {
		return tipoService.obterPorId(id);
	}

	@Transactional
	@POST
	public void adicionar(Tipo tipo) {
		tipoService.adicionar(tipo);
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, Tipo tipo) {
		return tipoService.update(id, tipo);
	}

	@Operation(summary = "Endpoint responsável por deletar um cliente")
	@DELETE
	@Transactional
	@Path("{id}")
	public void deletar(Long id) {
		Optional<Tipo> tipodel = Tipo.findByIdOptional(id);

		tipodel.ifPresentOrElse(Tipo::delete, () -> {
			throw new NotFoundException();
		});
	}
}
