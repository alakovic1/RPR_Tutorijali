package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {

    public abstract String ispisi();

    @Override
    public abstract int hashCode();

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public final int compareTo(TelefonskiBroj o) {
        return this.ispisi().compareTo(o.ispisi());
    }
}
