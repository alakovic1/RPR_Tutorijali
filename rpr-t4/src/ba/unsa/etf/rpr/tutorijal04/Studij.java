package ba.unsa.etf.rpr.tutorijal04;

import java.util.ArrayList;

public class Studij {
    private String naziv;
    private ArrayList<Predmet> spisakObaveznihPredmeta;
    private ArrayList<Predmet> spisakIzbornihPredmeta;

    public Studij(){}

    public Studij(String naziv, ArrayList<Predmet> spisakObaveznihPredmeta, ArrayList<Predmet> spisakIzbornihPredmeta){
        this.naziv = naziv;
        this.spisakObaveznihPredmeta = spisakObaveznihPredmeta;
        this.spisakIzbornihPredmeta = spisakIzbornihPredmeta;
    }

    public String getNaziv() {
        return naziv;
    }
    public String getSpisakObaveznih() {
        String spisakPredmeta = new String();
        for (int i = 0; i < spisakObaveznihPredmeta.size() ; i++)
            spisakPredmeta +=spisakObaveznihPredmeta.get(i).getNaziv() + "\n";
        return spisakPredmeta;
    }
    public String getSpisakIzbornih() {
        String spisakPredmeta = new String();
        for (int i = 0; i < spisakIzbornihPredmeta.size() ; i++)
            spisakPredmeta +=spisakIzbornihPredmeta.get(i).getNaziv() + "\n";
        return spisakPredmeta;
    }
    public void dodajObavezniPredmet(Predmet predmet) {
        if (spisakObaveznihPredmeta == null)
            spisakObaveznihPredmeta = new ArrayList<>();
        spisakObaveznihPredmeta.add(predmet);
    }
    public void dodajIzborniPredmet(Predmet predmet) {
        if (spisakIzbornihPredmeta == null)
            spisakIzbornihPredmeta = new ArrayList<>();
        spisakIzbornihPredmeta.add(predmet);
    }
    public void ukloniObavezniPredmet(Predmet predmet) {
        spisakObaveznihPredmeta.remove(predmet);
    }
    public void ukloniIzborniPredmet(Predmet predmet) {
        spisakIzbornihPredmeta.remove(predmet);
    }
}
