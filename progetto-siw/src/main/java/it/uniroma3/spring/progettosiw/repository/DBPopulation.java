/*package it.uniroma3.spring.progettosiw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.spring.progettosiw.model.Amministratore;
import it.uniroma3.spring.progettosiw.model.Fotografo;
import it.uniroma3.spring.progettosiw.model.RichiestaUtilizzo;


@Component
public class DBPopulation implements ApplicationRunner{

	@Autowired
	private AmministratoreRepository amministratoreRepository;
	
	@Autowired
	private FotografoRepository fotografoRepository; 
	
	@Autowired
	private FotografiaRepository fotografiaRepository; 
	
	@Autowired
	private RichiestaUtilizzoRepository richiestaUtilizzoRepository; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAllAmministratori();
		this.addAllAmministratori();
		this.deleteAllFotografi();
		this.addAllFotografi();
		this.deleteAllFotografie();
		this.addAllFotografie();
		this.deleteAllRichiesteUtilizzo();
		this.addAllRichiesteUtilizzo();
	}
	
	
	
	private void deleteAllAmministratori() {
		this.amministratoreRepository.deleteAll();
	}



	private void addAllAmministratori() {
		System.out.print("Aggiungo ammnistratori");
		Amministratore am1 = new Amministratore();
		am1.setUsername("antonio");
		am1.setEmail("antonio@gmail.com");
		am1.setPassword("antalb_");
		this.amministratoreRepository.save(am1);
	}
	
	
	private void deleteAllFotografi() {
	this.fotografoRepository.deleteAll();	
	}
	
	
	private void addAllFotografi() {
		System.out.print("Aggiungi fotografi");
		Fotografo f1 = new Fotografo(1l,"Erica", "Garg", "gargerica@hotmail.com");
		Fotografo f3 = new Fotografo(2l,"Noemi", "Fraternali", "noemifraternali@gmail.com");
		Fotografo f2 = new Fotografo(3l,"Daniela", "Matrogiuseppe", "danielamastro@gmail.com");
		Fotografo f4 = new Fotografo(4l,"Alessio", "Bianchi", "alessiobianchi@hotmail.it");
		fotografoRepository.save(f1);
		fotografoRepository.save(f2);
		fotografoRepository.save(f3);
		fotografoRepository.save(f4);

	
	}
	
	
	private void deleteAllFotografie() {
		this.fotografiaRepository.deleteAll();

	}
	
	
	private void addAllFotografie() {
		
		
	}
	
	private void addAllRichiesteUtilizzo() {
		System.out.print("Aggiungi richieste");
		RichiestaUtilizzo us1 = new RichiestaUtilizzo(1l, "mario", "rossi", "mr@gmail.com");
		RichiestaUtilizzo us2 = new RichiestaUtilizzo(2l, "giuseppe", "verdi", "gv@gmail.com");
		richiestaUtilizzoRepository.save(us1);
		richiestaUtilizzoRepository.save(us2);
		
	}




	private void deleteAllRichiesteUtilizzo() {
		this.richiestaUtilizzoRepository.deleteAll();
	}


}

*/
