package application;

import com.inscreption.model.dao.impl.UserDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController  {
	@FXML
    private Label errorLabel;
    @FXML
    private Button submitButton;
    @FXML
    private TextField emailField;	   
    @FXML
    private TextField fnameField;
//    @FXML
//    private TextField lnameField;
//    @FXML
//    private PasswordField passwordField;
//    
    private UserDAO userDao =  new UserDAO();
//    
//    private User user;
//    
//    //private  boolean uniqueEmail = false;
	private String String;
    @FXML
    public void login(ActionEvent event) {
    	Stage primaryStage = new Stage();
    	if (fnameField.getText().equals("admin") && emailField.getText().equals("root")) {
    		try {
    			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("User.fxml"));
    			Scene scene = new Scene(root,600,600);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			primaryStage.setScene(scene);
    			primaryStage.show();
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    	}else {
    		if (fnameField.getText().equals("admin")) {

    		}
    		else{
    			fnameField.setText("");
    			fnameField.setStyle("-fx-background-color: red;");
//    			errorLabel.setText("Please enter a Valid Username!");
    			
    		}
    		
    		if (emailField.getText().equals("root")) {}else{
    			emailField.setText("");
    			emailField.setStyle("-fx-background-color: red;");
    			errorLabel.setText("Please enter a Valid Email!");
    		} 
    	}
    }
    
    public void OnkeyPress() {
    	fnameField.setStyle("-fx-background-color: white;");
    }
    
    public void OnkeyPressEmail() {
    	emailField.setStyle("-fx-background-color: white;");
    }
//
//	
//	   public  void SignupController() {
//	    }
//	  
//	   
////	   public void userSignUp(ActionEvent event) throws IOException {
////		   signUp(event);
////
////	   }
//	   
//		
//	   
//	   
//       
////    private void signUp(ActionEvent event) throws IOException {
////
////        Main m = new Main();
////        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
////        Pattern pattern = Pattern.compile(regex);
////        Matcher matcher = pattern.matcher(emailField.getText());
////        
////
////        if(fnameField.getText().isEmpty()) {
////            errorLabel.setText("Please enter a First Name!");
////            return;
////        }
////        if(lnameField.getText().isEmpty()) {
////            errorLabel.setText("Please enter a Last Name!");
////
////            return;
////        }
////        if(emailField.getText().isEmpty()) {
////            errorLabel.setText("Please enter a Email!");
////            return;
////        }
////        
////
////        if(emailField.getText().isEmpty()) {
////            errorLabel.setText("Please enter a Email!");
////            return;
////        }
////        if(!matcher.matches()) {
////            errorLabel.setText("Please enter a Valid Email!");
////            return;
////        }
////        if(userDao.checkEmail(emailField.getText())) {
////            errorLabel.setText("Email Already Exist!");
////            return;
////        }
////        
////          
////        if(passwordField.getText().isEmpty()) {
////            errorLabel.setText("Please enter a Password!");
////            return;
////        }
////        
////       if(passwordField.getText().length() < 8 ) {
////          errorLabel.setText("Password can't be less then 8 chars.");
////          return;
////      }
////
////        
////        user = new User(emailField.getText(), passwordField.getText(), fnameField.getText(), lnameField.getText(), false);
////
////     	if(userDao.insert(user)) {
////            errorLabel.setText("Sign-up Successfull!");
////            errorLabel.setStyle("-fx-text-fill: #1cfd6c;");  
////            loadSceneAndSendMessage();
////
////     	}
////}
//
//     
//    private void loadSceneAndSendMessage() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
//            Parent root = loader.load();
//
//            UserController dashboardController = loader.getController();
//            dashboardController.transferMessage(fnameField.getText()+ " " + lnameField.getText());
// 
//            
////            Main m = new Main();
////            m.changeScene("Dashboard.fxml");
//
//         //   Stage stage = new Stage();
//            Main.stg.setScene(new Scene(root));
//            Main.stg.setTitle("AhanouOnline");
//            Main.stg.show();
//            
//
//        } catch (IOException ex) {
//            System.err.println(ex);
//        }
//    }
//
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		submitButton.setOnAction( event -> {
//			try {
////				signUp(event);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        });
//		
//	}

}
