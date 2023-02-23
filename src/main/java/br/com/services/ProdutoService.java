package br.com.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.models.Ambiente;
import br.com.models.Produto;
import br.com.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos() {

		return produtoRepository.findAll().list();
	}

	public Optional<Produto> obterPorId(Long id) {

        return produtoRepository.findByIdOptional(id);

    }
	
	public void adicionar(Produto produto) {
		produtoRepository.persist(produto); // salva o objeto no banco
	}
	
	public Response update(long id, Produto produto) {
		Produto entity = produtoRepository.findById(id);

		entity.setPatrimonio(produto.getPatrimonio());
		entity.setDescricao(produto.getDescricao());
		entity.setSituacao(produto.getSituacao());
//		entity.setCodigo(produto.getCodigo());
//		entity.setDtCadastro(produto.getDtCadastro());
		entity.setValor(produto.getValor());
		entity.setAmbiente(produto.getAmbiente());
		entity.setTipo(produto.getTipo());
		entity.setPessoa(produto.getPessoa());
		

		return Response.ok(entity).build();
	}
	
//	public void deletar(Long id) {
//		produtoRepository.deleteById(id);
//	}
	
	
   
	
//	public List<Produto> obterPorAmbiente(Ambiente ambiente) {
//
//        return produtoRepository.findByAmbiente(ambiente);
//
//    }
	
}
