package ba.unsa.etf.rpr.GUI;

import javafx.event.ActionEvent;

import java.sql.*;

public class Controller {
    private Connection conn;

    public void createTable(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE Kontinenti" +
                    "(ID             INTEGER    PRIMARY KEY    AUTOINCREMENT   NOT NULL," +
                    " NAME           TEXT   NOT NULL," +
                    " AGE            INT    NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public void insertIntoTable(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "INSERT INTO Kontinenti (ID,NAME,AGE)" +
                    "VALUES (12 , 'Novi Kontinent', 1000000);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Podaci uspjesno dodani");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteFromTable(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DROP TABLE Kontinenti;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
            System.out.println("Tabela uspjesno obrisana");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void insertIntoTableDrzava(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO Drzava (id,naziv,glavniGrad)" +
                    "VALUES (123 , 'Njemacka', 18);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Podaci uspjesno dodani");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void insertIntoTableGrad(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "INSERT INTO Grad (id,naziv,brojStanovnika, drzava)" +
                    "VALUES (18 , 'Berlin', 5550000, 123);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Podaci uspjesno dodani");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteFromTableDrzava(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Baza uspjesno otvorena");

            stmt = c.createStatement();
            String sql = "DROP TABLE Drzava;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
            System.out.println("Tabela uspjesno obrisana");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteFromTableGrad(ActionEvent actionEvent) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            c.setAutoCommit(false);
            System.out.println("Baza uspjesno otvorena");

            stmt = c.createStatement();
            String sql = "DROP TABLE Grad;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
            System.out.println("Tabela uspjesno obrisana");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
