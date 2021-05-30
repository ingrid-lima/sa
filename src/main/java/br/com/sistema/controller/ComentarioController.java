package br.com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.Comentario;
import br.com.sistema.repository.ComentarioRepository;

@Controller
public class ComentarioController {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	@GetMapping("/comentario/list")
	public String listComentario(Model model) {
		
		model.addAttribute("comentarios", comentarioRepository.findAll());
		return "comentario/list";
	}
	
	@GetMapping("/comentario/add")
	public String addcomentario(Model model) {
		model.addAttribute("comentario", new Comentario());
		return "comentario/add";
	}
	
	@PostMapping("/comentario/save")
	public String saveComentario(Comentario comentario) {
		try {
			if(comentario != null) {
				comentarioRepository.save(comentario);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/comentario/view/" + comentario.getId();
		
	}
	
	@GetMapping("/comentario/view/{id}")
	public String viewcomentario(@PathVariable long id, Model model) {
		model.addAttribute("comentario", comentarioRepository.findById(id));
		return "comentario/view";
	}
	
	@GetMapping("/comentario/edit/{id}")
	public String editComentario(@PathVariable long id, Model model) {
		model.addAttribute("comentario", comentarioRepository.findById(id));
		return "comentario/edit";
	}
	
	@GetMapping("/comentario/delete/{id}")
	public String deleteComentario(@PathVariable long id) {
		try {
			comentarioRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/comentario/list";
	}

}

