package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class ReponseCongeMapping {

	
	@FXML
	void ok(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
}
