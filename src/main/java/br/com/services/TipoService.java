package br.com.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.models.Tipo;
import br.com.repository.TipoRepository;

@ApplicationScoped
public class TipoService {
	
	@Inject
	private TipoRepository tipoRepository;

	public List<Tipo> buscarTodos() {

		return tipoRepository.findAll().list();
	}

	public Optional<Tipo> obterPorId(Long id) {

		return tipoRepository.findByIdOptional(id);

	}

	public void adicionar(Tipo tipo) {
		tipoRepository.persist(tipo); // salva o objeto no banco
	}

	public Response update(long id, Tipo tipo) {
		Tipo entity = tipoRepository.findById(id);

		entity.setCategoria(tipo.getCategoria());

		return Response.ok(entity).build();
	}

	
}
