package br.com.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.models.Ambiente;
import br.com.repository.AmbienteRepository;

@ApplicationScoped
public class AmbienteService {
	
	@Inject
	private AmbienteRepository ambienteRepository;

	public List<Ambiente> buscarTodos() {

		return ambienteRepository.findAll().list();
	}

	public Optional<Ambiente> obterPorId(Long id) {

		return ambienteRepository.findByIdOptional(id);

	}

	public void adicionar(Ambiente ambiente) {
		ambienteRepository.persist(ambiente); // salva o objeto no banco
	}

	public Response update(long id, Ambiente ambiente) {
		Ambiente entity = ambienteRepository.findById(id);

		entity.setAmbiente(ambiente.getAmbiente());

		return Response.ok(entity).build();
	}


}
