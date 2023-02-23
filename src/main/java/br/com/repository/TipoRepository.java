package br.com.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.models.Tipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TipoRepository implements PanacheRepository<Tipo>{

}
