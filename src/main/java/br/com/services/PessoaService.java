package br.com.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.models.Pessoa;
import br.com.repository.PessoaRepository;

@ApplicationScoped
public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;

	public List<Pessoa> buscarTodos() {

		return pessoaRepository.findAll().list();
	}

	public Optional<Pessoa> obterPorId(Long id) {

		return pessoaRepository.findByIdOptional(id);

	}

	public void adicionar(Pessoa pessoa) {
		pessoaRepository.persist(pessoa); // salva o objeto no banco
	}

	public Response update(long id, Pessoa pessoa) {
		Pessoa entity = pessoaRepository.findById(id);

		entity.setNome(pessoa.getNome());
		entity.setEmail(pessoa.getEmail());
		entity.setCargo(pessoa.getCargo());
		entity.setTelefone(pessoa.getTelefone());

		return Response.ok(entity).build();
	}

}
