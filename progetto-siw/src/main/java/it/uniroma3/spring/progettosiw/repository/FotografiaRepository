package it.uniroma3.spring.progettosiw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.progettosiw.model.Fotografia;

public interface FotografiaRepository extends CrudRepository<Fotografia, Long>{
	
	public List<Fotografia> findByTitolo(String titolo);
	public List<Fotografia> findByPrezzo(Float prezzo);

	

}
