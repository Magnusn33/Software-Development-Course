package com.example.project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        GridPane root = new GridPane();

        root = ProgrammeColumn.initializeColumnProgram(root, 0, "Program: ");
        root = SubjectColumn.initializeColumnSubject(root, 1, "Subject 1: ");
        root = SubjectColumn.initializeColumnSubject(root, 2, "Subject 2: ");
        //root = initializeColumnElective(root, 3, "Elective: ");

        showStage(stage, root);
    }


    public void showStage(Stage stage, GridPane root) {
        Scene scene = new Scene(root, 2000, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}