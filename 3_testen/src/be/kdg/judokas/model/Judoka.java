package be.kdg.judokas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * BASISKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 *
 * BASISKLASSE groeiproject. Deze klasse maakt een nieuwe Judoka.
 * @author Joris Gulinck
 * @version 1.0
 */

public class Judoka implements Comparable<Judoka>{
    private String naam;
    private Geslacht geslacht; //Enum
    private LocalDate geboorte;
    private int gewicht; // in kg
    private Gewichtsklasse gewichtsklasse; //Enum
    private Medaille medaille; //Enum
    private Kampioenschap kampioenschap; //Enum

    /**
     * Constructor die een Judoka object maakt. Deze constructor bevat ook de methode berekenGewichtsklasse().
     * @param naam naam van de Judoka
     * @param geslacht geslacht van de Judoka
     * @param geboorte geboortedatum van de Judoka
     * @param gewicht het gewicht in kg van de Judoka
     * @param medaille de hoogste medaile die de Judoka ooit heeft behaald
     * @param kampioenschap het hoogste competitieniveau waar de Judoka ooit een medaille heeft behaald
     */

    public Judoka(String naam, Geslacht geslacht, LocalDate geboorte, int gewicht, Medaille medaille, Kampioenschap kampioenschap) {
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

        berekenGewichtsklasse(gewicht, geslacht);
    }

    /**
     * Plaatst een Judoka in zijn gepaste gewichtsklasse. Deze methode wordt gebruikt in de constructor.
     * @param gewicht het gewicht in kg van de Judoka
     * @param geslacht geslacht van de Judoka
     */
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

    /**
     * Geeft de naam van de Judoka
     * @return de naam als String
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Wijzigt de naam van de Judoka
     * @param naam naam van de Judoka
     */
    public void setNaam(String naam) {
        if (naam == null || naam.isEmpty()){
            throw new IllegalArgumentException("Foutieve waarde voor de naam");
        } else {
            this.naam = naam;
        }
    }

    /**
     * Geeft het geslacht van de Judoka
     * @return het geslacht uit de enum Geslacht
     */
    public Geslacht getGeslacht() {
        return geslacht;
    }

    /**
     * Wijzigt het geslacht van de Judoka
     * @param geslacht geslacht van de Judoka uit de enum Geslacht
     */
    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null){
            throw new IllegalArgumentException("Foutieve waarde voor de geslacht");
        } else {
            this.geslacht = geslacht;
        }
    }

    /**
     * Geeft de geboortedatum van de Judoka
     * @return de geboortedatum als LocalDate
     */
    public LocalDate getGeboorte() {
        return geboorte;
    }

    /**
     * Wijzigt de geboortedatum van de Judoka
     * @param geboorte de geboortedatum van de Judoka
     */
    public void setGeboorte(LocalDate geboorte) {
        if(geboorte.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("De judoka kan nog niet zijn geboren");
        } else{
            this.geboorte = geboorte;
        }
    }

    /**
     * Geeft het gewicht in kg van de Judoka
     * @return het gewicht in kg als int
     */
    public int getGewicht() {
        return gewicht;
    }

    /**
     * Wijzigt het gewicht van de Judoka
     */
    public void setGewicht() {
        if (gewicht <= 0){
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }
    }

    /**
     * Geeft de gewichtsklasse van de Judoka
     * @return de gewichtsklasse uit de enum Gewichtsklasse
     */
    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    /**
     * Geeft de hoogste medaile die de Judoka ooit heeft behaald
     * @return de medaille uit de enum Medaille
     */
    public Medaille getMedaille() {
        return medaille;
    }

    /**
     * Wijzigt de hoogste medaille die de Judoka ooit heeft behaald
     * @param medaille medaille uit de enum Medaille
     */
    public void setMedaille(Medaille medaille) {
        if (medaille == null){
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }
    }

    /**
     * Geeft het hoogste competitieniveau waar de Judoka ooit een medaille heeft behaald
     * @return competitieniveau uit de enum Kampioenschap
     */
    public Kampioenschap getKampioenschap() {
        return kampioenschap;
    }

    /**
     * Wijzigt het hoogste competitieniveau waar de Judoka ooit een medaille heeft behaald
     * @param kampioenschap competitieniveau uit de enum Kampioenschap
     */
    public void setKampioenschap(Kampioenschap kampioenschap) {
        if (kampioenschap ==null){
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.kampioenschap = kampioenschap;
        }
    }

    /**
     * Laat je toe dit object te vergelijken met een andere Judoka aan de hand van de naam van de Judoka
     * @param o het object
     * @return true al beide Judokas dezelfde naam hebben
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Judoka judoka = (Judoka) o;

        return getNaam().equals(judoka.getNaam());
    }

    /**
     * Geeft de hashcode van het object als int
     * @return hashcode van het object
     */
    @Override
    public int hashCode() {
        return naam != null ? naam.hashCode() : 0;
    }

    /**
     * Laat je toe dit object te vergelijken met een ander kampioen object
     * @param andereJudoka een object van de Judoka classe
     * @return een negatieve integer, nul, of een positieve integer als het object kleiner is dan, gelijk of groter
     * dan het specifieke object, gebasseerd op zijn naam
     */
    @Override
    public int compareTo(Judoka andereJudoka) {
        return this.naam.compareTo(andereJudoka.getNaam());
    }

    /**
     * Zet het Judoka object om in een leesbaar formaat
     * @return de Judoka als String
     */
    @Override
    public String toString() {
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return String.format("%-20s %-10s (°%-12s) %-6d %-15s %-10s %-10s", this.naam, this.geslacht, shortFormatter.format(this.geboorte),
                this.gewicht, this.gewichtsklasse, this.medaille, this.kampioenschap);
    }
}


