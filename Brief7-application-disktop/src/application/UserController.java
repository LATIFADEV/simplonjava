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
	public User user;
	private UserDAO userDao = new UserDAO();

	@FXML
	private TextField txtlstnm;
	@FXML
	private Button btInsert;
	@FXML
    private Button btndelete;
	@FXML
	private Button btnUpdate;
	
	@FXML
	private TextField txid;
	@FXML
	private TextField txfnm;
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
	

	// Event Listener on Button[#btInsert].onAction
	@FXML
	public void create(ActionEvent event) {
		User  user2 = new User( txid.getAnchor(), txfnm.getText(),txtlstnm.getText() , txtmail.getText(), txtadresse.getText(), txtcity.getText(),txtountry.getText() );
		if(userDao.create(user2) !=null) {
		data.addAll(userDao.getAll());
		tableView.refresh();
     	userDao.getAll();	
		}
	}
	
    private final ObservableList<User> data =	
        FXCollections.observableArrayList(
        	new User(1, "LATIFA", "AMOUGUAY", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
            new User(2, "ayoube", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
            new User(3,"said", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
            new User(4,"othman", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
            new User(5,"abdelali", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
            new User(6,"anass", "ALAMI", "nawal@gmail.com", "eljouda", "agadir", "Mroc")
            
        );
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewUsers();
		
		
	}
	public void viewUsers() {
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
	 
	 
	 void clear() {
		 txfnm.setText(null);
		 txtlstnm.setText(null);
		 txtmail.setText(null);
		 txtadresse.setText(null);
		 txtcity.setText(null);
		 txtountry.setText(null);

	    }
	 

	@FXML
	public void delete(ActionEvent event) {
	
		int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        tableView.getItems().remove(selectedIndex);            
	    }
	    User  user = tableView.getSelectionModel().getSelectedItem();
		if(userDao.delete(user.getIdUser())){
		if(user!=null)
		data.remove(data.indexOf(user));
	    }		
	}
	
	@FXML
	public void update(ActionEvent event) {
		
//	            userDao.update(clmnfrstnm.getText(),clmlstnm.getText(),clmnmail.getText(),clmnadress.getText(),clmncity.getText(),clmncntry.getText());
//			 User  user2 = new User(txfnm.getText(),txtlstnm.getText() , txtmail.getText(), txtadresse.getText(), txtcity.getText(),txtountry.getText() );
//			 userDao.update(user2);
			 user = new User();
			 int userId  = Integer.parseInt(txid.getText());
				user.setIdUser(userId);

				user.setFirstname(txfnm.getText());
				user.setLastname(txtlstnm.getText());
				user.setEmail(txtmail.getText());
				user.setAdresse(txtadresse.getText());
				user.setCity(txtcity.getText());
				user.setCountry(txtountry.getText());
				userDao.update(6, user);
				viewUsers();
	           
	        }
	
	}