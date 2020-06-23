package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.beans.Utilisateur;

public class MainClass extends Application{

	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	static Utilisateur utilisateurEnCours;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("Agenda de groupe");
		
		initialisationConteneurPrincipal();
		initialisationContenu();
	}
	
	public static Utilisateur getUtilisateurEnCours() {
		return utilisateurEnCours;
	}

	
	public static void setUtilisateurEnCours(Utilisateur user) {
		utilisateurEnCours = user;
	}
	
	
	private void initialisationConteneurPrincipal() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/conteneurPrincipal.fxml"));
		
		try {
			conteneurPrincipal = (BorderPane) loader.load();
			Scene scene = new Scene(conteneurPrincipal);
			stagePrincipal.setScene(scene);
			stagePrincipal.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/acceuil.fxml"));
		try {
			AnchorPane acceuil = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(acceuil);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
