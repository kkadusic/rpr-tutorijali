package ba.unsa.etf.rpr.tutorijal7;

import java.util.*;

public class UN {
    private ArrayList<Drzava> drzave;

    public UN() {
        drzave = new ArrayList<>();
    }

    public UN(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }
}
