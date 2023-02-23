package br.com.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.models.Ambiente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AmbienteRepository implements PanacheRepository<Ambiente>{

}
