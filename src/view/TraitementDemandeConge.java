package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TraitementDemandeConge {
		
		@FXML
		void annuler(ActionEvent event) {
	        ((Node)(event.getSource())).getScene().getWindow().hide();
		}
		
		@FXML
		void traiterDemande(ActionEvent event) {
			Alert bye = new Alert(AlertType.INFORMATION);
			bye.setTitle("Envoyée");
			bye.setHeaderText("Votre réponse a été envoyée au demandeur");
			bye.setContentText("Et merci de l'avoir répondu");
			bye.showAndWait();
			
	        ((Node)(event.getSource())).getScene().getWindow().hide();

		}
		
}