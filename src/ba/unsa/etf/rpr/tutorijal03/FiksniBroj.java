package ba.unsa.etf.rpr.tutorijal03;

class FiksniBroj extends TelefonskiBroj {
    private String broj;
    private Grad pozivniBroj;
    public enum  Grad {
        BUGOJNO(0), ODZAK(1), ZENICA(2), SARAJEVO(3), LIVNO(4), TUZLA(5), MOSTAR(6), BIHAC (7), GORAZDE(8), SIROKI_BRIJEG(9) ,BRCKO(10);
        private int poziv;
        Grad (int x) {
            this.poziv=x;
        }
        public int getPoziv () {
            return this.poziv;
        }
    }
    public String [] pozivni = new String [] {"030","031","032","033","034","035","036","037", "038","039", "049"};
    protected Grad grad;
    public FiksniBroj (Grad grad, String broj) {
        this.pozivniBroj = grad;  this.broj = broj;
    }
    public Grad getPozivni () { return pozivniBroj; }
    @Override
    public String ispisi() {
        String s = new String();
        s += pozivni[pozivniBroj.getPoziv()] + "/" + broj;
        return s;
    }
}
