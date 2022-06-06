package com.product.domain;

public class Product {
	private int idProduit;
	private String nom;
	private Categories categorie;
	private double prix;
	private int stock;
	
	/*
	 * Constructeur par defaut
	 */
	public Product() {
		this.idProduit = -1;
		this.nom = "";
		this.categorie = Categories.fruits;
		
		this.prix = 0.0;
		this.stock = 0;
		
	}
	
	/*
	 * Constructeur de confort
	 * @param nom
	 * @param categorie
	 * @param prix
	 * @param stock
	 */
	public Product(String nom, Categories categorie, double prix, int stock) {
		this.idProduit = -1;
		this.nom = nom;
		this.categorie = categorie;
		this.prix = prix;
		this.stock = stock;
	}
	
	/*
	 * Contructeur de recopie
	 * @param produit l'objet a copier
	 */
	public Product(Product produit) {
		this.idProduit = produit.idProduit;
		this.nom = produit.nom;
		this.categorie = produit.categorie;
		this.prix = produit.prix;
		this.stock = produit.stock;
	}
	
	@Override
	public String toString() {
		return "Produit : "+nom+" Prix : "+prix+" idProduit : "+idProduit+" Stock : "+stock;
	}
	
	//GETTERS ET SETTERS
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Categories getCategorie() {
		return categorie;
	}
	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	

}
