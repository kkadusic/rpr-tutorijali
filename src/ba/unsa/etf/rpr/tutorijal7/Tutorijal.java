package ba.unsa.etf.rpr.tutorijal7;

import java.util.*;
import java.io.*;

public class Tutorijal {

    public static void main(String[] args) {
        // write your code here
    }

    public static ArrayList<Grad> ucitajGradove() {
        ArrayList<Grad> niz = new ArrayList<>();
        try {
            Scanner ulaz = new Scanner(new FileReader("mjerenja.txt")).useDelimiter("[\\r\\n,]");
            while (ulaz.hasNext()) {
                String naziv = ulaz.next();
                int brojac = 0;
                double[] mjerenja = new double[1000];
                while (ulaz.hasNextDouble()) {
                    double vrijednost = ulaz.nextDouble();
                    if (brojac < 1000)
                        for (int i = 0; i < 1000; i++)
                            mjerenja[i] = vrijednost;
                    brojac++;
                }
                if (ulaz.hasNext()) ulaz.next();
                Grad grad = new Grad(naziv, 0, mjerenja);
                niz.add(grad);
            }
            ulaz.close();
        } catch (Exception e) {
            System.out.println("Greska pri citanju datoteke");
            System.out.println("Greska: " + e);
        }

        return niz;
    }

}
