package ba.unsa.etf.rpr.biblioteka;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Biblioteka extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BibliotekaModel bibliotekaModel = new BibliotekaModel();
        bibliotekaModel.dodajKnjige();
        BibliotekaController bibliotekaController = new BibliotekaController(bibliotekaModel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("biblioteka.fxml"));
        loader.setController(bibliotekaController); // mora prije metode .load I MORA SE IZBRISATI IZ FXML-a !!!
        Parent root = loader.load();
        stage.setTitle("Biblioteka");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setMinHeight(120);
        stage.setMinWidth(200);
        //stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
