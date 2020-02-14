package fi.utu.tech.gui.javafx.gimmick;

import javafx.application.Platform;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


class View1 extends View {
    protected final int width, height;
    private final WritableImage buffer;
    private final int[] data;

    View1(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
        buffer = new WritableImage(width, height);
        data = new int[width * height];
    }

    public void run() {
        launchTimer();
        // uncomment to test if it fails (java.lang.InternalError).
        // it should work if you managed to program this correctly!
        //launchTimer();
    }

    void render() {
        // uncomment to test if it fails
        // it should work if you managed to program this correctly!
        //if (!Platform.isFxApplicationThread()) throw new Error("Wrong thread!");
    

    	new Thread() {
 
    		public void run() {
    	   		if(!active) {
    	    		return;
    	    	}

        for (int pixelIdx = 0; pixelIdx < data.length; pixelIdx++) {

            final int idx = pixelIdx;
            data[idx] = new Random().nextInt(200) | ((new Random().nextInt(16) * 16) << 24);
        }
        buffer.getPixelWriter().setPixels(
                0, 0,
                width, height,
                PixelFormat.getIntArgbPreInstance(), data, 0, width);

        getGraphicsContext2D().clearRect(0.0, 0.0, width, height);
        getGraphicsContext2D().drawImage(buffer, 0.0, 0.0);
    		}
    	}.start();
    }

    void launchTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                render();
            }
        }, 0l, 1000l);
    }
}