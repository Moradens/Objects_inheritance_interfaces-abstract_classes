public class Obrazce {
    public static void main(String[] args) {
        Obrazec[] tvary = new Obrazec[5];
        tvary[0] = new RovnostrannyTrojuhelnik(6);
        tvary[1] = new Kruh(3.5);
        tvary[2] = new Ctverec(2);
        tvary[3] = new Obdelnik(4, 11);
        tvary[4] = new Obdelnik(5, 5);

        for (Obrazec o: tvary)
            System.out.println(o);
    }
}

abstract class Obrazec {
    abstract double vypoctiObvod();
    abstract double vypoctiObsah();

    @Override
    public String toString() {
        return String.format("Jsem %s o stranách %.1f a %.1f, s obvodem %.1f a obsahem %.1f",
                this.getClass().getSimpleName(),
                vypoctiObvod(),
                vypoctiObsah(),
                this.vypoctiObvod(),
                this.vypoctiObsah());
    }
}

class RovnostrannyTrojuhelnik extends Obrazec {
    private double strana;

    public RovnostrannyTrojuhelnik(double strana) {
        this.strana = strana;
    }

    @Override
    double vypoctiObvod() {
        return 3 * strana;
    }

    @Override
    double vypoctiObsah() {
        return Math.sqrt(3) / 4 * strana * strana;
    }
}

class Kruh extends Obrazec {
    private double polomer;

    public Kruh(double polomer) {
        this.polomer = polomer;
    }

    @Override
    double vypoctiObvod() {
        return 2 * Math.PI * polomer;
    }

    @Override
    double vypoctiObsah() {
        return Math.PI * polomer * polomer;
    }
}

class Ctverec extends Obrazec {
    private double strana;

    public Ctverec(double strana) {
        this.strana = strana;
    }

    @Override
    double vypoctiObvod() {
        return 4 * strana;
    }

    @Override
    double vypoctiObsah() {
        return strana * strana;
    }
}

class Obdelnik extends Obrazec {
    private double delka;
    private double sirka;

    public Obdelnik(double delka, double sirka) {
        this.delka = delka;
        this.sirka = sirka;
    }

    @Override
    double vypoctiObvod() {
        return 2 * (delka + sirka);
    }

    @Override
    double vypoctiObsah() {
        return delka * sirka;
    }
}