package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;
import java.util.*;

public class Grad implements Serializable {
    private String naziv;
    private Integer brojStanovnika;
    private double[] temperature;

    public Grad() {
        this.naziv = null;
        this.brojStanovnika = null;
        this.temperature = new double[1000];
    }

    public Grad(String naziv, Integer brojStanovnika, double[] temperature) {
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.temperature = temperature;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

}
