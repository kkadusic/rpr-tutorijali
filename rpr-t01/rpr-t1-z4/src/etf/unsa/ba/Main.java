package  etf.unsa.ba;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Student {
    private String ime;
    private String prezime;
    private int index;

    public Student (String ime, String prezime, int index){
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
    }

    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public String getIndex() { return index; }

    public void setIme(String ime) { this.ime = ime; }
    public void setPrezime (String prezime) { this.prezime = prezime; }
    public void setIndex (int index) { this.index = index; }

    @Override
    public String toString() {
        return prezime+" "+ime+" ("+index+")";
    }
}

class Predmet {
    private Student[] studenti;
    private String naziv_predmeta;
    private int sifra_predmeta;

    public static int max_br_studenata;
    public static int broj_studenata;

    public Predmet (String naziv_predmeta, int sifra_predmeta, int max_br_studenata){
        this.naziv_predmeta = naziv_predmeta;
        this.sifra_predmeta = sifra_predmeta;
        this.studenti = new Student[max_br_studenata];
    }

    public void upisi (Student s){
        studenti[broj_studenata] = s;
        broj_studenata++;
    }

    public void ispisi (Student s){
        for (int i=0; i<broj_studenata; i++){
            boolean x = ((s.getIme().equals(Studenti[i].getIme())) && (s.getPrezime().equals(Studenti[i].getPrezime())) &&(s.getBroj_indeksa() == Studenti[i].getBroj_indeksa()));
            if (x == true){
                Studenti[i] = Studenti[broj_studenata-1];
                broj_studenata--;
            }
            else {
                System.out.println ("Nije pronadjen student kojeg zelite izbaciti");
            }
        }
    }

    public void ispisi(){
        for (int i=0; i<broj_studenata; i++){
            System.out.println (this.Studenti[i]); //???
        }
    }

}

class Program {
    public static Scanner unos = new Scanner (System.in);
    private static Student[] studenti;
    private static Predmet[] predmeti;

    public static void dodajPredmet (Predmet p){

    }

    public static void dodajStudenta (Student s){

    }

    public static void KreirajPredmet (){
        String ime_predmeta;
        int sifra_predmeta;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite ime predmeta: ");
        ime_predmeta = ulaz.nextLine();
        System.out.println("Unesite sifru predmeta: ");
        sifra_predmeta = ulaz.nextInt();
        Predmet p = new Predmet (ime_predmeta, sifra_predmeta);
        dodajPredmet(p);
    }

    public static void KreirajStudenta (){
        String ime, prezime;
        int br_indexa;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite ime studenta: ");
        ime = ulaz.nextLine();
        System.out.println("Unesite prezime studenta: ");
        prezime = ulaz.nextLine();
        System.out.println("Unesite index studenta: ");
        br_indexa = ulaz.nextInt();
        Student s = new Student (ime, prezime, br_indexa);
        dodajStudenta(s);
    }

    public static void main (String[] args){
        KreirajPredmet();
        KreirajStudenta();
        UpisiStudenta();
        IspisiStudenta();
        BrisiStudenta();
        BrisiPredmet();
        IspisStudenata();
    }
}