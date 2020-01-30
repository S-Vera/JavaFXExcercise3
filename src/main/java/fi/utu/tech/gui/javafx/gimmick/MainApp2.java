package fi.utu.tech.gui.javafx.gimmick;

import fi.utu.tech.gui.javafx.MainApp;
import fi.utu.tech.gui.javafx.ResourceLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp2 extends MainApp {
    @Override
    public void start(Stage stage) {
        ResourceLoader<Parent, GimmickController> loader = new ResourceLoader<>("gimmick.fxml");

        Scene scene = new Scene(loader.root);

        stage.setTitle("The Gimmick Show");
        stage.setScene(scene);
        stage.show();
    }
}