package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;
import java.util.*;

public class UN implements Serializable {
    private ArrayList<Drzava> drzave;

    public UN() {
        drzave = new ArrayList<>();
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }
}
