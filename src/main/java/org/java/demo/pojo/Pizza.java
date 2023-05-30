package org.java.demo.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name can't be null")
	private String name;
	@NotBlank(message = "Description can't be null")
	private String description;
	
	private String photo;
	@NotNull(message = "Price can't be null")
	@Min(value = 3, message = "Price can't be less than 3 euro")
	private Integer price;
	
	public Pizza() {}
	public Pizza(String name, String description, String photo, Integer price) {
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "-" + getName() + "]"  
		+ "/n" + getDescription() + getPrice();
	}
	
}