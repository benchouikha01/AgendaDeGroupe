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


public class CreationMapping {


	@FXML
	private TextField nomCreation;
	@FXML
	private TextField prenomCreation;
	@FXML
	private TextField mailCreation;
	@FXML
	private TextField passwordCreation;
	@FXML
	private TextField passwordConfirmCreation;

	
	
	
	public boolean controlerFormulaire(Utilisateur utilisateur) {
		boolean isOk = true;
		
		
		List<String> messageErreur = new ArrayList<>();

		if(mailCreation.getText() == null || mailCreation.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Adresse mail\" est obligatoire");
			
		}
		if(nomCreation.getText() == null || nomCreation.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Nom\" est obligatoire");
			
		}		
		if(prenomCreation.getText() == null || prenomCreation.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Prenom\" est obligatoire");
			
		}
		else {
			
			if (utilisateur.getAdresseMail().equals(mailCreation.getText())) {
				isOk = false;
				messageErreur.add("Adresse mail déjà utilisée");
			}
		}
		
		if(passwordCreation.getText() == null || passwordCreation.getText().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Mot de passe\" est obligatoire");
		}
		if(passwordConfirmCreation.getText() == null || passwordConfirmCreation.getText().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Confirmation du mot de passe\" est obligatoire");
		}
		else {
				if (!passwordCreation.getText().equals(passwordConfirmCreation.getText())) {
		
				isOk = false;
				messageErreur.add("Vérifiez le mot de passe");
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
	public void creerCompte(ActionEvent event) throws IOException {
		Utilisateur user =MainClass.utilisateurDAOEnCours.findUserByMail(mailCreation.getText());
		
		Utilisateur utilisateurAAjouter = new Utilisateur(mailCreation.getText(), mailCreation.getText(), prenomCreation.getText(), passwordCreation.getText());
		if(controlerFormulaire(user)) {
			
				MainClass.utilisateurDAOEnCours.create(utilisateurAAjouter);
				Alert bye = new Alert(AlertType.INFORMATION);
				bye.setTitle("Bienvenue");
				bye.setHeaderText("Votre compte a été créé avec succès");
				bye.setContentText("Et merci de nous avoir rejoint");
				bye.showAndWait();
				
				
		        ((Node)(event.getSource())).getScene().getWindow().hide();
		        Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
		        Scene scene = new Scene(root);
		        //scene.setFill(Color.TRANSPARENT);
		        primaryStage.setScene(scene);
		        //primaryStage.initStyle(StageStyle.TRANSPARENT);
		        primaryStage.show();
		}
		
		

	}
	
	@FXML
    void switchCreationAcceuil(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        
    }
}
