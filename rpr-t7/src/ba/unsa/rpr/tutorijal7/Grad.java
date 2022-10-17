package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Grad implements Serializable {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature = new double[1000];
    private int mjerenje;

    public Grad(){
        setNaziv("");
        setBrojStanovnika(0);
        setTemperature(new double[1000]);
        setMjerenje(0);
    }

    public Grad(String naziv, int brStanovnika, double[] temp){
        setNaziv(naziv);
        setBrojStanovnika(brStanovnika);
        setTemperature(temp);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public int getMjerenje() { return mjerenje; }

    public void setMjerenje(int mjerenje) { this.mjerenje = mjerenje; }

    @Override
    public String toString() {
        String collect = Arrays.stream(getTemperature(), 0, getMjerenje()).mapToObj(value -> Double.valueOf(value).toString()).collect(Collectors.joining(", "));
        String ispis="";
        ispis+= "Naziv = '" + getNaziv() + '\'' + "\n  brojStanovnika = " + getBrojStanovnika() + "\n  temperature = " + collect + "\n  brojMjerenja = " + getMjerenje() + "\n";
        return ispis;
    }
}
