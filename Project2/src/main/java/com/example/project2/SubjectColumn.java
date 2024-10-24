package com.example.project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class SubjectColumn {

    public static GridPane initializeColumnSubject(GridPane root, int pos, String programmeName) {

        //Initialize dropdown menu 1
        Label label = new Label(programmeName);
        ComboBox<String> a = setBoxProgrammeSubject();
        a.setPromptText("Select Programme");

        //Initialize the select button
        Button setButton = new Button("Set");

        //Initialize the dropdown menu 2
        ComboBox<String> b = setBoxCourseSubject(a, setButton);
        b.setPromptText("Select Course");

        //Initialize the select button
        Button selectButton = new Button("Add");

        //Initialize textarea
        TextArea textarea = new TextArea();
        textarea = whenChosenSubject(textarea, b, selectButton, a);

        //Add to root
        root.add(label, pos, 0);
        root.add(a, pos,1);
        root.add(setButton, pos, 2);
        root.add(b, pos, 3);
        root.add(selectButton, pos, 4);
        root.add(textarea, pos,5);

        return root;
    }

    public static TextArea whenChosenSubject(TextArea textarea, ComboBox<String> setBoxCourse, Button selectButton, ComboBox<String> setBoxProgramme) {

        selectButton.setOnAction(event -> {
            String sel = setBoxCourse.getValue();
            //Fills out textarea. Appending the old text with the new
            textarea.setText(textarea.getText() + '\n' + sel);

            //Build table if not exist and add data
            InteractWithSql.runSqlCmd("CREATE TABLE IF NOT EXISTS " + setBoxProgramme.getValue() +  " (name TEXT PRIMARY KEY);");
            InteractWithSql.insertDataIntoTbl("INSERT OR REPLACE INTO " + setBoxProgramme.getValue() + " (name) VALUES ('" + setBoxCourse.getValue() + "');");

            //Print data
            System.out.println(InteractWithSql.getDataFromTbl("SELECT name FROM " + setBoxProgramme.getValue(), "name"));

        });

        return textarea;
    }

    public static ComboBox<String> setBoxProgrammeSubject () {
        ComboBox<String> c = new ComboBox<String>();
        c.getItems().addAll(Model.subjectModule());

        return c;
    }

    public static ComboBox<String> setBoxCourseSubject (ComboBox<String> boxProgramme, Button setButton) {
        ComboBox<String> c = new ComboBox<String>();

        // sets the options on setBoxCourse based on the chosen field in setBoxProgramme
        setButton.setOnAction(e -> {
            String sel = boxProgramme.getValue();
            if (sel != null) {
                System.out.println("Selected Programme: " + sel);
                c.getItems().addAll(Model.subjectCourse(sel));
            }
        });

        return c;
    }

}
