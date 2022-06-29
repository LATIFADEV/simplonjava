package com.todolist.domin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumSet;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;



public class Task {
	  public static enum taskStatuts {
		    Not_yet,
		    In_progress,
			Completed;
		  
	    };
	    
	private  Integer task_id;
	private  String title;
	private String discription;
//	private final ObjectProperty<LocalDate> Dedline;
	private LocalDate Dedline;
	private taskStatuts statut = taskStatuts.Not_yet; 
	
//    private Priority priority = Priority.ZERO; // Default priority

    
//	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	    String strDate = formatter.format(Dedline);
	

	/*
	 * Constructeur par defaut
	 */
	public Task() {

	}
	public Task(String deadline) {
		this.Dedline = LocalDate.parse(deadline);
		
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

	public Task(Integer task_id, String title, String discription, taskStatuts statut,String deadline ) {
	super();
	this.task_id = task_id;
	this.title = title;
	this.discription = discription;
	this.statut= statut;
	this.Dedline = LocalDate.parse(deadline);
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


	 public void setStatut(taskStatuts S){
		 this.statut = S;
	    }

	    public taskStatuts getStatut(){
	        return statut;
	    }

		
	    public LocalDate getDedline() {
	        return Dedline;
	    }
	    public void setDedline(LocalDate deadline) {
	    	Dedline = deadline;
	    }

		@Override
		public String toString() {
			return "Task [task_id=" + task_id + ", title=" + title + ", discription=" + discription + ", Dedline="
					+ Dedline + ", statut=" + statut + "]";
		}

		

	        }
	    

	
	
	
	
	

	
