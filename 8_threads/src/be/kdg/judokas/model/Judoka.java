package be.kdg.judokas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * BASISKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

public final class Judoka implements Comparable<Judoka>{
    private final String naam;
    private final Geslacht geslacht; //Enum
    private final LocalDate geboorte;
    private final int gewicht; // in kg
    private final Gewichtsklasse gewichtsklasse; //Enum
    private final Medaille medaille; //Enum
    private final Kampioenschap kampioenschap; //Enum

    public Judoka(String naam, Geslacht geslacht, LocalDate geboorte, int gewicht, Gewichtsklasse gewichtsklasse, Medaille medaille, Kampioenschap kampioenschap) {
        if (naam == null || naam.isEmpty()){
            throw new IllegalArgumentException("Foutieve waarde voor de naam");
        } else {
            this.naam = naam;
        }

        if (geslacht == null){
            throw new IllegalArgumentException("Foutieve waarde voor de geslacht");
        } else {
            this.geslacht = geslacht;
        }

        if(geboorte.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("De judoka kan nog niet zijn geboren");
        } else {
            this.geboorte = geboorte;
        }

        if (gewicht <= 0){
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }

        if (medaille == null){
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }

        if (kampioenschap ==null){
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.kampioenschap = kampioenschap;
        }

        if (gewichtsklasse == null){
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.gewichtsklasse = gewichtsklasse;
        }
    }

    public String getNaam() {
        return naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public LocalDate getGeboorte() {
        return geboorte;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    public Medaille getMedaille() {
        return medaille;
    }

    public Kampioenschap getKampioenschap() {
        return kampioenschap;
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
        return naam != null ? naam.hashCode() : 0;
    }

    @Override
    public int compareTo(Judoka andereJudoka) {
        return this.naam.compareTo(andereJudoka.getNaam());
    }

    @Override
    public String toString() {
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return String.format("%-20s %-10s (°%-12s) %-6d %-15s %-10s %-10s", this.naam, this.geslacht, shortFormatter.format(this.geboorte),
                this.gewicht, this.gewichtsklasse, this.medaille, this.kampioenschap);
    }
}


