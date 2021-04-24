package be.kdg.judokas.model;

import be.kdg.judokas.parsing.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * BASISKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

@XmlType(propOrder = {"naam", "geslacht", "geboorte", "gewicht", "medaille", "kampioenschap"})
@XmlRootElement
public class Judoka implements Comparable<Judoka> {
    private String naam;
    private Geslacht geslacht; //Enum
    private LocalDate geboorte;
    private int gewicht; // in kg
    private Gewichtsklasse gewichtsklasse; //Enum
    private Medaille medaille; //Enum
    private Kampioenschap kampioenschap; //Enum

    public Judoka() {
    }

    public Judoka(String naam, Geslacht geslacht, LocalDate geboorte, int gewicht, Medaille medaille, Kampioenschap kampioenschap) {
        if (naam == null || naam.isEmpty()) {
            throw new IllegalArgumentException("Foutieve waarde voor de naam");
        } else {
            this.naam = naam;
        }

        if (geslacht == null) {
            throw new IllegalArgumentException("Foutieve waarde voor de geslacht");
        } else {
            this.geslacht = geslacht;
        }

        if (geboorte.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("De judoka kan nog niet zijn geboren");
        } else {
            this.geboorte = geboorte;
        }

        if (gewicht <= 0) {
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }

        if (medaille == null) {
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }

        if (kampioenschap == null) {
            throw new IllegalArgumentException("Foutieve waarde voor de kampioenschap");
        } else {
            this.kampioenschap = kampioenschap;
        }

        berekenGewichtsklasse(gewicht, geslacht);
    }

    private void berekenGewichtsklasse(int gewicht, Geslacht geslacht) {
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

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isEmpty()) {
            throw new IllegalArgumentException("Foutieve waarde voor de naam");
        } else {
            this.naam = naam;
        }
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null) {
            throw new IllegalArgumentException("Foutieve waarde voor de geslacht");
        } else {
            this.geslacht = geslacht;
        }
    }

    public LocalDate getGeboorte() {
        return geboorte;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setGeboorte(LocalDate geboorte) {
        if (geboorte.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("De judoka kan nog niet zijn geboren");
        } else {
            this.geboorte = geboorte;
        }
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        if (gewicht <= 0) {
            throw new IllegalArgumentException("Het gewicht moet groter zijn dan 0");
        } else {
            this.gewicht = gewicht;
        }
    }

    @XmlAttribute(name = "gewichtsklasse")
    public void setGewichtsklasse(Gewichtsklasse gewichtsklasse) {
        this.gewichtsklasse = gewichtsklasse;
    }

    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    public Medaille getMedaille() {
        return medaille;
    }

    public void setMedaille(Medaille medaille) {
        if (medaille == null) {
            throw new IllegalArgumentException("Foutieve waarde voor de medaille");
        } else {
            this.medaille = medaille;
        }
    }

    public Kampioenschap getKampioenschap() {
        return kampioenschap;
    }

    public void setKampioenschap(Kampioenschap kampioenschap) {
        if (kampioenschap == null) {
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


