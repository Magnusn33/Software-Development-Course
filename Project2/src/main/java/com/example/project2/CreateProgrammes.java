package com.example.project2;

import java.sql.*;

public class CreateProgrammes {

    public static void main(String[] args) {


        InteractWithSql.runSqlCmd("CREATE TABLE IF NOT EXISTS Humtek (name TEXT PRIMARY KEY);");
        InteractWithSql.insertDataIntoTbl("INSERT INTO Course (name) VALUES ('John Doe')");
        System.out.println(InteractWithSql.getDataFromTbl("SELECT name FROM Student", "name"));


    }
}
