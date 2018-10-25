package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna,krajnja;
    private boolean pocetna_int,krajnja_int;

    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1) throw new IllegalArgumentException ("Pocetna tacka je veca od krajnje");
        pocetna=v; krajnja=v1; pocetna_int=b; krajnja_int=b1;
    }

    Interval(){
        pocetna = krajnja = 0;
        pocetna_int = krajnja_int = false;
    }

    public boolean isNull() {
        if (pocetna==0 && krajnja==0 && !pocetna_int && !krajnja_int) return true;
        else return false;
    }

    public boolean isIn(double v) {
        if ((v>pocetna || Math.abs(v-pocetna)<0.000001)) return true;
        return false;
    }



    public boolean equals(Interval i){
        if ((pocetna_int == i.pocetna_int && krajnja_int == i.krajnja_int)
                && Math.abs(pocetna-i.pocetna)<0.000001 && Math.abs(krajnja-i.krajnja)<0.000001) return true;
        else return  false;
    }

    @Override
    public String toString() {
        if (pocetna_int && krajnja_int) return "[" + pocetna + "," + krajnja + "]";
        if (pocetna_int && !krajnja_int) return "[" + pocetna + "," + krajnja + ")";
        if (!pocetna_int && krajnja_int) return "(" + pocetna + "," + krajnja + "]";
        if (isNull()) return "()"; //prazan skup
        return "(" + pocetna + "," + krajnja + ")";
    }
}