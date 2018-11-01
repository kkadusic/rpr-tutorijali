package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    //fale jos neki gradovi
    public enum Grad {
        SARAJEVO, ODZAK, MAGLAJ, JAJCE, LIVNO, TUZLA, MOSTAR, BIHAC,
        GORAZDE, GRUDE, BRCKO, BANJALUKA, PRIJEDOR
    }

    String s;
    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;

        s = "";
        switch (grad) {
            case SARAJEVO:
                s += "030";
                break;
            case ODZAK:
                s += "031";
                break;
            case MAGLAJ:
                s += "032";
                break;
            case JAJCE:
                s += "033";
                break;
            case LIVNO:
                s += "034";
                break;
            case TUZLA:
                s += "035";
                break;
            case MOSTAR:
                s += "036";
                break;
            case BIHAC:
                s += "037";
                break;
            case GORAZDE:
                s += "038";
                break;
            case GRUDE:
                s += "039";
                break;
            case BRCKO:
                s += "050";
                break;
            case BANJALUKA:
                s += "051";
                break;
            case PRIJEDOR:
                s += "052";
                break;
            default:
                s += "Greska";
                break;
        }
        s += "/" + broj;
    }

    @Override
    public String ispisi() {
        return s;
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        FiksniBroj f = (FiksniBroj) o;
        return broj.equals(f.broj);
    }


}
