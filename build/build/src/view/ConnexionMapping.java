package view;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainClass;
import model.beans.Utilisateur;
import model.dao.ConnectionFactory;
import model.dao.UtilisateurDAO;


public class ConnexionMapping {

	@FXML
	private TextField mailConnection;
	
	@FXML
	private TextField passwordConnection;
	
	@FXML
    public void switchConnexionAcceuil(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
        root.toFront();
        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        
    }
	
	public boolean controlerFormulaire(Utilisateur user) {
		boolean isOk = true;
		
		List<String> messageErreur = new ArrayList<>();

		if(mailConnection.getText() == null || mailConnection.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Adresse mail\" est obligatoire");
			
		}
		else {
			
			if (!user.getAdresseMail().equals(mailConnection.getText())) {
				isOk = false;
				messageErreur.add("Utilisateur introuvable");
			}
		}
		
		if(passwordConnection.getText() == null || passwordConnection.getText().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Mot de passe\" est obligatoire");
		}
		else {
				if (!user.getPassword().equals(passwordConnection.getText())) {
		
				isOk = false;
				messageErreur.add("Vérifiez votre mot de passe");
				}
			
		}
		
		if (!isOk) {
			Alert erreur = new Alert(AlertType.ERROR);
			erreur.setTitle("Erreur ! ");
			StringBuilder sb = new StringBuilder();
			messageErreur.stream().forEach((x) -> sb.append("\n" + x));
			erreur.setHeaderText(sb.toString());
			erreur.showAndWait();
		}
		
		return isOk;
		
		
	}
	

	
	@FXML
	public void seConnecter(ActionEvent event) throws IOException {
		
		
		Utilisateur user = MainClass.utilisateurDAOEnCours.findUserByMail(mailConnection.getText());
		if (controlerFormulaire(user)) {
			MainClass.setUtilisateurEnCours(user);
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	        Stage primaryStage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/view/agenda.fxml"));
	        Scene scene = new Scene(root);
	        //scene.setFill(Color.TRANSPARENT);
	        primaryStage.setScene(scene);
	        //primaryStage.initStyle(StageStyle.TRANSPARENT);
	        primaryStage.show();
		}
	}
}
