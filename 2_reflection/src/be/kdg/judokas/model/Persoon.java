package be.kdg.judokas.model;

import be.kdg.judokas.reflection.CanRun;

import java.time.LocalDate;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Persoon {
    private String naam;
    private Geslacht geslacht; //Enum
    private LocalDate geboorte;
    private int gewicht; // in kg

    public Persoon(String naam, Geslacht geslacht, LocalDate geboorte, int gewicht) {
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
        } else{
            this.geboorte = geboorte;
        }
        if (gewicht <= 0){
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }
    }

    public String getNaam() {
        return naam;
    }

    @CanRun
    public void setNaam(String naam) {
        if (naam == null || naam.isEmpty()){
            throw new IllegalArgumentException("Foutieve waarde voor de naam");
        } else {
            this.naam = naam;
        }
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null){
            throw new IllegalArgumentException("Foutieve waarde voor de geslacht");
        } else {
            this.geslacht = geslacht;
        }
    }

    public LocalDate getGeboorte() {
        return geboorte;
    }

    public void setGeboorte(LocalDate geboorte) {
        if(geboorte.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("De judoka kan nog niet zijn geboren");
        } else{
            this.geboorte = geboorte;
        }
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        if (gewicht <= 0){
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }
    }
}
