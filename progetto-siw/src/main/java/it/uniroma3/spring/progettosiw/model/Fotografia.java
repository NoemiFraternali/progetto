package it.uniroma3.spring.progettosiw.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Fotografia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titolo;
	private float prezzo;
	private String path;
	
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	private Album album;
	
	@ManyToOne
	private Fotografo fotografo;

	public Fotografia(Long id, String categoria, float prezzo, Album album, Fotografo fotografo) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.album = album;
		this.fotografo = fotografo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}	
	

}
