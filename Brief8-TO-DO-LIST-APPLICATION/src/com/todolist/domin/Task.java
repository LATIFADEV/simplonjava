package com.todolist.domin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;



public class Task {
	private  Integer task_id;
	private  String title;
	private String discription;
	private String Statut;
	private final ObjectProperty<LocalDate> Dedline;
    
//	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	    String strDate = formatter.format(Dedline);
	

	/*
	 * Constructeur par defaut
	 */
	public Task() {
		this(null, null,null,null,null);
	}
	
	/*
	 * Constructeur de confort
	 * @param nom
	 * @param categorie
	 * @param prix
	 * @param stock
	 */
	 
	/*
	 * Contructeur de recopie
	 * @param produit l'objet a copier
	 */

	public Task(Integer task_id, String title, String discription, String Statut,String Dedline ) {
	super();
	this.task_id = task_id;
	this.title = title;
	this.discription = discription;
	this.Statut = Statut;
	this.Dedline = new SimpleObjectProperty<LocalDate>(LocalDate.of(2022, 06, 23));
    }
	
	
	
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public String getStatut() {
		return Statut;
	}


	public void setStatut(String Statut) {
		this.Statut = Statut;
	}

	public LocalDate getDedline() {
		return Dedline.get();
	}

	public void setBirthday(LocalDate Dedline) {
		this.Dedline.set(Dedline);
	}
	
	public ObjectProperty<LocalDate> birthdayProperty() {
		return Dedline;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", title=" + title + ", discription=" + discription + ", Statut=" + Statut
				+ ", Dedline=" + Dedline + "]";
	}
	
	
	
	

}
