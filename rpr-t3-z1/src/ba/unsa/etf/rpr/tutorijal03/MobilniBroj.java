package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj {

    private String mobBroj;
    private int mobMreza;

    public MobilniBroj(int mobilnaMreza, String broj){
        mobMreza=mobilnaMreza;
        mobBroj=broj;
    }

    @Override
    public final String ispisi(){
        String ispis="";
        ispis+="0"+mobMreza+"/"+mobBroj;
        return ispis;
    }

    @Override
    public final int hashCode() {
        return mobBroj.hashCode()+mobMreza;
    }

}
