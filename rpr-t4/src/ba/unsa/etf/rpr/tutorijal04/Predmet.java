package ba.unsa.etf.rpr.tutorijal04;

import java.util.*;

public class Predmet {
    private String naziv;
    private int ECTSbod;
    private boolean obavezan;
    private ArrayList<Student> studenti;

    public Predmet(){}

    public Predmet(String naziv, int ECTS){
        setNaziv(naziv);
        setECTSbod(ECTS);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getECTSbod() {
        return ECTSbod;
    }

    public void setECTSbod(int ECTSbod) {
        this.ECTSbod = ECTSbod;
    }

    public void ispisiStudenta(Student student){
        studenti.remove(student);
    }

    public boolean isObavezan() {
        return obavezan;
    }

    public void setObavezan(boolean obavezan) {
        this.obavezan = obavezan;
    }

    public void dodajStudenta(Student s){
        studenti.add(s);
    }

    public String upisaniStudentiNaPredmet(){
        String studentiNaPredmetu=new String();
        for(int i=0;i<studenti.size();i++){
            studentiNaPredmetu+=studenti.get(i).getIme() + " " + studenti.get(i).getPrezime() + "\n";
        }
        return studentiNaPredmetu;
    }
}
