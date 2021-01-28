package projetfront.controller;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projet.back.entity.Produit;
import projet.back.exception.ProduitException;
import projet.back.repository.CategorieRepository;
import projet.back.repository.ProduitRepository;
import projet.back.service.CategorieService;
import projet.back.service.ProduitService;



@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitRepository produitrepo;
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private CategorieRepository categorierepo;
	
	
	@Autowired
	private Validator validator;

	@GetMapping({"", "/"})
	public ModelAndView list() {
			
		return new ModelAndView("produit/list","produits",produitrepo.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam Long id) {
		produitService.suppression(id);
		return new ModelAndView("redirect:/produit");
	}
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") long id) throws ProduitException {
		return goEdit(produitService.consultation(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Produit());
	}

	private ModelAndView goEdit(Produit produit) {
		ModelAndView modelAndView = new ModelAndView("produit/edit");
		modelAndView.addObject("produit",produit);
		modelAndView.addObject("categorie",categorierepo.findAll());
		return modelAndView;
	}


	@PostMapping("/save")
	public ModelAndView add(@Valid @ModelAttribute("Produit") Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(produit);
		}
		if(produit.getCategorie().getId()==null) {
			produit.setCategorie(null);
		}
		if (produit.getId() == null) {
			produitService.creation(produit);
		} else {
			produitService.modification(produit);
		}
		return new ModelAndView("redirect:/produit");
	}


}
