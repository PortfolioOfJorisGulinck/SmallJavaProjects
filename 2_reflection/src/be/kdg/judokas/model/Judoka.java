package be.kdg.judokas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * BASISKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

public class Judoka extends Persoon implements Comparable<Judoka>{
    private Gewichtsklasse gewichtsklasse; //Enum
    private Medaille medaille; //Enum
    private Kampioenschap kampioenschap; //Enum

    public Judoka() {
        this("onbekend", null, null,0, null, null);
    }

    public Judoka(String naam, Geslacht geslacht, LocalDate geboorte, int gewicht, Medaille medaille, Kampioenschap kampioenschap) {
        super(naam, geslacht, geboorte, gewicht);

        if (medaille == null){
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }

        if (kampioenschap == null){
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.kampioenschap = kampioenschap;
        }

        berekenGewichtsklasse(gewicht, geslacht);
    }

    private void berekenGewichtsklasse(int gewicht, Geslacht geslacht){
        if (geslacht == Geslacht.VROUW) {
            if (gewicht > 78) {
                this.gewichtsklasse = Gewichtsklasse.ZWAAR;
            } else if (gewicht > 70) {
                this.gewichtsklasse = Gewichtsklasse.HALF_ZWAAR;
            } else if (gewicht > 63) {
                this.gewichtsklasse = Gewichtsklasse.MIDDEN;
            } else if (gewicht > 57) {
                this.gewichtsklasse = Gewichtsklasse.HALF_MIDDEN;
            } else if (gewicht > 52) {
                this.gewichtsklasse = Gewichtsklasse.LICHT;
            } else if (gewicht > 48) {
                this.gewichtsklasse = Gewichtsklasse.HALF_LICHT;
            } else {
                this.gewichtsklasse = Gewichtsklasse.EXTRA_LICHT;
            }
        } else {
            if (gewicht > 100) {
                this.gewichtsklasse = Gewichtsklasse.ZWAAR;
            } else if (gewicht > 90) {
                this.gewichtsklasse = Gewichtsklasse.HALF_ZWAAR;
            } else if (gewicht > 81) {
                this.gewichtsklasse = Gewichtsklasse.MIDDEN;
            } else if (gewicht > 73) {
                this.gewichtsklasse = Gewichtsklasse.HALF_MIDDEN;
            } else if (gewicht > 66) {
                this.gewichtsklasse = Gewichtsklasse.LICHT;
            } else if (gewicht > 60) {
                this.gewichtsklasse = Gewichtsklasse.HALF_LICHT;
            } else {
                this.gewichtsklasse = Gewichtsklasse.EXTRA_LICHT;
            }
        }
    }

    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    public Medaille getMedaille() {
        return medaille;
    }

    public void setMedaille(Medaille medaille) {
        if (medaille == null){
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }
    }

    public Kampioenschap getKampioenschap() {
        return kampioenschap;
    }

    public void setKampioenschap(Kampioenschap kampioenschap) {
        if (kampioenschap == null){
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.kampioenschap = kampioenschap;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Judoka judoka = (Judoka) o;

        return getNaam().equals(judoka.getNaam());
    }

    @Override
    public int hashCode() {
        return getNaam() != null ? getNaam().hashCode() : 0;
    }

    @Override
    public int compareTo(Judoka andereJudoka) {
        return getNaam().compareTo(andereJudoka.getNaam());
    }

    @Override
    public String toString() {
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return String.format("%-20s %-10s (°%-12s) %-6d %-15s %-10s %-10s", this.getNaam(), this.getGeslacht(), shortFormatter.format(this.getGeboorte()),
                this.getGewicht(), this.gewichtsklasse, this.medaille, this.kampioenschap);
    }
}


