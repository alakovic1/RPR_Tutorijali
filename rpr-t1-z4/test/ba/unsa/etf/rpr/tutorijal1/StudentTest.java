package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void obrisiStudenta() {
        Student student=new Student("Amila","Lakovic",18111);
        student.obrisiStudenta();
        assertEquals("",student.dajImeStudenta());
        assertEquals("",student.dajPrezimeStudenta());
        assertEquals(0, student.dajBrojIndeksaStudenta());
    }

    @Test
    void dajImeStudenta() {
        Student student=new Student("Amila","Lakovic",18111);
        String ime=student.dajImeStudenta();
        assertEquals("Amila",ime);
    }

    @Test
    void dajPrezimeStudenta() {
        Student student=new Student("Amila","Lakovic",18111);
        String prezime=student.dajPrezimeStudenta();
        assertEquals("Lakovic",prezime);
    }

    @Test
    void dajBrojIndeksaStudenta() {
        Student student=new Student("Amila","Lakovic",18111);
        int index=student.dajBrojIndeksaStudenta();
        assertEquals(18111,index);
    }

}