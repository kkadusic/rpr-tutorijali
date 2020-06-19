package ba.unsa.etf.rpr.tutorijal7;

import java.beans.XMLEncoder;
import java.util.*;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Tutorijal {

    public static void main(String[] args) {
        UN un = ucitajXml(null);

        for(Drzava d : un.getDrzave()) {
            System.out.println(d);
        }
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

    public static UN ucitajXml(ArrayList<Grad> gradovi) {
        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("Greska: drzave.xml nije ispravan XML dokument");
        }

        UN un = new UN();
        ArrayList<Drzava> drzave = new ArrayList<>();

        NodeList drzaveXml = xmldoc.getElementsByTagName("drzava");

        for(int i = 0; i < drzaveXml.getLength(); i++) {
            Node drzavaNode = drzaveXml.item(i);

            if(drzavaNode instanceof Element) {
                Element drzavaEl = (Element)drzavaNode;

                int stanovnika = Integer.parseInt(drzavaEl.getAttribute("stanovnika"));
                String naziv = drzavaEl.getElementsByTagName("naziv").item(0).getTextContent();

                Element gGradXml = (Element)drzavaEl.getElementsByTagName("glavnigrad").item(0);
                int gStanovnika = Integer.parseInt(gGradXml.getAttribute("stanovnika"));
                String nazivGrada = gGradXml.getTextContent().trim();

                Element povrsinaXml = (Element)drzavaEl.getElementsByTagName("povrsina").item(0);
                String jedinica = povrsinaXml.getAttribute("jedinica");
                double povrsina = Double.parseDouble(drzavaEl.getElementsByTagName("povrsina").item(0).getTextContent());

                Grad glavniGrad = new Grad(nazivGrada, gStanovnika, null);
                drzave.add(new Drzava(naziv, stanovnika, povrsina, jedinica, glavniGrad));
            }
        }
        un.setDrzave(drzave);
        return un;
    }

    public static void zapisiXml(UN un) {
        try {
            XMLEncoder izlaz = new XMLEncoder(new FileOutputStream("un.xml"));
            izlaz.writeObject(un);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greska: "+e);
        }
    }

}