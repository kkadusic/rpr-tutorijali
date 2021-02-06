package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj {
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj){
        this.broj = "0" + mobilnaMreza + "/" + broj;
    }

    @Override
    public String ispisi() {
        return broj;
    }

    @Override
    public int hashCode() {
        return broj.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        MobilniBroj m = (MobilniBroj) o;
        return broj.equals(m.broj);
    }
}