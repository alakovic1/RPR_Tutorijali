package ba.unsa.etf.rpr.tutorijal04;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudijTest {

    @org.junit.jupiter.api.Test
    void getNaziv() {
        Studij p = new Studij("ETF", null, null);
        assertEquals("ETF", p.getNaziv());
    }

    @org.junit.jupiter.api.Test
    void getSpisakObaveznih() {
        ArrayList<Predmet> obavezniPredmeti = new ArrayList<>();
        obavezniPredmeti.add(new Predmet("Diskretna matematika", 6));
        obavezniPredmeti.add(new Predmet("Razvoj programskih rjesenja", 6));
        Studij p = new Studij("RI", obavezniPredmeti, null);
        assertEquals("Diskretna matematika\nRazvoj programskih rjesenja\n", p.getSpisakObaveznih());
    }

    @org.junit.jupiter.api.Test
    void getSpisakIzbornih() {
        ArrayList<Predmet> izborniPredmeti = new ArrayList<>();
        izborniPredmeti.add(new Predmet("Numericki algoritmi", 5));
        izborniPredmeti.add(new Predmet("Sistemsko programiranje", 5));
        Studij p = new Studij("RI", null, izborniPredmeti);
        assertEquals("Numericki algoritmi\nSistemsko programiranje\n", p.getSpisakIzbornih());
    }

    @org.junit.jupiter.api.Test
    void dodajObavezniPredmet() {
        Studij p = new Studij("RI", null, null);
        p.dodajObavezniPredmet(new Predmet("NA", 5));
        assertEquals("NA\n", p.getSpisakObaveznih());
    }

    @org.junit.jupiter.api.Test
    void dodajIzborniPredmet() {
        Studij p = new Studij("RI", null, null);
        p.dodajIzborniPredmet(new Predmet("SP", 5));
        assertEquals("SP\n", p.getSpisakIzbornih());
    }

}