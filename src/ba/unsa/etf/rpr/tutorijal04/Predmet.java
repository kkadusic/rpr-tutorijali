package ba.unsa.etf.rpr.tutorijal04;
import java.util.*;

public class Predmet {
    private String nazivPredmeta;
    private int sifraPredmeta;
    private String imeProfesora;
    private int ECTS;
    private int kapacitet;
    private int brojStudenata;
    private Student[] Studenti;

    public String getImePredmeta() {
        return nazivPredmeta;
    }

    public void setImePredmeta(String imePredmeta) {
        this.nazivPredmeta = imePredmeta;
    }

    public int getPredmetID() {
        return sifraPredmeta;
    }

    public void setPredmetID(int predmetID) {
        this.sifraPredmeta = predmetID;
    }

    public String getImeProfesora() {
        return imeProfesora;
    }

    public void setImeProfesora(String imeProfesora) {
        this.imeProfesora = imeProfesora;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getMaxBrojStudenata() {
        return kapacitet;
    }

    public void setMaxBrojStudenata(int maxBrojStudenata) {
        this.kapacitet = maxBrojStudenata;
    }

    public int getBrojStudenata() {
        return brojStudenata;
    }

    public void setBrojStudenata(int brojStudenata) {
        this.brojStudenata = brojStudenata;
    }
}