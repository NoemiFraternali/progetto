package it.uniroma3.spring.progettosiw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String usernme;
	private String password;
	private String email;
	
	
	
	public Utente(Long id, String usernme, String password, String email) {
		super();
		this.id = id;
		this.usernme = usernme;
		this.password = password;
		this.email = email;
	}

	public enum Role {
		ROLE_USER
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsernme() {
		return usernme;
	}

	public void setUsernme(String usernme) {
		this.usernme = usernme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


}
