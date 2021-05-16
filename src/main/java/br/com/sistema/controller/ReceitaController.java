package br.com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.Receita;
import br.com.sistema.repository.ReceitaRepository;


@Controller
public class ReceitaController {
	
	@Autowired
	ReceitaRepository  receitaRepository;
	

	@GetMapping("/receita/list/bolos")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("bolos")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/list/salgados")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("salgados")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/list/massas")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("massas")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/list/tortas")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("tortas")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/list/vegetarianos")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("vegetarianos")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/list/vegano")
	public String listReceita(Model model) {
		
		model.addAttribute("receitas", receitaRepository.findAll(Sort.by("vegano")));
		
		return "receita/list";
	}
	
	@GetMapping("/receita/add")
	public String addReceita(Model model) {
		
		model.addAttribute("receita", new Receita());
		System.out.println("ok");
		
		return "receita/add";
	}
	
	@PostMapping("/receita/save")
	public String saveReceita(Receita receita) {
		
		try {
			if(receita != null) {
				receitaRepository.save(receita);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		
		return "redirect:/receita/view/" + receita.getId();
		
	}
	
	@GetMapping("/receita/view/{id}")
	public String viewReceita(@PathVariable long id, Model model) {
		
		model.addAttribute("receita", receitaRepository.findById(id));
		
		return "receita/view";
	}
	
	@GetMapping("/receita/edit/{id}")
	public String editReceita(@PathVariable long id, Model model) {
		
		model.addAttribute("receita", receitaRepository.findById(id));
		
		return "receita/edit";
	}
	
	@GetMapping("/receita/delete/{id}")
	public String deleteReceita(@PathVariable long id) {
		
		try {
			receitaRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		
		return "redirect:/receita/list";
	}

}

