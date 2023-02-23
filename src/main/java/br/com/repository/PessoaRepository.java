package br.com.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.models.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{

}
