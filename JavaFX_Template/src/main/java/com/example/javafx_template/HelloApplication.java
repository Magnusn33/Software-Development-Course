package com.example.javafx_template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button button1=new Button("Click me!");
        ComboBox<String> comboBox=new ComboBox<>();
        comboBox.getItems().addAll("A","B","C");
        comboBox.getItems().addAll("D");
        VBox box=new VBox(button1,comboBox);
        Scene scene = new Scene(box, 500, 500);
        stage.setTitle("My JavaFX program");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}