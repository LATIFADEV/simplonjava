
package application;

import com.todolist.model.dao.impl.UserDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class SampleController {
	
	@FXML
	private TextField FieldUsername;
	@FXML
	private PasswordField FieldPassword;
	@FXML
	private Button ButtonSubmit;
	@FXML 
	public void login() {
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
		
	}
	
	
	

