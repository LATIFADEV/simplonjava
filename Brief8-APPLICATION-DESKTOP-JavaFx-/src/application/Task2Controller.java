package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.todolist.domin.Task;
import com.todolist.model.dao.impl.TaskDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class Task2Controller implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	TaskDAO taskDao= new TaskDAO();
	Task task;
	
	@FXML
	private TableView<Task>   tableView;
//	@FXML
//	private TableColumn clmnTitle;
//	@FXML
//	private TableColumn clmndescription;
//	@FXML
//	private TableColumn clmnDedline;
//	@FXML
//	private TableColumn clmlstatut;
	@FXML
	private Button btndelet;

	@FXML
	private  TableColumn<Task,String>   clmnTitle;
	@FXML
	private  TableColumn<Task,String>   clmndescription;
	@FXML
	private  TableColumn<Task,String>   clmnDedline;
	@FXML
	private  TableColumn<Task,String>   clmlstatut;

	private  final ObservableList<Task> TaskData = FXCollections.observableArrayList(
//			new task(1,"Task1","Description1",Task.taskStatuts.Completed,"2022-06-16"),
			);
	@FXML
	public void delet(ActionEvent event) {
		 Task task = tableView.getSelectionModel().getSelectedItem();
	    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		if(taskDao.delete(task.getTask_id())){
		if(task!=null)
			TaskData.remove(TaskData.indexOf(task));
	    }	
		else if (selectedIndex >= 0) {
	        tableView.getItems().remove(selectedIndex);            
	    }
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TaskData.addAll(taskDao.getAll());
		clmnTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
		clmndescription.setCellValueFactory(new PropertyValueFactory<Task, String>("discription"));
		clmnDedline.setCellValueFactory(new PropertyValueFactory<Task, String>("Dedline"));
		clmlstatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
		tableView.setItems(TaskData);
		
	}
	@FXML
	public void switchToTask(ActionEvent event) throws IOException {
		
	    Pane root = FXMLLoader.load(getClass().getResource("Task.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
			
		

	}
	

}
