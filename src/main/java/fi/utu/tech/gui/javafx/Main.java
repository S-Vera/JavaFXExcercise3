package fi.utu.tech.gui.javafx;

import fi.utu.tech.gui.javafx.gimmick.MainApp2;
import fi.utu.tech.gui.javafx.zipper.MainApp1;

public class Main {
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Launching..");
        if (args.length == 1 && args[0].equals("--test")) return;

        int exercise = 1;
        if (args.length == 1) exercise = Integer.parseInt(args[0]);
        switch (exercise) {
            case 1:
                MainApp1.launch(MainApp1.class, args);
                break;
            default:
                MainApp2.launch(MainApp2.class, args);
                break;
        }
    }

}
