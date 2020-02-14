package fi.utu.tech.gui.javafx.gimmick;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

public class GimmickController {
    @FXML
    private TilePane tilePane;
    
    public void initialize() {
        tilePane.getChildren().clear();
        
        new Thread() {
        	
        	public void run() {
        		for (int i = 0; i < 20; i++) {
        			final int j = i;
        			try {
        				Thread.sleep(500);
        			}
        			catch (Exception e) {
           	    	
        			}
        			View c  = j % 2 == 0 ? new View1(150, 150) : new View2(150, 150);
        			Platform.runLater(() -> tilePane.getChildren().add(c));
        			Thread th = new Thread(c);
        			th.setDaemon(true);
        			th.start();
        		
        		}
        	}
        }.start();
        
    }
}
