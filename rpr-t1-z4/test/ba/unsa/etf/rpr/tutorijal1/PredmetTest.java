package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void dajNazivPredmeta() {
        Predmet predmet=new Predmet("Diskretna matematika","DM",200);
        String ime=predmet.dajNazivPredmeta();
        assertEquals("Diskretna matematika",ime);
    }

    @Test
    void dajSifruPredmeta() {
        Predmet predmet=new Predmet("Diskretna matematika","DM",200);
        String sifra=predmet.dajSifruPredmeta();
        assertEquals("DM",sifra);
    }

    @Test
    void dajMaksimalanBrojStudenata() {
        Predmet predmet=new Predmet("Diskretna matematika","DM",200);
        int max=predmet.dajMaksimalanBrojStudenata();
        assertEquals(200,max);
    }

    @Test
    void izbrisiPredmet() {
        Predmet predmet=new Predmet("Razvoj programskih rjesenja","RPR",150);
        predmet.izbrisiPredmet();
        assertEquals("",predmet.dajSifruPredmeta());
        assertEquals("",predmet.dajNazivPredmeta());
        assertEquals(0,predmet.dajMaksimalanBrojStudenata());
    }

    @Test
    void ispisStudenteNaPredmetu() {
    }
}