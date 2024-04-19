import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    public Button refToMenu, refToBooking;

    @FXML
    public void clickRefToMenu(ActionEvent event) throws IOException{
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        Scene scene = stage.getScene();

        BorderPane borderPane = (BorderPane)scene.getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    @FXML
    public void clickRefToBooking(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        Scene scene = stage.getScene();

        BorderPane borderPane = (BorderPane)scene.getRoot();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookingFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }
}
