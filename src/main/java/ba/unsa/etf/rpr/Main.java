package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main extends Application {

    private static Stage stage;
    public static Stage getStage() {
        return stage;
    }

    public static String ispisiGradove(){
        ArrayList<Grad> gradovi = GeografijaDAO.getInstance().gradovi();
        String s = "";
        for (Grad grad : gradovi)
            s += grad.getNaziv() + " (" + grad.getDrzava().getNaziv() + ")" + " - " + grad.getBrojStanovnika() + "\n";
        return s;
    }

    public static void glavniGrad(){
        System.out.println("Unesite ime drzave: ");
        Scanner unos = new Scanner (System.in);
        String drzava = unos.nextLine();
        Grad grad = GeografijaDAO.getInstance().glavniGrad(drzava);
        if (grad != null)
            System.out.println("Glavni grad drzave " + drzava + " je " + grad.getNaziv());
        else
            System.out.println("Nepostojeca drzava");
    }

    public static void main(String[] args) {
        //System.out.println(ispisiGradove());
        //glavniGrad();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ResourceBundle bundle = ResourceBundle.getBundle("Translation");

        Parent root = FXMLLoader.load(getClass().getResource("/glavna.fxml"), bundle);
        stage.setTitle("Drzave");
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    public static void loadView(Locale locale) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("Translation", locale);
        Parent root = FXMLLoader.load(Main.class.getResource("/glavna.fxml"), bundle);
        stage.setTitle("Drzave");
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }
}
