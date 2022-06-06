package com.product.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.product.domain.Categories;
import com.product.domain.Product;
import com.product.model.DB.DB;
import com.product.model.dao.DAO;

public class ProductDao implements DAO<Product> {
	
	@Override
		public ArrayList<Product> voirProduit() {
				
				ArrayList<Product> listeProduit = new ArrayList<Product>();
				String sql = "SELECT * FROM product";
				try {
					Statement stmt = connect.createStatement();
					ResultSet resultats = stmt.executeQuery(sql);
					while (resultats.next()) {
						Product prod = new Product();
						prod.setIdProduit(resultats.getInt("id"));	
						prod.setNom(resultats.getString("name"));
						prod.setCategorie(Categories.valueOf(resultats.getString("categorie")));
						prod.setPrix(resultats.getDouble("price"));
						prod.setStock(resultats.getInt("stock"));
						listeProduit.add(prod);
						}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				return listeProduit;
			}
		
			@Override
		public Product ajouter(Product produit) {
				
					try {
				
						String sql = "INSERT INTO product(name, Categorie, price, stock) VALUES(?,?,?,?)";
						PreparedStatement pst = connect.prepareStatement(sql);
						pst.setString(1, produit.getNom());
						pst.setString(2,produit.getCategorie().name());
						pst.setDouble(3, produit.getPrix());
						pst.setInt(4, produit.getStock());
						pst.executeUpdate();
						pst.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return produit;
				}
			@Override
			public  void modifierProduit(Product product, int IdProduitAModifier){
				String sql= "UPDATE product SET name = ?, Categorie = ?,  price = ?, stock = ? WHERE product.id = ?";
				try {
					PreparedStatement pst = connect.prepareStatement(sql);
					pst.setString(1, product.getNom());
					pst.setString(2,product.getCategorie().name());
					pst.setDouble(3, product.getPrix());
					pst.setInt(4, product.getStock());
					pst.setInt(5, IdProduitAModifier);
					pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
			@Override
			public boolean delete(int id) {
				String sql= "DELETE FROM product WHERE product.id = ?";
				
					try {
						PreparedStatement pst = connect.prepareStatement(sql);
						pst.setInt(1, id);
						pst.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return false;
						
				
					
			
		}
	
	
	
	
	
		@Override
		public Product read(Product obj) {
			// TODO Auto-generated method stub
			return null;
		}
	
		@Override
		public Product find(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product create(Product obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean update(int id, Product user) {
			// TODO Auto-generated method stub
			return false;
		}



	
	
	
	

}
