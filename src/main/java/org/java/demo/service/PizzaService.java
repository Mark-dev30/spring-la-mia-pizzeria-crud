package org.java.demo.service;

import java.util.List;

import org.java.demo.pojo.Pizza;
import org.java.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll(){
		
		return pizzaRepo.findAll();
	}
	
	public Pizza save(Pizza pizza) {
		
		return pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findByNameContaining(String name){
		
		return pizzaRepo.findByNameContaining(name);
	}
	
}
