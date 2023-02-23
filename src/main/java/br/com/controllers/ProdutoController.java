package br.com.controllers;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.models.Ambiente;
import br.com.models.Produto;
import br.com.services.ProdutoService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("/api/produto")
public class ProdutoController {

	@Inject
	private ProdutoService produtoService;

	@GET
	@Counted
	@Timed
	public List<Produto> buscarTodos() {
		return produtoService.buscarTodos();
	}

	@GET
	@Path("{id}")
	public Optional<Produto> obterPorId(Long id) {
		return produtoService.obterPorId(id);
	}

	@Transactional
	@POST
	public void adicionar(@Valid Produto produto) {
		produtoService.adicionar(produto);
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, Produto produto) {
		return produtoService.update(id, produto);
	}

	@Operation(summary = "Endpoint responsável por deletar um cliente")
	@DELETE
	@Transactional
	@Path("{id}")
	public void deletar(Long id) {
		Optional<Produto> produtodel = Produto.findByIdOptional(id);
		
		produtodel.ifPresentOrElse(Produto::delete, ()->{
			throw new NotFoundException();
		});
//		Reponse
//		produtoService.deletar(id);
//		return Response.ok().build();

	}


	@Operation(summary = "Endpoint responsável por buscar um produto pelo codigo")
	@GET
	@Path("/codigo/{codigo}")
	public Response obterPorCodigo(String codigo) {

		List<Produto> p = Produto.list("codigo =?1", codigo);
		System.out.println(p);

		return Response.ok(p).build();
	}
	
	@GET
	@Path("/situacao/{situacao}")
	public Response obterValor(String situacao) {

		List<Produto> p = Produto.list("situacao =?1", situacao);
		System.out.println(p);

		return Response.ok(p).build();
	}

	
	@GET
	@Path("/ambiente/")
	public List<Produto> getAcessosPorAmbiente(@QueryParam("ambiente") String ambiente) {
		PanacheQuery<Ambiente> a =  Ambiente.find("Select id FROM Ambiente WHERE ambiente = '" + ambiente + "'");
		Ambiente b = Ambiente.findById(a.singleResult());
		return Produto.find("ambiente = ?1 ", b)
				.list();
	}


}
