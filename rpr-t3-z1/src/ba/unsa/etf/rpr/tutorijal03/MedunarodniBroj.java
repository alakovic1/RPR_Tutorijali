package ba.unsa.etf.rpr.tutorijal03;

public class MedunarodniBroj extends TelefonskiBroj {

    private String mDrzava;
    private String mBroj;

    public MedunarodniBroj(String drzava,String broj){
        mDrzava=drzava;
        mBroj=broj;
    }

    @Override
    public final String ispisi(){
        String ispis="";
        ispis+=mDrzava+mBroj;
        return ispis;
    }

    @Override
    public final int hashCode() {
        return mDrzava.hashCode()+mBroj.hashCode();
    }



}
