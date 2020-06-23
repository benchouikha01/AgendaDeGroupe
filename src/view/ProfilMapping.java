package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.MainClass;

public class ProfilMapping {

	@FXML
	private static Label nomUtilisateurProfil;
	
	@FXML
	private static Label prenomUtilisateurProfil;
	
	@FXML
	private static Label mailProfil;
	
	
	
	@FXML
    void switchProfilAgenda(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/agenda.fxml"));
        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        
    }
	
	public static void initialiserCoordonnees() {
		nomUtilisateurProfil.setText(MainClass.getUtilisateurEnCours().getNom());
		prenomUtilisateurProfil.setText(MainClass.getUtilisateurEnCours().getPrenom());
		mailProfil.setText(MainClass.getUtilisateurEnCours().getAdresseMail());

	}
}
