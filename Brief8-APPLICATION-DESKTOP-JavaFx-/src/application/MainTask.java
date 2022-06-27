//package application;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//public class MainTask extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			Pane root = FXMLLoader.load(getClass().getResource("Task.fxml"));
//			Scene scene = new Scene(root,1200,600);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
