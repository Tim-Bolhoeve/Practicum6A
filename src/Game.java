import java.time.LocalDate;
import java.math.*;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        double nieuweNieuwPrijs = this.nieuwprijs;
        if (LocalDate.now().getYear() - releaseJaar > 0) {
            for (int x = 0; x < LocalDate.now().getYear() - releaseJaar; x++) { //for loop die het aantal keer runt dat het spel oud is
                double korting = 1.0 - 0.3;
                nieuweNieuwPrijs *= korting;
            }
            return nieuweNieuwPrijs;
        } else {
            return nieuwprijs;
        }
    }

    public boolean equals(Object andereObject){
        boolean bool = false;

        if (andereObject instanceof Game) {
            Game spel = (Game) andereObject;
            if (this.naam.equals(spel.naam) && this.releaseJaar == spel.releaseJaar) {
                bool = true;
            }
        }
        return bool;
    }

    public String toString() {
        return getNaam() + ", uitgegeven in " + releaseJaar + ";" + " nieuwprijs: €" + String.format("%.2f", this.nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}

