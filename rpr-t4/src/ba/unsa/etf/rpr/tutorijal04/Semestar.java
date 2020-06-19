package ba.unsa.etf.rpr.tutorijal04;
import java.util.ArrayList;

public class Semestar {
    private int SemestarID;
    private int brojObaveznihPredmeta;
    private int brojIzbornihPredmeta;
    private ArrayList<Predmet> izborniPredmeti;
    private ArrayList<Predmet> obavezniPredmeti;

    public ArrayList<Predmet> getIzborni() {
        return izborniPredmeti;
    }

    public ArrayList<Predmet> getObavezni() {
        return obavezniPredmeti;
    }
    public void DodajIzborni(){}
    public void DodajObavezni(){}

    public void UpisiStudentaNaIzborne(Student s){}
    public void UpisiStudentaNaObavezne(Student s){}
}