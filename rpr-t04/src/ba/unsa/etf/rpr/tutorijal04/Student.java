package ba.unsa.etf.rpr.tutorijal04;
import java.util.*;

public class Student {
    private String ime;
    private String prezime;

    public class Datum {
        private int dan, mjesec, godina;
        Datum(int d, int m, int g){
            dan = d; mjesec = m; godina = g;
        }
    }

    private Datum datumRodenja;
    private int brojIndeksa;

    public Student(){}
    public Student(String ime, String prezime, Datum datumRodjenja, int index){}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Datum getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Datum d) {
        this.datumRodenja = d;
    }

    public int getBrojIndexa() {
        return brojIndeksa;
    }

    public void setBrojIndexa(int brojIndexa) {
        this.brojIndeksa = brojIndexa;
    }
}