package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TacheMapping {
	@FXML
	void annuler(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	void validerPlanificition(ActionEvent event) {
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Félicitations");
		bye.setHeaderText("Votre tâche a été planifiée");
		bye.setContentText("Et bonne chance pour ceci");
		bye.showAndWait();
		
        ((Node)(event.getSource())).getScene().getWindow().hide();

	}
}
