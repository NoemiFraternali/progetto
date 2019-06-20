package it.uniroma3.spring.progettosiw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	public String nome;
	private Date dataPubblicazione;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	private Fotografo fotografoAlbum;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Fotografia> fotografieAlbum;
	
	public Album(Long id, String nome, Date dataPubblicazione, Fotografo fotografoAlbum) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataPubblicazione = dataPubblicazione;
		this.fotografoAlbum = fotografoAlbum;
	}

	

	public List<Fotografia> getFotografie() {
		return fotografieAlbum;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografieAlbum = fotografie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	
	
}
