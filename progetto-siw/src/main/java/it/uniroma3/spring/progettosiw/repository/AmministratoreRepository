package it.uniroma3.spring.progettosiw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.progettosiw.model.Amministratore;

public interface AmministratoreRepository extends CrudRepository<Amministratore, Long>{

	public List<Amministratore> findByUsername(String username);
	public List<Amministratore> findByEmail(String email);

}
