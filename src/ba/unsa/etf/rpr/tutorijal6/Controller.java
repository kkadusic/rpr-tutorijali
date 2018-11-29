package ba.unsa.etf.rpr.tutorijal6;

import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    public ComboBox mjesto;
    public ComboBox status;
    public ComboBox godina;
    public ComboBox smjer;
    public CheckBox pripadnost;
    public TextField ime;
    public TextField prezime;
    public TextField index;
    public TextField jmbg;
    public TextField datum;
    public TextField email;
    public TextField adresa;
    public TextField telefon;
    private boolean imeValidno;
    private boolean prezimeValidno;
    private boolean indeksValidan;
    private boolean jmbgValidno;
    private boolean datumValidno;
    private boolean emailValidno;

    public boolean formularValidan() {
        return (imeValidno && prezimeValidno && indeksValidan && jmbgValidno && datumValidno && emailValidno);
    }

    private boolean ispravanDatum(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) >= '0' && n.charAt(i) <= '9') {
                for (int j = 0; j < n.length(); j++) if(n.charAt(j) == '/' || n.charAt(j) == '.') return true;
            }
        }
        return false;
    }

    private boolean ispravnoImeiPrezime(String n) {
        if (n.length() < 1 || n.length() > 20) return false;
        for (int i = 0; i < n.length(); i++) {
            if (!(n.charAt(i) >= 'A' && n.charAt(i) <= 'Z') && !(n.charAt(i) >= 'a' && n.charAt(i) <= 'z'))
                return false;
        }
        return !n.trim().isEmpty();
    }


    private boolean ispravanJMBG(String n) {
        if (n.length() != 13) return false;
        for (int i = 0; i < n.length(); i++) {
            if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9')) return false;
        }
        return !n.trim().isEmpty();
    }

    private boolean ispravanEmail(String n) {
        for (int i = 0; i < n.length(); i++) if (n.charAt(i) == '@') return true;
        return false;
    }

    private boolean ispravanIndex(String n) {
        if (n.length() > 5) return false;
        for (int i = 0; i < n.length(); i++) if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9')) return false;
        return !n.trim().isEmpty();
    }


}