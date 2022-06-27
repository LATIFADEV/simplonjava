
package application;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.todolist.model.dao.impl.UserDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {
	 
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private ImageView mybackgroundView;
	Image mybackground = new Image(getClass().getResourceAsStream("Template .JPG"));
	
	@FXML
	private TextField FieldUsername;
	@FXML
	private PasswordField FieldPassword;
	@FXML
	private Button ButtonSubmit;
	@FXML 
	private Button LabelSignIn;


	
	@FXML 
	public void login(ActionEvent event) {
		 Window owner = ButtonSubmit.getScene().getWindow();

	        System.out.println(FieldUsername.getText());
	        System.out.println(FieldPassword.getText());

	        if (FieldUsername.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your username");
	            return;
	        }
	        if (FieldPassword.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter a password");
	            return;
	        }
	       
	        String username = FieldUsername.getText();
	        String password = FieldPassword.getText();

	        UserDAO userDao = new UserDAO();
	        boolean flag = userDao.login(username, password);
	       

	        if (!flag) {
	            infoBox("Please enter correct username and Password", null, "Failed");
	        } else {
	            infoBox("Login Successful!", null, "Failed");
	        }
	    }

	    public static void infoBox(String infoMessage, String headerText, String title) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }

	    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.initOwner(owner);
	        alert.show();
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		@FXML
		public void switchToTask(ActionEvent event) throws IOException {
			
		    Pane root = FXMLLoader.load(getClass().getResource("SingIn.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
				
			

		}
	
	  
	}
	
	
	

