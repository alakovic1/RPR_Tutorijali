package ba.unsa.etf.rpr.tutorijal04;

import java.util.Set;

public class Student {
    private String ime;
    private String prezime;
    private int brojIndexa;
    private int godinaFaxa;
    private int skupljeniECTS;
    private Set<Predmet> predmeti;

    public Student() {
    }

    public Student(String ime, String prezime, int brojIndexa, int godinaFaxa, int skupljeniECTS) {
        setIme(ime);
        setPrezime(prezime);
        setBrojIndexa(brojIndexa);
        setGodinaFaxa(godinaFaxa);
        setSkupljeniECTS(skupljeniECTS);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(int brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public int getGodinaFaxa() {
        return godinaFaxa;
    }

    public void setGodinaFaxa(int godinaFaxa) {
        this.godinaFaxa = godinaFaxa;
    }

    public int getSkupljeniECTS() {
        return skupljeniECTS;
    }

    public void setSkupljeniECTS(int skupljeniECTS) {
        this.skupljeniECTS = skupljeniECTS;
    }

    public void upisiStudenta(Predmet predmet){
        predmeti.add(predmet);
    }

    public void ispisiStudentaSaPredmeta(Predmet predmet){
        predmeti.remove(predmet);
        predmet.ispisiStudenta(this);
    }
}
