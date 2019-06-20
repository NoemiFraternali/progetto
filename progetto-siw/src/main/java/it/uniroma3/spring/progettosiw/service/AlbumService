package it.uniroma3.spring.progettosiw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.progettosiw.model.Album;
import it.uniroma3.spring.progettosiw.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional
	public Album inserisci(Album album) {
		return this.albumRepository.save(album);
	}
	
	@Transactional
	public List<Album> tutti(){
		return (List<Album>) albumRepository.findAll();
	}
	
	
	public Album albumById(Long id) {
		return this.albumRepository.findById(id).orElse(null);
	}


	
}
