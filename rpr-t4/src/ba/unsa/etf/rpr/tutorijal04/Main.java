package ba.unsa.etf.rpr.tutorijal04;

import java.util.Set;

public class Main {

    private Set<Predmet> predmeti;
    private Set<Student> studenti;
    private Set<Upisi> upisani;

    public Set<Predmet> getSpisakPredmeta() {
        return predmeti;
    }

    public void setSpisakPredmeta(Set<Predmet> spisakPredmeta) {
        this.predmeti = spisakPredmeta;
    }

    public Set<Student> getSpisakStudenata() {
        return studenti;
    }

    public void setSpisakStudenata(Set<Student> spisakStudenata) {
        this.studenti = spisakStudenata;
    }

    public Set<Upisi> getUpisStudenta() {
        return upisani;
    }

    public void setUpisStudenta(Set<Upisi> upisStudenta) {
        this.upisani = upisStudenta;
    }

    void upisi(Student student, Predmet predmet, Studij planStudija) {
        upisani.add(new Upisi(predmet, student, planStudija));
    }
}
