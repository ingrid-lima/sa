package br.com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.Classificacao;
import br.com.sistema.repository.ClassificacaoRepository;

@Controller
public class ClassificacaoController {
	
	@Autowired
	ClassificacaoRepository classificacaoRepository;
	
	@GetMapping("/classificacao/list")
	public String listClassificacao(Model model) {
		
		model.addAttribute("classificacaos", classificacaoRepository.findAll());
		return "classificacao/list";
	}
	
	@GetMapping("/classificacao/add")
	public String addClassificacao(Model model) {
		model.addAttribute("classificacao", new Classificacao());
		return "classificacao/add";
	}
	
	@PostMapping("/classificacao/save")
	public String saveClassificacao(Classificacao classificacao) {
		try {
			if(classificacao != null) {
				classificacaoRepository.save(classificacao);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/classificacao/view/" + classificacao.getId();
		
	}
	
	@GetMapping("/classificacao/view/{id}")
	public String viewClassificacao(@PathVariable long id, Model model) {
		model.addAttribute("classificacao", classificacaoRepository.findById(id));
		return "classificacao/view";
	}
	
	@GetMapping("/classificacao/edit/{id}")
	public String editClassificacao(@PathVariable long id, Model model) {
		model.addAttribute("classificacao", classificacaoRepository.findById(id));
		return "classificacao/edit";
	}
	
	@GetMapping("/classificacao/delete/{id}")
	public String deleteClassificacao(@PathVariable long id) {
		try {
			classificacaoRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/classificacao/list";
	}

}

