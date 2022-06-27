//package application;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//public class MainSignIn extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//	       Pane root = FXMLLoader.load(getClass().getResource("SingIn.fxml"));
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
//}
