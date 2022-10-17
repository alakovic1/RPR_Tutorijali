package ba.unsa.etf.rpr.tutorijal04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getIme() {
        Student s = new Student("Amila", "Lakovic", 18117, 2, 60);
        assertEquals("Amila", s.getIme());
    }

    @Test
    void getPrezime() {
        Student s = new Student("Amila", "Lakovic", 18117, 2,60);
        assertEquals("Lakovic", s.getPrezime());
    }

    @Test
    void getSkupljeniECTS() {
        Student s = new Student("Amila", "Lakovic", 18117, 2,60);
        assertEquals(60, s.getSkupljeniECTS());
    }

    @Test
    void upisiStudenta() {
    }

    @Test
    void ispisiStudentaSaPredmeta() {
    }
}