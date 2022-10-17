package ba.unsa.etf.rpr.tutorijal02;


public class Interval {
    private double poc_tacka;
    private double kr_tacka;
    private boolean vr_za_poc;
    private boolean vr_za_kr;

    public double getPoc_tacka() {
        return poc_tacka;
    }

    public double getKr_tacka() {
        return kr_tacka;
    }

    public void setPoc_tacka(double poc_tacka) {
        this.poc_tacka = poc_tacka;
    }

    public void setKr_tacka(double kr_tacka) {
        this.kr_tacka = kr_tacka;
    }

    public boolean isVr_za_poc() {
        return vr_za_poc;
    }

    public void setVr_za_poc(boolean vr_za_poc) {
        this.vr_za_poc = vr_za_poc;
    }

    public boolean isVr_za_kr() {
        return vr_za_kr;
    }

    public void setVr_za_kr(boolean vr_za_kr) {
        this.vr_za_kr = vr_za_kr;
    }

    public Interval(double poc_tacka, double kr_tacka, boolean vr_za_poc, boolean vr_za_kr) {
        if (poc_tacka > kr_tacka) throw new IllegalArgumentException();
        setPoc_tacka(poc_tacka);
        setKr_tacka(kr_tacka);
        setVr_za_poc(vr_za_poc);
        setVr_za_kr(vr_za_kr);
    }

    public Interval() {
        setVr_za_poc(false);
        setVr_za_kr(false);
        setPoc_tacka(0);
        setKr_tacka(0);
    }

    public boolean isNull() {
        if (!isVr_za_poc() && !isVr_za_kr() && getPoc_tacka() == 0 && getKr_tacka() == 0) return true;
        return false;
    }

    public boolean isIn(double t) {
        if ((t > poc_tacka || (t == poc_tacka && isVr_za_poc())) && (t < kr_tacka || (t == kr_tacka && isVr_za_kr())))
            return true;
        return false;
    }

    public Interval intersect(Interval interval) {
        Interval i = new Interval();
        if(getPoc_tacka()<interval.getPoc_tacka()) {
            i.setPoc_tacka(interval.getPoc_tacka());
            i.setVr_za_poc(interval.isVr_za_poc());
        }
        else {
            i.setPoc_tacka(getPoc_tacka());
            i.setVr_za_poc(isVr_za_poc());
        }
        if(getKr_tacka()<interval.getKr_tacka()) {
            i.setKr_tacka(getKr_tacka());
            i.setVr_za_kr(isVr_za_kr());
        }
        else {
            i.setKr_tacka(interval.getKr_tacka());
            i.setVr_za_kr(interval.isVr_za_kr());
        }
        if((getPoc_tacka()>interval.getPoc_tacka()) || (interval.getPoc_tacka()>getKr_tacka())){
            Interval prazan=new Interval();
            return prazan;
        }
        return i;
    }

    public static Interval intersect(Interval i1,Interval i2){
            return i1.intersect(i2);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Interval interval = (Interval) o;
        if (interval.poc_tacka == poc_tacka && interval.kr_tacka == kr_tacka && vr_za_poc == interval.vr_za_poc && vr_za_kr == interval.vr_za_kr)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        if (getPoc_tacka() == 0 && getKr_tacka() == 0) s = "()";
        else {
            if (!isVr_za_poc()) s += "(";
            else s += "[";
            s += poc_tacka + "," + kr_tacka;
            if (!isVr_za_kr()) s += ")";
            else s += "]";
        }
        return s;
    }
}

