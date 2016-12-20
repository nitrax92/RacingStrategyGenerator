package Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


import javafx.event.ActionEvent;
import java.io.IOException;



public class Controller {


    @FXML
    public void newRaceButton(ActionEvent event) throws IOException{
        Parent new_page_parent = FXMLLoader.load(getClass().getResource("../RaceEntry/NewSession.fxml"));
        Scene new_page_scene = new Scene(new_page_parent);
        Stage app_stage= (Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("New Session Data");
        app_stage.setScene(new_page_scene);
        app_stage.show();
    }

}
