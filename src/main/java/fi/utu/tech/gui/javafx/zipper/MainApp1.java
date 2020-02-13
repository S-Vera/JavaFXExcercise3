package fi.utu.tech.gui.javafx.zipper;

import fi.utu.tech.gui.javafx.MainApp;
import fi.utu.tech.gui.javafx.ResourceLoader;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp1 extends MainApp {
    @Override
    public void start(Stage stage) {
    	
    	Task<Void> task = new Task<Void>() {
    		@Override 
    		protected Void call() throws Exception{
    			
    			return null;
    		}
    	};
        ResourceLoader<Parent, ZipperController> loader = new ResourceLoader<>("zipper.fxml");

        loader.controller.setLabel("Welcome!");
        loader.controller.setStage(stage);

        Scene scene = new Scene(loader.root);

        stage.setTitle("Zip Master 2020");
        stage.setScene(scene);
        stage.show();
    }
}