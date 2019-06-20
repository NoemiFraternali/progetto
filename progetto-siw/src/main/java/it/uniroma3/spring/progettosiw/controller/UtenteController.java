package it.uniroma3.spring.progettosiw.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.progettosiw.model.RichiestaUtilizzo;
import it.uniroma3.spring.progettosiw.model.Album;
import it.uniroma3.spring.progettosiw.service.AlbumService;
import it.uniroma3.spring.progettosiw.service.FotografiaService;
import it.uniroma3.spring.progettosiw.service.FotografoService;
import it.uniroma3.spring.progettosiw.service.RichiestaUtilizzoService;
import it.uniroma3.spring.progettosiw.service.RichiestaUtilizzoValidator;

@Controller
public class UtenteController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private FotografoService fotografoService;

	@Autowired
	private FotografiaService fotografiaService;


	@Autowired
	private RichiestaUtilizzoService richiestaService;

	@Autowired
	private RichiestaUtilizzoValidator richiestaValidator;

	@RequestMapping(value="/album/{id}", method=RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		Album album = this.albumService.albumById(id);
		model.addAttribute("album", album);
		model.addAttribute("foto", album.getFotografie());
		return "album.html";
	}

	@RequestMapping(value="/fotografo/{id}", method=RequestMethod.GET)
	public String getFotografo(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("fotografo", this.fotografoService.fotografoPerId(id));
		model.addAttribute("album", this.albumService.albumById(id));
		return "fotografo.html";
	}

	@RequestMapping(value="/fotografi")
	public String stampaFotografi(Model model) {
		model.addAttribute("fotografi", fotografoService.tutti());
		return "fotografi.html";
	}
	
	@RequestMapping(value="/album")
	public String stampaAlbum(Model model) {
		model.addAttribute("album", albumService.tutti());
		return "album.html";
	}

	
	@RequestMapping(value="/iniziaRichiestaUtilizzo", method=RequestMethod.POST)
	public String iniziaRichiesta(@ModelAttribute("richiestaUtilizzo") RichiestaUtilizzo richiesta, Model model,  BindingResult bindingResult) {

		this.richiestaValidator.validate(richiesta, bindingResult);

		if(!bindingResult.hasErrors()) {
			richiesta.setData(LocalDate.now());
			this.richiestaService.add(richiesta);
		}

		model.addAttribute("foto", this.fotografiaService.tutti());
		return "richiestaUtilizzoForm.html";
	}
}
