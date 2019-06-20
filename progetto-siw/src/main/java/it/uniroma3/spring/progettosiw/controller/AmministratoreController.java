package it.uniroma3.spring.progettosiw.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.spring.progettosiw.model.Album;
import it.uniroma3.spring.progettosiw.model.Fotografia;
import it.uniroma3.spring.progettosiw.model.Fotografo;
import it.uniroma3.spring.progettosiw.service.AlbumService;
import it.uniroma3.spring.progettosiw.service.AlbumValidator;
import it.uniroma3.spring.progettosiw.service.FotografiaService;
import it.uniroma3.spring.progettosiw.service.FotografiaValidator;
import it.uniroma3.spring.progettosiw.service.FotografoService;
import it.uniroma3.spring.progettosiw.service.FotografoValidator;
import it.uniroma3.spring.progettosiw.service.RichiestaUtilizzoService;

@Controller
public class AmministratoreController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private RichiestaUtilizzoService richiestaUtilizzoService;
	
	
	@Autowired
	private AlbumValidator albumValidator;
	
	@Autowired
	private FotografoValidator fotografoValidator;

	@Autowired
	private FotografiaService fotografiaService;
	
	@Autowired
	private FotografiaValidator fotografiaValidator;
	
	@RequestMapping(value= "/riceviRichiesteUtilizzo", method=RequestMethod.GET)
	public String getRichiesteUtilizzo(Model model) {
		model.addAttribute("richiesteUtilizzo", this.richiestaUtilizzoService.getAllRichiesteUtilizzo());
		return "richiestaUtlizzo.html";
	}
	
	@RequestMapping(value="/nuovoAlbum", method=RequestMethod.GET)
	public String creaNuovoAlbum(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		return "albumForm.html";
	}
	
	@RequestMapping(value="/nuovoFotografo", method=RequestMethod.GET)
	public String creaNuovoFotografo(Model model) {
		Fotografo fotografo = new Fotografo();
		model.addAttribute("fotografo",fotografo);
		return "fotografoForm.html";
	}
	
	@RequestMapping(value="/salvaNuovoAlbum", method = RequestMethod.POST)
	public String salvaNuovoAlbum(@Valid@ModelAttribute("album") Album album, @PathVariable ("id") Long id, Model model, BindingResult bindingResult) {
		Fotografo fotografo = album.getFotografo();
		fotografo.getAlbum().add(album);
		
		this.albumValidator.validate(album, bindingResult);
		
		//se non ci sono errori inserisci dati album
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("fotografo", fotografo);
			return "fotografo.html";
		}
		else
			return "albumForm.html";
	}
	
	@RequestMapping(value="/salvaNuovoFotografo", method = RequestMethod.POST)
	public String salvaNuovoFotografo(@Valid@ModelAttribute("fotografo") Fotografo fotografo, @PathVariable ("id") Long id, Model model, BindingResult bindingResult) {
		
		this.fotografoValidator.validate(fotografo, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.fotografoService.inserisci(fotografo);
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "fotografi.html";
		}
		else
			return "fotografoForm.html";
	}
	
	
	@RequestMapping("/loginAmministratore")
	public String login() {
		return "loginAmministratore.html";
	}
	
	@RequestMapping("/amministratore")
	public String paginaAmm(){
		return "amministratore.html";
	}
	
	@RequestMapping(value="/salvaNuovaFoto", method = RequestMethod.POST)
	public String salvaNuovoFoto(@Valid@ModelAttribute("foto") Fotografia fotografia, Model model, BindingResult bindingResult) {
		
		this.fotografiaValidator.validate(fotografia, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("fotos", this.fotografiaService.tutti());
			return "tutteFoto.html";
		}
		else
			return "addFoto.html";
	}
	
	@RequestMapping(value="/admin/foto")
	public String aggiungiFoto(Model model) {
		model.addAttribute("foto", new Fotografia());
		model.addAttribute("fotografi",this.fotografoService.tutti());
		model.addAttribute("albums",this.albumService.tutti());
	
		return "addFoto.html";
	}
	
	
	public static String carica(int count) {
		String ALPHA_NUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		}
		
		@RequestMapping(value = "/amm/foto/uploadFile", method = RequestMethod.POST)
		public String uploadFile(
		    @RequestParam("uploadfile") MultipartFile uploadfile,Model model) {
		  
			if(!"image/jpeg".equals(uploadfile.getContentType())) {
					String errore = "Estensione non valida";
					model.addAttribute("info",errore);
				    return "addFoto.html";
				  
			}
			else {
		
			String uploadDirectory = Paths.get(".")+ "/src/main/resources/static" +"/upload/";
			 
		
			
		  try {
			  
		    String filename = carica(64)+".jpeg";
		    
		    
		   //salvo in locale
		    BufferedOutputStream stream =
		        new BufferedOutputStream(new FileOutputStream(new File(uploadDirectory+filename)));
		    stream.write(uploadfile.getBytes());
		
		    stream.close();
		    model.addAttribute("path",filename);
		    model.addAttribute("foto",new Fotografia());
		    model.addAttribute("fotografi",this.fotografoService.tutti());
		    model.addAttribute("albums",this.albumService.tutti());
		    return "addFoto2.html";
		  }
			
		  catch (Exception e) {
			 String errore="errore nel caricamento";
		    model.addAttribute("info",errore);
		    return "addFoto.html";
		  }
		 
		} 

		}
}
