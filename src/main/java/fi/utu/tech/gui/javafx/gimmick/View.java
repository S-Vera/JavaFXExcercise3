package fi.utu.tech.gui.javafx.gimmick;

import javafx.scene.canvas.Canvas;

abstract class View extends Canvas implements Runnable {
    protected boolean active = true;

    public View(double width, double height) {
        super(width, height);

        setOnMouseClicked(e -> {
            active = false;
            setVisible(false);
            setManaged(false);
        });
    }
}