package application;


import javafx.scene.control.CheckBox;


import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;





import com.todolist.domin.Categorie;
import com.todolist.domin.DateUtil;
import com.todolist.domin.Task;
import com.todolist.model.dao.impl.TaskDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;


public class TaskController implements Initializable {
	Task task;
	TaskDAO taskDao = new TaskDAO();
	
//	@FXML
//	private ComboBox comb;
	@FXML
	private Button BtnSave;
	@FXML
	private TextField TitleFiled;
	@FXML 
	private TextArea AreaDescription;
	@FXML
	private CheckBox checkNotyet;
	@FXML
	private CheckBox checkCompleted;
	@FXML
	private CheckBox checkInprogress;
	@FXML 
	private  DatePicker PickDedline;
	@FXML 
	private TableView<Task> tableView;
	@FXML
	private  TableColumn<Task,String>   clmnTitle;
	@FXML
	private  TableColumn<Task,String>   clmndescription;
	@FXML
	private  TableColumn<Task,String>   clmlstatut;
	@FXML
	private  TableColumn<Task,String>   clmnDedline;
	@FXML
	private  final ObservableList<Task> TaskData = FXCollections.observableArrayList(
			new Task(2,"Task1", "DESCRIPTION1","FINISHED","14.04.2022")
			);
	
	
	      
//			"Task1", "DESCRIPTION1","FINISHED","14.04.2022");
	public  void create(ActionEvent event) throws ParseException {
		if (task != null) {
			taskDao.create(task);
	        // Fill the labels with info from the person object.
//			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			TitleFiled.setText(task.getTitle());
			AreaDescription.setText(task.getDiscription());
			checkNotyet.setText(task.getStatut());
			checkCompleted.setText(task.getStatut());
			checkInprogress.setText(task.getStatut());
			PickDedline.setPromptText(DateUtil.format(task.getDedline()));

	        // TODO: We need a way to convert the date into a String!
	        // pickeddate.setText(...);
	    } else {
	        // task is null, remove all the text.
	    	TitleFiled.setText("");
	    	AreaDescription.setText("");
	    	checkNotyet.setText("");
	    	PickDedline.setPromptText("");
	    }
	}
	
//	public ObservableList<Task> getTaskData() {
//		return TaskData;
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewTask();
		

//		clmndescription.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		
	}
	public void viewTask() {
		TaskData.addAll(taskDao.getAll());
		clmnTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
		clmndescription.setCellValueFactory(new PropertyValueFactory<Task, String>("discription"));
		clmlstatut.setCellValueFactory(new PropertyValueFactory<Task, String>("statut"));
		clmnDedline.setCellValueFactory(new PropertyValueFactory<Task, String>("Dedline"));
		tableView.setItems(TaskData);
	}
	


	
	
	
	
	
	

}
