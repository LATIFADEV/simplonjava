package application;




import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import com.todolist.domin.User;
import com.todolist.model.dao.impl.UserDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SingInController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField FiledFirstname;
	@FXML
	private TextField FiledLastName;
	@FXML
	private TextField FiledUserName;
	@FXML
	private TextField FiledPassword;
	@FXML
	private Button BtnEnregistrer;
	@FXML
	private Button ButtonCancel;
	
	
	
	 
	    public Stage primaryStage;
	    public User user = new User();
	
	     UserDAO userDao = new UserDAO();
	 @FXML
	    public void Login(MouseEvent event) {
	        // TODO Autogenerated
	        primaryStage = (Stage) ButtonCancel.getScene().getWindow();

	        primaryStage.close();
	    }
	
	
	@FXML
	public void create(ActionEvent event) {
		User  user2 = new User( 16,FiledFirstname.getText(),FiledLastName.getText() , FiledUserName.getText(), FiledPassword.getText());
		userDao.create(user2);
     		
     	
		
	}
	
	@FXML
    public void Close(ActionEvent event) {
        // TODO Autogenerated
        primaryStage = (Stage) ButtonCancel.getScene().getWindow();

        primaryStage.close();

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
