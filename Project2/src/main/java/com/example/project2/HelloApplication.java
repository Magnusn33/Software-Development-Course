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

        for (int i = 0; i < 4; i++) {
            root = initializeColumn(root, i, "Programme: " + (i + 1));

        }

        showStage(stage, root);    }

    public GridPane initializeColumn(GridPane root, int pos, String programmeName) {

        //Initialize dropdown menu 1
        Label label = new Label(programmeName);
        ComboBox<String> a = setBox();
        a.setPromptText("Select Programme");

        //Initialize the dropdown menu 2
        ComboBox<String> b = setBox();
        b.setPromptText("Select Course");

        //Initialize the select button
        Button selectButton = new Button("Add");

        //Initialize textarea
        TextArea textarea = new TextArea();
        textarea = whenChosen(textarea, b, selectButton);

        //Add to root
        root.add(label, pos, 0);
        root.add(a, pos,1);
        root.add(b, pos, 2);
        root.add(selectButton, pos, 3);
        root.add(textarea, pos,4);

        return root;
    }

    public TextArea whenChosen(TextArea textarea, ComboBox<String> a, Button selectButton) {

        selectButton.setOnAction(event -> {
            String sel = a.getValue();
            textarea.setText(sel);
        });

        return textarea;
    }

    public ComboBox<String> setBox () {
        ComboBox<String> c = new ComboBox<String>();
        c.getItems().addAll(Model.baseProgram());

        return c;
    }

    public void showStage(Stage stage, GridPane root) {
        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show(); // Add this line to display the stage
    }

    public static void main(String[] args) {
        CreateProgrammes.main(args);
        launch();
        InteractWithSql.runSqlCmd("DROP TABLE Student");
    }
}