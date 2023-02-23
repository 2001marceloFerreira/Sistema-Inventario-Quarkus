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

import br.com.models.Ambiente;
import br.com.models.Pessoa;
import br.com.services.PessoaService;

@Path("/api/pessoa")
public class PessoaController {

	@Inject
	private PessoaService pessoaService;

	@GET
	public List<Pessoa> buscarTodos() {
		return pessoaService.buscarTodos();
	}

	@GET
	@Path("{id}")
	public Optional<Pessoa> obterPorId(Long id) {
		return pessoaService.obterPorId(id);
	}

	@Transactional
	@POST
	public void adicionar(Pessoa pessoa) {
		pessoaService.adicionar(pessoa);
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, Pessoa pessoa) {
		return pessoaService.update(id, pessoa);
	}

	@Operation(summary = "Endpoint responsável por deletar um cliente")
	@DELETE
	@Transactional
	@Path("{id}")
	public void deletar(Long id) {
		Optional<Pessoa> pessoadel = Pessoa.findByIdOptional(id);
		
		pessoadel.ifPresentOrElse(Pessoa::delete, () -> {
			throw new NotFoundException();
			
		});
		
//		pessoaService.deletar(id);
//		return Response.ok().build();

	}
}
