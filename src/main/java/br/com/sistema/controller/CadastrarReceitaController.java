package br.com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.CadastrarReceita;
import br.com.sistema.repository.CadastrarReceitaRepository;

@Controller
public class CadastrarReceitaController {
	
	@Autowired
	CadastrarReceitaRepository cadastrarReceitaRepository;
	
	@GetMapping("/cadastrarReceita/list")
	public String listCadastrarReceita(Model model) {
		
		model.addAttribute("cadastrarReceitas", cadastrarReceitaRepository.findAll());
		return "cadastrarReceita/list";
	}
	
	@GetMapping("/cadastrarReceita/add")
	public String addCadastrarReceita(Model model) {
		model.addAttribute("cadastrarReceita", new CadastrarReceita());
		return "cadastrarReceita/add";
	}
	
	@PostMapping("/cadastrarReceita/save")
	public String saveCadastrarReceita(CadastrarReceita cadastrarReceita) {
		try {
			if(cadastrarReceita != null) {
				cadastrarReceitaRepository.save(cadastrarReceita);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/cadastrarReceita/view/" + cadastrarReceita.getId();
		
	}
	
	@GetMapping("/cadastrarReceita/view/{id}")
	public String viewCadastrarReceita(@PathVariable long id, Model model) {
		model.addAttribute("cadastrarReceita", cadastrarReceitaRepository.findById(id));
		return "cadastrarReceita/view";
	}
	
	@GetMapping("/cadastrarReceita/edit/{id}")
	public String editCadastrarReceita(@PathVariable long id, Model model) {
		model.addAttribute("cadastrarReceita", cadastrarReceitaRepository.findById(id));
		return "cadastrarReceita/edit";
	}
	
	@GetMapping("/cadastrarReceita/delete/{id}")
	public String deleteCadastrarReceita(@PathVariable long id) {
		try {
			cadastrarReceitaRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/cadastrarReceita/list";
	}

}

