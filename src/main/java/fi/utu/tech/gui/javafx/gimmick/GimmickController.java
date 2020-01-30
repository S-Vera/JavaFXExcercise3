package fi.utu.tech.gui.javafx.gimmick;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

public class GimmickController {
    @FXML
    private TilePane tilePane;

    public void initialize() {
        tilePane.getChildren().clear();
        for (int i = 0; i < 20; i++) {
            final int j = i;
            try { Thread.sleep(100); }
            catch(Exception e) {

            }
            new Thread(() -> {
                View c = j % 2 == 0 ? new View1(150, 150) : new View2(150, 150);
                Platform.runLater(() -> tilePane.getChildren().add(c));
                new Thread(c).run();
            }).start();
        }
    }
}
