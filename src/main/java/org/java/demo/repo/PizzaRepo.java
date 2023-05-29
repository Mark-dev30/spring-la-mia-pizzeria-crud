package org.java.demo.repo;

import java.util.List;

import org.java.demo.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer>{
	public List<Pizza> findByNameContaining(String name);
}
