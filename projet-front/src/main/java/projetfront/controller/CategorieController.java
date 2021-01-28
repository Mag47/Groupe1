package projetfront.controller;

import java.util.Set;


import javax.validation.Valid;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projet.back.entity.Categorie;
import projet.back.exception.CategorieException;
import projet.back.repository.CategorieRepository;
import projet.back.service.CategorieService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	@Autowired
	private CategorieRepository categorieRepo;
	@Autowired
	private Validator validator;

	@GetMapping({"","/"})
	public ModelAndView list() {
		/*model.addAttribute("categories", categorieRepo.findAll());
		Categorie p = new Categorie();
		Set<ConstraintViolation<Categorie>> violations = validator.validate(p);
		if (violations.isEmpty()) {
			System.out.println(p);
		} else {
			System.out.println("erreur de validation:\n" + violations);
		}*/
		return new ModelAndView( "categorie/list","categories", categorieRepo.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam Long id) throws CategorieException {
		categorieService.suppressionCategorie(id);
		return new ModelAndView("redirect:/categorie");
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("categorie") Categorie categorie, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(categorie);
		}
		if (categorie.getId() == null) {
			categorieService.creation(categorie);
		} else {
			categorieService.modification(categorie);
		}
		return new ModelAndView("redirect:/categorie");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam Long id) throws CategorieException {
		return goEdit(categorieService.consultation(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Categorie());
	}

	private ModelAndView goEdit(Categorie categorie) {
		ModelAndView modelAndView = new ModelAndView("categorie/edit", "categorie", categorie);
		//ModelAndView.addAttribute("categorie", categorie);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return modelAndView;
	}

}
