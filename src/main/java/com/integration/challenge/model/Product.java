package com.integration.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Products")
public class Product extends AbstractEntity<Integer> {
	
	@NotBlank(message = "Product name is mandatory")
	@Size(min = 3, max = 255,  message = "Inform product name betwin {min} e {max} characters.")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Product description is mandatory")
	@Size(min = 3, max = 255, message = "Inform product description betwin {min} e {max} characters.")
	@Column(nullable = false)
	private String description;

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
	


}
