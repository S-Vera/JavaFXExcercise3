package fi.utu.tech.gui.javafx.gimmick;

import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.Random;

class View2 extends View {
    protected final int width, height;

    View2(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }

    public void run() {
        while (true) {
	   		if(!active) {
        		return;
        	}
            getGraphicsContext2D().setFill(new Color(0.5,0,0,0.5));
            getGraphicsContext2D().fillRect(0.0, 0.0, width, height);
            getGraphicsContext2D().setFill(new Color(0,0,1,0.9));
            getGraphicsContext2D().fillOval(new Random().nextDouble() * width, new Random().nextDouble() * height, 20, 20);
        
            try {
                Thread.sleep(200 + new Random().nextInt(10) * 100);
            } catch (Exception e) {
            }
        }
    }

}