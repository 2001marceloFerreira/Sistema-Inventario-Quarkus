package br.com.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.models.Ambiente;
import br.com.models.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{

//	List<Produto> findByAmbiente(Ambiente ambiente);
}
