package ba.unsa.etf.rpr.tutorijal1;

import java.util.*;

class Student {
    static String imeStudenta, prezimeStudenta;
    static int brojIndeksaStudenta;

    Student(String imeStudentaKojegUnosimo, String prezimeStudentaKojegUnosimo, int brojIndeksaStudentaKojegUnosimo) {
        postavi(imeStudentaKojegUnosimo, prezimeStudentaKojegUnosimo, brojIndeksaStudentaKojegUnosimo);
    }

    void postavi(String imeStudentaKojegUnosimo, String prezimeStudentaKojegUnosimo, int brojIndeksaStudentaKojegUnosimo) {
        Student.imeStudenta = imeStudentaKojegUnosimo;
        Student.prezimeStudenta = prezimeStudentaKojegUnosimo;
        Student.brojIndeksaStudenta = brojIndeksaStudentaKojegUnosimo;
    }

    void obrisiStudenta() {
        imeStudenta = "";
        prezimeStudenta = "";
        brojIndeksaStudenta = 0;
    }

    String dajImeStudenta() {
        return imeStudenta;
    }

    String dajPrezimeStudenta() {
        return prezimeStudenta;
    }

    int dajBrojIndeksaStudenta() {
        return brojIndeksaStudenta;
    }

    void promjeniImeStudenta(Student noviStudent) {
        this.imeStudenta = noviStudent.dajImeStudenta();
    }

    void promjeniPrezimeStudenta(Student noviStudent) {
        this.prezimeStudenta = noviStudent.dajPrezimeStudenta();
    }

    void promjeniBrojIndeksaStudenta(Student noviStudent) {
        this.brojIndeksaStudenta = noviStudent.dajBrojIndeksaStudenta();
    }

    void ispisi(Student student) {
        System.out.print(student.dajPrezimeStudenta() + " " + student.dajImeStudenta() + " (" + student.dajBrojIndeksaStudenta() + ")");
    }
};

class Predmet {
    static String nazivPredmeta, sifraPredmeta;
    static int maksimalanBrojStudenata;
    static private Student[] nizStudenata;
    private int trenutniBrojStudenataNaPredmetu;

    Predmet(String nazivPredmetaKojiUnosimo, String sifraPredmetaKojiUnosimo, int makismalanBrojStudenataNaPredmetu) {
        postavi(nazivPredmetaKojiUnosimo, sifraPredmetaKojiUnosimo, makismalanBrojStudenataNaPredmetu);
        nizStudenata = new Student[maksimalanBrojStudenata];
    }

    void postavi(String nazivPredmetaKojiUnosimo, String sifraPredmetaKojiUnosimo, int maksimalanBrojStudenataNaPredmetu) {
        Predmet.nazivPredmeta = nazivPredmetaKojiUnosimo;
        Predmet.sifraPredmeta = sifraPredmetaKojiUnosimo;
        Predmet.maksimalanBrojStudenata = maksimalanBrojStudenataNaPredmetu;
    }

    void upisi(Student noviStudent) {
        if (trenutniBrojStudenataNaPredmetu == maksimalanBrojStudenata)
            System.out.println("Nije moguÊe upisati studenta, dosegli ste maksimalan broj!");
        else {

            nizStudenata[trenutniBrojStudenataNaPredmetu] = noviStudent;
            trenutniBrojStudenataNaPredmetu++;
        }
    }

    void ispisani(Student ispisaniStudent) {
        for (int i = 0; i < trenutniBrojStudenataNaPredmetu; i++) {
            if (nizStudenata[i].dajImeStudenta() == ispisaniStudent.dajImeStudenta() && nizStudenata[i].dajPrezimeStudenta() == ispisaniStudent.dajPrezimeStudenta() && nizStudenata[i].dajBrojIndeksaStudenta() == ispisaniStudent.dajBrojIndeksaStudenta()) {
                for (int j = i; i > trenutniBrojStudenataNaPredmetu; j++) nizStudenata[j] = nizStudenata[j + 1];
                trenutniBrojStudenataNaPredmetu--;
            }
        }
    }

    String dajNazivPredmeta() {
        return nazivPredmeta;
    }

    String dajSifruPredmeta() {
        return sifraPredmeta;
    }

    int dajMaksimalanBrojStudenata() {
        return maksimalanBrojStudenata;
    }

    void izbrisiPredmet() {
        nazivPredmeta = "";
        maksimalanBrojStudenata = 0;
        sifraPredmeta = "";
    }

    void promjeniNazivStudenta(Predmet noviPredmet) {
        this.nazivPredmeta = noviPredmet.dajNazivPredmeta();
    }

    void promjeniSifruStudenta(Predmet noviPredmet) {
        this.sifraPredmeta = noviPredmet.dajSifruPredmeta();
    }

    void ispisStudenteNaPredmetu() {
        for (int i = 0; i < trenutniBrojStudenataNaPredmetu; i++) {
            System.out.print(i + 1 + ". ");
            nizStudenata[i].ispisi(nizStudenata[i]);
        }
    }
};

public class Program {

    public static void main(String[] args) {
        Predmet noviPredmet = new Predmet("Razvoj programskih rjesenja", "RPR", 150);
        Student noviStudent = new Student("Amila", "Lakovic", 18111);
        noviPredmet.upisi(noviStudent);
        noviPredmet.ispisStudenteNaPredmetu();
        noviPredmet.ispisani(noviStudent);
        noviPredmet.izbrisiPredmet();
        noviStudent.obrisiStudenta();
    }
}

