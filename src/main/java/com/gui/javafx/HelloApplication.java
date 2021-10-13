package com.gui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage savedStage;   //*

    @Override
    public void start(Stage stage) throws IOException {
        savedStage = stage; //*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);   //avoid using static fxmlLoad() methodmvn
        //scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();   //launch methods provided by Application superclass
    }
}

/*
*   If we need to store & re-use the provided stage at a late point in the application
 */