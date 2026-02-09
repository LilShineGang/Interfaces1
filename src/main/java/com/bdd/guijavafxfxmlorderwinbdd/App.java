package com.bdd.guijavafxfxmlorderwinbdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import java.net.URL;

/**
 * @author blagovest doukov dimitrova
 * @version 1.0
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("src/main/resources/fxml/orderBDD"), 800, 600);        
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = new File(fxml + ".fxml").toURI().toURL();
        return fxmlLoader.load(url); 
    }

    public static void main(String[] args) {
        launch();
    }
}