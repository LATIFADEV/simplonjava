package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;


import com.todolist.domin.Task;
import com.todolist.model.dao.impl.TaskDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;

public class TaskController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	TaskDAO taskDao= new TaskDAO();
	@FXML
	private AnchorPane select;
	@FXML
	private TextArea AreaDescription;
	@FXML
	private TextField TitleFiled;
	@FXML
	private ComboBox comb;
	@FXML
	private Button BtnSave;
	@FXML
	private Button BtnCancel;
	@FXML
	private TableView tableView;
	@FXML 	
	private TableColumn clmnTitle;
	@FXML
	private TableColumn clmndescription;
	@FXML
	private TableColumn clmnDedline;
	@FXML
	private TableColumn clmlstatut;
	@FXML
	private RadioButton RadioNotYet;
	@FXML
	private RadioButton RadioCompleted;
	@FXML
	private RadioButton RadioIn_Progress;
	@FXML
	private Label display;
	@FXML
	private Button selectbtn;
	@FXML
	private Button resetbtn;
	@FXML
	private DatePicker datpicker;
	
	// TODO: add RadioButtons to scene

		ToggleGroup toggleGroup = new ToggleGroup();
		String currentStatus;
	
//	private  final ObservableList<Task> TaskData = FXCollections.observableArrayList(
////			new Task("2022-06-06")
//			);

	// Event Listener on Button[#BtnSave].onAction
	@FXML
	public void create(ActionEvent event) throws ParseException {
//		viewikhan();
		System.out.println("hjgh");
		LocalDate LocalDate1 = datpicker.getValue();	

		Task task = new Task();
		task.setTitle(TitleFiled.getText());
        task.setDiscription(AreaDescription.getText());
        task.setStatut(Task.taskStatuts.valueOf(currentStatus));
		task.setDedline(datpicker.getValue());
		if(taskDao.create(task)!=null) {
//			TaskData.addAll(taskDao.getAll());
		}
		
		
		
		
		
	}
	// Event Listener on Button[#selectbtn].onAction
	@FXML
	public void selectdate(ActionEvent event) {
		
		
	}
	// Event Listener on Button[#resetbtn].onAction
	@FXML
	public void resetdate(ActionEvent event) {
		System.out.println("vv;;");
		datpicker.setValue(null);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RadioNotYet.setToggleGroup(toggleGroup);
		RadioCompleted.setToggleGroup(toggleGroup);
		RadioIn_Progress.setToggleGroup(toggleGroup);
		// listen to changes in selected toggle
		toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) ->{ 
		      if (newVal == RadioNotYet) {
		  		System.out.println(newVal + " was selected");
				  currentStatus = RadioNotYet.getText();
		       } else if (newVal == RadioIn_Progress) {
			  		System.out.println(newVal + " was selected");
					  currentStatus = RadioIn_Progress.getText();  
					  
			       }
		      
		       else{
			  		System.out.println(newVal + " was selected");
					  currentStatus = RadioCompleted.getText();	   
		    	   
		       }

		});
//		viewikhan();
		
	}
	@FXML
	public void switchToTask2(ActionEvent event) throws IOException {
		Pane root = FXMLLoader.load(getClass().getResource("Task2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

//	public void viewikhan() {
//		TaskData.addAll(taskDao.getAll());
//		clmnTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
//		clmndescription.setCellValueFactory(new PropertyValueFactory<Task, String>("discription"));
//		clmnDedline.setCellValueFactory(new PropertyValueFactory<Task, String>("Dedline"));
//		clmlstatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
//		tableView.setItems(TaskData);
//	}
}
