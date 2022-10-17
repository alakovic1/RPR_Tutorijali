package ba.unsa.etf.rpr.tutorijal04;

public class Upisi {

    private Predmet predmet;
    private Studij plan;
    private Student student;

    public Upisi(){}

    public Upisi(Predmet predmet, Student student, Studij plan) {
        this.predmet = predmet;
        this.student = student;
        this.plan = plan;
    }

    public Student getStudent() {
        return student;
    }

    public Studij getPlan() {
        return plan;
    }

    public Predmet getPredmeti() {
        return predmet;
    }
}
