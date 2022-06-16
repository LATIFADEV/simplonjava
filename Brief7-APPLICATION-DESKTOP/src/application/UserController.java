package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.inscreption.domain.User;
import com.inscreption.model.dao.impl.UserDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class UserController implements Initializable {
	
	User user;
	private UserDAO userDao = new UserDAO();

	@FXML
	private Button btInsert;
	@FXML
    private Button btndelete;
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnclear;
	
	@FXML
	private TextField txid;
	@FXML
	private TextField txfnm;
	@FXML
	private TextField txtlstnm;
	@FXML
	private TextField txtmail;
	@FXML
	private TextField txtcity;
	@FXML
	private TextField txtountry;
	@FXML
	private TextField txtadresse;
	@FXML
	private  TableView<User>   tableView;
	@FXML
	private  TableColumn<User,Integer>   clmnid;
	@FXML
	private  TableColumn<User,String>   clmnfrstnm;
	@FXML
	private  TableColumn<User,String>   clmlstnm;
	@FXML
	private  TableColumn<User,String>   clmnmail;
	@FXML
	private  TableColumn<User,String>   clmnadress;
	@FXML
	private  TableColumn<User,String>   clmncity;
	@FXML
	private  TableColumn<User,String>   clmncntry;
	
	
	@FXML
	public void  ClickMous(MouseEvent event ) {
		user= tableView.getSelectionModel().getSelectedItem();
		txid.setText(String.valueOf(user.getIdUser()));
		txtlstnm.setText(user.getLastname());
		txtadresse.setText(user.getAdresse());
		txtcity.setText(user.getCity());
		txtmail.setText(user.getEmail());
		txfnm.setText(user.getFirstname());
		txtountry.setText(user.getCountry());
	}
	
	@FXML 
	 void clear() {
		
		 txfnm.setText(null);
		 txtlstnm.setText(null);
		 txtmail.setText(null);
		 txtadresse.setText(null);
		 txtcity.setText(null);
		 txtountry.setText(null);

	    }
	// Event Listener on Button[#btInsert].onAction
	@FXML
	public void create(ActionEvent event) {
		User  user2 = new User( txid.getAnchor(), txfnm.getText(),txtlstnm.getText() , txtmail.getText(), txtadresse.getText(), txtcity.getText(),txtountry.getText() );
		if(userDao.create(user2) !=null) {
		data.addAll(userDao.getAll());
		tableView.refresh();
     	userDao.getAll();	
     	viewUsers();
		}
	}
	
    private final ObservableList<User> data =	
        FXCollections.observableArrayList(
//        	new User(1, "LATIFA", "AMOUGUAY", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(2, "ayoube", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(3,"said", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(4,"othman", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(5,"abdelali", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(6,"anass", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc")
            
        );
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewUsers();
		
		
		
	}
	public void viewUsers() {
		data.clear();
		data.addAll(userDao.getAll());
		clmnid.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
		clmnfrstnm.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
		clmlstnm.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
		clmnmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		clmnadress.setCellValueFactory(new PropertyValueFactory<User, String>("adresse"));
		clmncity.setCellValueFactory(new PropertyValueFactory<User, String>("city"));
		clmncntry.setCellValueFactory(new PropertyValueFactory<User, String>("country"));
		tableView.setItems(data);
		
	}
	 @FXML
	 public void find(ActionEvent event) {
		
	
	            long id = 0;
				//Get all Employees information
	            if(userDao.find(id) != null) {
	            	tableView.setItems(data);
	            }
	           
	            
	        
	            System.out.println("OOPS" );
	        
	 }
	 

	 

	@FXML
	public void delete(ActionEvent event) {
		
	    User  user = tableView.getSelectionModel().getSelectedItem();
	    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		if(userDao.delete(user.getIdUser())){
		if(user!=null)
		data.remove(data.indexOf(user));
	    }	
		else if (selectedIndex >= 0) {
	        tableView.getItems().remove(selectedIndex);            
	    }
		
	}	
	
	@FXML
	public void update(ActionEvent event) {
		
		
//		 User  user = new User(177, "a", "b" ,"c", "d", "e", "f" );	
		
//		 User  user = 
//				 new User(Integer.parseInt(txid.getText()),txfnm.getText(),txtlstnm.getText() , txtmail.getText(), txtadresse.getText(), txtcity.getText(),txtountry.getText() );
//		         tableView.getSelectionModel().getSelectedItem();
//			System.out.println(user);
//			 System.out.println(userDao.update(Integer.parseInt(txid.getText()), user)); 
//			 User  selectedUser =   tableView.getSelectionModel().getSelectedItem();
//			 selectedUser = user;
//			 userDao.update(user2);

			 
			    
//			    int userId  = Integer.parseInt(txid.getText());
		  User  user =  tableView.getSelectionModel().getSelectedItem();
				user.setIdUser(Integer.parseInt(txid.getText()));
				user.setFirstname(txfnm.getText());
				user.setLastname(txtlstnm.getText());
				user.setEmail(txtmail.getText());
				user.setAdresse(txtadresse.getText());
				user.setCity(txtcity.getText());
				user.setCountry(txtountry.getText());
				System.out.println(userDao.update(Integer.parseInt(txid.getText()), user)); 
				viewUsers();
//			    userDao.update(userId, user);
				 
				
				
	           
	        }
	
	}
