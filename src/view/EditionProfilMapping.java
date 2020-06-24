package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.MainClass;
import model.beans.Utilisateur;
import model.dao.ConnectionFactory;
import model.dao.UtilisateurDAO;

public class EditionProfilMapping {
	
	@FXML
	private TextField nomEditionProfil;
	
	@FXML
	private TextField prenomEditionProfil;
	
	@FXML
	private TextField mailEditionProfil;
	
	@FXML
	private TextField passwordEditionProfil;
	
	@FXML
	private TextField confirmPasswordEditionProfil;
	
	@FXML
    void annulerEditionProfil(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/profil.fxml"));
        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        
    }
	
	
	
	public boolean controlerFormulaire(Utilisateur utilisateur, Utilisateur utilisateur2) {
		boolean isOk = true;
		
		
		List<String> messageErreur = new ArrayList<>();

		if(mailEditionProfil.getText() == null || mailEditionProfil.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Adresse mail\" est obligatoire");
			
		}
		if(nomEditionProfil.getText() == null || nomEditionProfil.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Nom\" est obligatoire");
			
		}		
		if(prenomEditionProfil.getText() == null || prenomEditionProfil.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Prenom\" est obligatoire");
			
		}
		else {
			
			if ((utilisateur.getAdresseMail().equals(mailEditionProfil.getText()) && (!utilisateur.getAdresseMail().equals(utilisateur2.getAdresseMail())))) {
				isOk = false;
				messageErreur.add("Adresse mail déjà utilisée");
			}
		}
		
		if(passwordEditionProfil.getText() == null || passwordEditionProfil.getText().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Mot de passe\" est obligatoire");
		}
		if(confirmPasswordEditionProfil.getText() == null || confirmPasswordEditionProfil.getText().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Confirmation du mot de passe\" est obligatoire");
		}
		else {
				if (!passwordEditionProfil.getText().equals(confirmPasswordEditionProfil.getText())) {
		
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
	void editerProfil(ActionEvent event) throws IOException, SQLException {
		
		Utilisateur user =MainClass.utilisateurDAOEnCours.findUserByMail(mailEditionProfil.getText());
		Utilisateur utilisateurAAjouter = new Utilisateur(MainClass.utilisateurEnCours.getId(),mailEditionProfil.getText(), nomEditionProfil.getText(), prenomEditionProfil.getText(), passwordEditionProfil.getText());
		
		if(controlerFormulaire(user, utilisateurAAjouter)) {
			
				MainClass.utilisateurDAOEnCours.update(utilisateurAAjouter);
				MainClass.utilisateurEnCours = MainClass.utilisateurDAOEnCours.find(utilisateurAAjouter.getId());
				Alert bye = new Alert(AlertType.INFORMATION);
				bye.setTitle("Modification");
				bye.setHeaderText("Votre coordonnées ont été modifiées avec succès");
				bye.showAndWait();
				
				
		        ((Node)(event.getSource())).getScene().getWindow().hide();
		        Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/view/profil.fxml"));
		        Scene scene = new Scene(root);
		        //scene.setFill(Color.TRANSPARENT);
		        primaryStage.setScene(scene);
		        //primaryStage.initStyle(StageStyle.TRANSPARENT);
		        primaryStage.show();
		}
		
	}
	
	@FXML 
	void initialize() {
			
			nomEditionProfil.setText(MainClass.getUtilisateurEnCours().getNom().toString());
			prenomEditionProfil.setText(MainClass.getUtilisateurEnCours().getPrenom().toString());
			mailEditionProfil.setText(MainClass.getUtilisateurEnCours().getAdresseMail().toString());

	}
	
}
