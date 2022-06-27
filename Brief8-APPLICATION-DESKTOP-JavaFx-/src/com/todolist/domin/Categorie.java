package com.todolist.domin;

public class Categorie {
	
	private Integer categories_id;
	private String name_categorie;
	
	public Categorie() {
		
	}
	public Categorie(Integer categories_id, String name_categorie) {
		super();
		this.categories_id = categories_id;
		this.name_categorie = name_categorie;
	}
	
	
	public Integer getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(Integer categories_id) {
		this.categories_id = categories_id;
	}
	public String getName_categorie() {
		return name_categorie;
	}
	public void setName_categorie(String name_categorie) {
		this.name_categorie = name_categorie;
	}

}
