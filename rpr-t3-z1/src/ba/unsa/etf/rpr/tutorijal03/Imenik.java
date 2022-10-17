package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {

    private HashMap<String, TelefonskiBroj> mapa=new HashMap<String, TelefonskiBroj>();

    public final void dodaj(String ime, TelefonskiBroj broj){
        mapa.put(ime,broj);
    }

    public final String dajBroj(String ime){
        return mapa.get(ime).ispisi();
    }

    public final String dajIme(TelefonskiBroj broj){
        Set set=mapa.entrySet();
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry=(Map.Entry)iterator.next();
            if(mentry.getValue().equals(broj)){
                return (String) mentry.getKey();
            }
        }
        return "";
    }

    public final String naSlovo(char s){
        int vrijednost=1;
        String ispis="";
        for(Map.Entry<String,TelefonskiBroj> map : mapa.entrySet()) {
            if(s == map.getKey().charAt(0)) {
                ispis += vrijednost + ". " + map.getKey() + " - " + map.getValue().ispisi();
                vrijednost++;
            }
        }
        return ispis;
    }

    public final Set<String> izGrada(FiksniBroj.Grad g){
        Set<String> skup = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> e : mapa.entrySet()) {
            TelefonskiBroj broj = e.getValue();
            if (broj instanceof FiksniBroj) {
                FiksniBroj broj2 = (FiksniBroj) broj;
                if (broj2.getPozivniGrada().equals(broj2.getPozivniTrazenogGrada(g))) {
                    skup.add(e.getKey());
                }
            }
        }
        List<String> lista = new ArrayList<>(skup);
        Collections.sort(lista);
        return skup;
    }

    public final Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        Set<TelefonskiBroj> skup = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> e : mapa.entrySet()) {
            TelefonskiBroj broj = e.getValue();
            if (broj instanceof FiksniBroj) {
                FiksniBroj broj2 = (FiksniBroj) broj;
                if (broj2.getPozivniGrada().equals(broj2.getPozivniTrazenogGrada(g))) {
                    skup.add(e.getValue());
                }
            }
        }
        return skup;
    }
    
}
