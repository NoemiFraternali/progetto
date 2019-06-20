package it.uniroma3.spring.progettosiw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Amministratore;
import it.uniroma3.siw.repository.AmministratoreRepository;

@Service
public class AmministratoreService {
	
	@Autowired
	private AmministratoreRepository amministratoreRepository;
	
	@Transactional 
	public Amministratore inserisci(Amministratore amministratore) {
		return amministratoreRepository.save(amministratore);
	}
	
	@Transactional
	public List<Amministratore> tutti(){
		return (List<Amministratore>)  amministratoreRepository.findAll();
	}

	public Amministratore amministratorePerId(Long id) {
		return this.amministratoreRepository.findById(id).get();
	}
	

}
