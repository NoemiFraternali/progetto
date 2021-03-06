package it.uniroma3.spring.progettosiw.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.model.RichiestaUtilizzo;
import it.uniroma3.siw.repository.RichiestaUtilizzoRepository;

@Service
public class RichiestaUtilizzoService {
	
	@Autowired
	private RichiestaUtilizzoRepository richiestaUtilizzoRepository;
	
	public Collection<RichiestaUtilizzo> getAllRichiesteUtilizzo() {
		return this.richiestaUtilizzoRepository.findAll();
	}
	
	public void add(RichiestaUtilizzo richiesta) {
		this.richiestaUtilizzoRepository.save(richiesta);
	}

}
