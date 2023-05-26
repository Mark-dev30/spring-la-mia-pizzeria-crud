package org.java.demo.controller;

import java.util.List;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/pizza/{id}")
	public String printPizzaWithId(Model model, @PathVariable("id") int id) {
		
		
		Pizza pizza = getPizzaById(id);
		if(pizza != null) {
			model.addAttribute("pizza", pizza);
		}

		return "pizza";

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
