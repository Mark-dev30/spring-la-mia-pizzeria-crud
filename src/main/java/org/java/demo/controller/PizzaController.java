package org.java.demo.controller;

import java.util.List;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Pizza> pizze = pizzaService.findAll();
		model.addAttribute("pizze", pizze);
		
		
		return "index";
		
	}
	
	@PostMapping("/pizza/by/name")
	public String getPizzaByTitle(Model model,@RequestParam(required = false) String name) {
		List<Pizza> pizze = pizzaService.findByNameContaining(name);
//		Passiamo a index.html la lista delle pizze filtrate
		model.addAttribute("pizze", pizze);
//		Passiamo a index.html anche il parametro (Nome inserito nel form) passato dal form al back-end
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String printPizzaWithId(Model model, @PathVariable("id") int id) {
		
		
		Pizza pizza = getPizzaById(id);
		if(pizza != null) {
			model.addAttribute("pizza", pizza);
		}

		return "pizza";

	}
	
	@GetMapping("/pizza/create")
	public String createPizza() {
		
		return "newpizza";
	}
	
	//Questa funzione viene chiamata quando viene inviata una richiesta POST all'URL "/pizza/create"
	@PostMapping("/pizza/create") 
	public String storePizza(@ModelAttribute Pizza pizza) { //L'oggetto 'Pizza' viene popolato automaticamente con i dati inviati dal client tramite la richiesta POST grazie all'annotazione @ModelAttribute
		
		pizzaService.save(pizza);
//		Ritorna la rotta '/' (in questo caso la homepage)
		return "redirect:/"; 
	}
	
	
	private Pizza getPizzaById(int id) {
		
		Pizza singlePizza = null;
		for (Pizza pizza: getPizze()) {
			if(pizza.getId() == id) {
				singlePizza = pizza;
			}
		}
		return singlePizza;
	}
	
	private List<Pizza> getPizze() {
		List<Pizza> pizze = pizzaService.findAll();
		return pizze;
	}
	
}
