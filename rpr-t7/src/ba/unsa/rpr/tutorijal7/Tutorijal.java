package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static ArrayList<Grad> ucitajGradove() {
        Scanner file = null;

        try {
            file = new Scanner(new FileReader("mjerenja.txt")).useDelimiter("[\\r\\n,]");
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka brojevi.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greska: " + e);
            System.exit(1);
        }

        ArrayList<Grad> gradovi = new ArrayList<>();
        while (file.hasNext()) {
            String imeGrada = file.next();
            double[] temperature = new double[1000];
            Grad grad = new Grad(imeGrada, 5000, temperature);
            gradovi.add(grad);
            int i = 0;
            int vel = 0;
            while (file.hasNextDouble()) {
                double temp = file.nextDouble();
                if (i < 1000) {
                    temperature[i] = temp;
                    vel++;
                }
                i++;
            }
            file.nextLine();
            grad.setMjerenje(vel);
        }
        file.close();
        return gradovi;
    }

    static UN ucitajXml(ArrayList<Grad> gradovi) {
        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }

        UN un = new UN();
        ArrayList<Drzava> drzave = new ArrayList<>();

        assert xmldoc != null;
        NodeList drzaveXml = xmldoc.getElementsByTagName("drzava");

        for (int i = 0; i < drzaveXml.getLength(); i++) {
            Node drzavaNode = drzaveXml.item(i);

            if (drzavaNode instanceof Element) {
                Element drzavaEl = (Element) drzavaNode;

                int stanovnika = Integer.parseInt(drzavaEl.getAttribute("brojStanovnika"));
                String naziv = drzavaEl.getElementsByTagName("naziv").item(0).getTextContent();

                Element gGradXml = (Element) drzavaEl.getElementsByTagName("glavniGrad").item(0);
                int gStanovnika = Integer.parseInt(gGradXml.getAttribute("brojStanovnika"));
                String nazivGrada = gGradXml.getTextContent().trim();

                Element povrsinaXml = (Element) drzavaEl.getElementsByTagName("povrsina").item(0);
                String jedinica = povrsinaXml.getAttribute("jedinicaZaPovrsinu");
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
            XMLEncoder izlaz = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("un.xml")));
            izlaz.writeObject(un);
            izlaz.close();
        } catch (FileNotFoundException greska) {
            System.out.println("Greska:" + greska);
        }
    }

    public static void main(String[] args) {
        ArrayList<Grad> gradovi = Tutorijal.ucitajGradove();
        for (var pom : gradovi) {
            System.out.println(pom);
        }
        Drzava bih = new Drzava("Bosna i Hercegovina", 4000000, 52000, "km2", gradovi.get(0));
        Drzava slo = new Drzava("Slovenija", 2000000, 21000, "km2", gradovi.get(1));
        ArrayList<Drzava> drzave = new ArrayList<>();
        drzave.add(bih);
        drzave.add(slo);
        UN un = new UN();
        un.setDrzave(drzave);
        zapisiXml(un);
    }
}
