package ba.unsa.etf.rpr.tutorijal04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void getNaziv() {
        Predmet p = new Predmet("DM", 6);
        assertEquals("DM", p.getNaziv());
    }

    @Test
    void getECTSbod() {
        Predmet p = new Predmet("RPR", 6);
        assertEquals(6, p.getECTSbod());
    }

}