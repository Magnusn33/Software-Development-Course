package com.example.project2;

import java.sql.*;

public class InteractWithSql {

    public static Connection setConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:identifier.sqlite";
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }

    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void runSqlCmd (String SqlCmd) {
        Connection conn = setConnection();

        //try-catch for creating table
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(SqlCmd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        closeConnection(conn);
    }

    public static void insertDataIntoTbl(String insertDataCmd) {
        Connection conn = setConnection();

        //try-catch for inserting values
        try (PreparedStatement pstmt = conn.prepareStatement(insertDataCmd)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        closeConnection(conn);
    }

    public static String getDataFromTbl (String getDataCmd, String columnName) {
        Connection conn = setConnection();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(getDataCmd);
            while (rs.next()) {
                return rs.getString(columnName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getDataCmd;
    }
}
