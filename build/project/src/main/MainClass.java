package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.beans.Utilisateur;
import model.dao.ConnectionFactory;
import model.dao.UtilisateurDAO;
import view.AcceuilMapping;
import view.AgendaMapping;
import view.ConnexionMapping;
import view.CreationMapping;
import view.ProfilMapping;

public class MainClass extends Application{

	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	public static Utilisateur utilisateurEnCours;
	public static UtilisateurDAO utilisateurDAOEnCours = new UtilisateurDAO(ConnectionFactory.getInstance());
	
	
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
		loader.setLocation(MainClass.class.getResource("/view/conteneurPrincipal.fxml"));
		
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
		FXMLLoader acceuil = new FXMLLoader();
		FXMLLoader agenda = new FXMLLoader();
		FXMLLoader connexion = new FXMLLoader();
		FXMLLoader creation = new FXMLLoader();
		FXMLLoader profil = new FXMLLoader();

		acceuil.setLocation(MainClass.class.getResource("/view/acceuil.fxml"));
		connexion.setLocation(MainClass.class.getResource("/view/connexion.fxml"));
		creation.setLocation(MainClass.class.getResource("/view/creation.fxml"));
		agenda.setLocation(MainClass.class.getResource("/view/agenda.fxml"));
		profil.setLocation(MainClass.class.getResource("/view/profil.fxml"));

		try {
			AnchorPane acceuilInterface = (AnchorPane) acceuil.load();
			conteneurPrincipal.setCenter(acceuilInterface);
			AcceuilMapping controleurAcceuil = acceuil.getController();
			ConnexionMapping controleurConnexion = connexion.getController();
			CreationMapping controleurCreation = creation.getController();
			ProfilMapping controleurProfil = profil.getController();
			AgendaMapping controleurAgenda = agenda.getController();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
