package org.java.demo;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", "Classic pizza in italy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbXb7fQFf5bU60qGqk3P8rDX5DAUWBTVvllx2LQilBsTm1dxtxLEtRg0S9mvrutWNfvZc&usqp=CAU", 5);
		Pizza p2 = new Pizza("Capriciosa", "Classic pizza in italy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbXb7fQFf5bU60qGqk3P8rDX5DAUWBTVvllx2LQilBsTm1dxtxLEtRg0S9mvrutWNfvZc&usqp=CAU", 10);
		Pizza p3 = new Pizza("007", "Classic pizza in italy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbXb7fQFf5bU60qGqk3P8rDX5DAUWBTVvllx2LQilBsTm1dxtxLEtRg0S9mvrutWNfvZc&usqp=CAU", 15);
		Pizza p4 = new Pizza("Prosciutto", "Classic pizza in italy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbXb7fQFf5bU60qGqk3P8rDX5DAUWBTVvllx2LQilBsTm1dxtxLEtRg0S9mvrutWNfvZc&usqp=CAU", 12);
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
	}
}
