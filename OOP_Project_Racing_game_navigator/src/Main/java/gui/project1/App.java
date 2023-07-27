package gui.project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 350);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


/*

package gui.project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import tracks.Tracks;
import track.Track;
import track.Part;
import track.Way;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        launch();

        Track exampleTrack = Tracks.exampleTrack();
        System.out.println("length: " + exampleTrack.getLength());
        System.out.println("name: " + exampleTrack.getName());
        System.out.println("Parts:");
        for (Part part : exampleTrack.getParts()) {
            System.out.println("Part " + part.getName() + ":");
            for (Way way : part.getWays()) {
                System.out.println("Way " + way.getName() + ":");
                if (way.getBenefit() != null) {
                    System.out.println("Benefit: " + way.getBenefit().getName());
                } else {
                    System.out.println("No benefit");
                }
            }
        }

    }
}


 */