package it.uniroma3.spring.progettosiw.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.progettosiw.model.RichiestaUtilizzo;

public interface RichiestaUtilizzoRepository extends CrudRepository<RichiestaUtilizzo, Long>{

	public Collection<RichiestaUtilizzo> findAll();
}
