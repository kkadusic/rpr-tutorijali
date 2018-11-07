package ba.unsa.etf.rpr.tutorijal04;
import java.util.ArrayList;

public class Odsjek {
    private String naziv;
    private int odsjekID;
    private int brojSemestara;
    private ArrayList<Semestar> semestri;

    public String getNaziv() {
        return naziv;
    }

    public int odsjekID() {
        return odsjekID;
    }

    public Semestar DajSemestar(int broj) throws ArrayIndexOutOfBoundsException{
        if (broj < brojSemestara)
            return semestri.get(broj);
        else throw new ArrayIndexOutOfBoundsException();
    }
}