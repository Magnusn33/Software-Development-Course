package com.example.project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    Button grd[][] =new Button[3][3];
    TextField field = new TextField();
    String turn ="X";
    @Override
    public void start(Stage stage)  {
        for(int i=0;i<3;i++)for(int j=0;j<3;j++){
            grd[i][j] = new Button(" ");
            grd[i][j].setPrefSize(150,150);
            grd[i][j].setStyle("-fx-font-size: 60; -fx-font-weight: bold;");
        }
        VBox vbox = new VBox(
                new HBox(grd[0][0],grd[1][0],grd[2][0]),
                new HBox(grd[0][1],grd[1][1],grd[2][1]),
                new HBox(grd[0][2],grd[1][2],grd[2][2]),
                field
        );
        grd[0][0].setOnAction(e-> makeDraw(0,0));
        grd[1][0].setOnAction(e-> makeDraw(1,0));
        grd[2][0].setOnAction(e-> makeDraw(2,0));
        grd[0][1].setOnAction(e-> makeDraw(0,1));
        grd[1][1].setOnAction(e-> makeDraw(1,1));
        grd[2][1].setOnAction(e-> makeDraw(2,1));
        grd[0][2].setOnAction(e-> makeDraw(0,2));
        grd[1][2].setOnAction(e-> makeDraw(1,2));
        grd[2][2].setOnAction(e-> makeDraw(2,2));

        field.setText(turn+" turn");
        field.setPrefSize(450,150);
        field.setStyle("-fx-font-size: 60; -fx-font-weight: bold;");
        Scene scene = new Scene(vbox, 450, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void makeDraw(int x, int y) {
        // try to make a draw at location (x,y)
        // ignore if taken
        String txt = grd[x][y].getText();
        if(!txt.equals(" "))return;
        grd[x][y].setText(turn);
        if(turn.equals("X"))turn="O"; else turn="X";
        field.setText(turn+" turn");
        String win=checkWinner();
        if(!win.equals(""))field.setText(win+" wins");
    }

    private String checkWinner() {
        // should return name af winner or empty string
        if(line(0,0,1,1,2,2))return grd[1][1].getText();
        if(line(0,2,1,1,2,1))return grd[1][1].getText();
        for(int x=0;x<3;x++){
            if(line(x,0,x,1,x,1))return grd[x][0].getText();
        }
        for(int y=0;y<3;y++){
            if(line(0,y,1,y,2,y))return grd[0][y].getText();
        }
        return "";
    }

    boolean line(int x,int y,int x1,int y1,int x2, int y2){
        // check whether there is a line  (x,y)-(x1,y1)-(x2,y2)
        if(grd[x][y].getText().equals(grd[x1][y1].getText()) &&
                grd[x][y].getText().equals(grd[x2][y2].getText()) &&
                !grd[x][y].getText().equals(" ")
        ) return true;
        return false;
    }

    public static void main(String[] args) {
        launch();
    }
}