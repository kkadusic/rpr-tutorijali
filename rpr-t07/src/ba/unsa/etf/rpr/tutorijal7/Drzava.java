package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;
import java.util.*;

public class Drzava implements Serializable {
    private String naziv;
    private Integer brojStanovnika;
    private Double povrsina;
    private String jedinicaZaPovrsinu;
    private Grad glavniGrad;
    //kad bi se koristio npr. double za atribut onda bi moralo ovako u konstruktoru
    //this.povrsina = Double.parseDouble(null);

    public Drzava() {
        this.naziv = null;
        this.brojStanovnika = null;
        this.povrsina = null;
        this.jedinicaZaPovrsinu = null;
        this.glavniGrad = null;
    }

    public Drzava(String naziv, Integer brojStanovnika, Double povrsina, String jedinicaZaPovrsinu, Grad glavniGrad) {
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.povrsina = povrsina;
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
        this.glavniGrad = glavniGrad;
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

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
