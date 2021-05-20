package br.com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sistema.model.Categoria;
import br.com.sistema.repository.CategoriaRepository;
import org.springframework.data.domain.Sort;

@Controller
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/categoria/listbolos")
	public String listCategoriaBolos(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("bolos")));
		
		return "categoria/list";
	}
	
	@GetMapping("/categoria/listsalgados")
	public String listCategoriaSalgados(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("salgados")));
		
		return "categoria/list";
	}
	
	@GetMapping("/categoria/listmassas")
	public String listCategoriaMassas(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("massas")));
		
		return "categoria/list";
	}
	
	@GetMapping("/categoria/listtortas")
	public String listCategoriaTortas(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("tortas")));
		
		return "categoria/list";
	}
	
	@GetMapping("/categoria/listvegetarianos")
	public String listCategoriaVegetarianos(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("vegetarianos")));
		
		return "categoria/list";
	}
	
	@GetMapping("/categoria/listvegano")
	public String listCategoriaVegano(Model model) {
		
		model.addAttribute("categorias", categoriaRepository.findAll(Sort.by("vegano")));
		
		return "categoria/list";
	}
	
	
	@GetMapping("/categoria/add")
	public String addCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoria/add";
	}
	
	
	@PostMapping("/categoria/save")
	public String saveCategoria(Categoria categoria) {
		try {
			if(categoria != null) {
				categoriaRepository.save(categoria);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/categoria/view/" + categoria.getId();
		
	}
	
	@GetMapping("/categoria/view/{id}")
	public String viewCategoria(@PathVariable long id, Model model) {
		model.addAttribute("categoria", categoriaRepository.findById(id));
		return "categoria/view";
	}
	
	@GetMapping("/categoria/edit/{id}")
	public String editCategoria(@PathVariable long id, Model model) {
		model.addAttribute("categoria" , categoriaRepository.findById(id));
		return "categoria/edit";
	}
	
	@GetMapping("/categoria/delete/{id}")
	public String deleteCategoria(@PathVariable long id) {
		try {
			categoriaRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/categoria/list";
	}

}
