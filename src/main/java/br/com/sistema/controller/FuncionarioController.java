package br.com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.Funcionario;
import br.com.sistema.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionario/list")
	public String listFuncionario(Model model) {
		
		model.addAttribute("funcionarios", funcionarioRepository.findAll());
		return "funcionario/list";
	}
	
	@GetMapping("/funcionario/add")
	public String addFuncionario(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "funcionario/add";
	}
	
	@PostMapping("/funcionario/save")
	public String saveFuncionario(Funcionario funcionario) {
		try {
			if(funcionario != null) {
				funcionarioRepository.save(funcionario);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/funcionario/view/" + funcionario.getId();
		
	}
	
	@GetMapping("/funcionario/view/{id}")
	public String viewFuncionario(@PathVariable long id, Model model) {
		model.addAttribute("funcionario", funcionarioRepository.findById(id));
		return "funcionario/view";
	}
	
	@GetMapping("/funcionario/edit/{id}")
	public String editFuncionario(@PathVariable long id, Model model) {
		model.addAttribute("funcionario", funcionarioRepository.findById(id));
		return "funcionario/edit";
	}
	
	@GetMapping("/funcionario/delete/{id}")
	public String deleteFuncionario(@PathVariable long id) {
		try {
				funcionarioRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/funcionario/list";
	}

}
