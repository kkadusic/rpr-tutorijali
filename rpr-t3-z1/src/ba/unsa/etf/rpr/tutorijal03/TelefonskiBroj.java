package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {
    public abstract String ispisi();

    @Override
	public int hashCode(){
   	   return super.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
	TelefonskiBroj a = (TelefonskiBroj) o;
	return this.ispisi().equals(a.ispisi());
    }

    public int compareTo (TelefonskiBroj t){
        return this.ispisi().compareTo(t.ispisi());
    }
}
