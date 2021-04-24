package be.kdg.judokas.model;

import java.util.*;

/**
 * MULTIKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 *
 * MULTIKLASSE groeiproject. Maakt een lijst van Judokas aan.
 * @author Joris Gulinck
 * @version 1.0
 */

public class Judokas {
    private Set<Judoka> set;

    /**
     * Constructor die een geordende lijst (TreeSet) van unieke Judokas maakt
     */
    public Judokas() {
        this.set = new TreeSet<>();
    }

    /**
     * Geeft de lijst (TreeSet) van unieke Judokas terug
     * @return lijst (TreeSet) van unieke Judokas
     */
    public Set<Judoka> getSet() {
        return set;
    }

    /**
     * Laat toe een Judoka object toe te voegen aan de lijst als het niet reeds in de lijst aanwezig is. Dit wordt
     * bepaald aan de hand van de naam.
     * @param judoka een Judoka object
     * @return true als het object werd toegevoegd
     */
    public boolean voegToe(Judoka judoka){
        return this.set.add(judoka);
    }

    /**
     * Laat toe een kampioenobject te verwijderen uit de lijst als het aanwezig is
     * @param judoka een Judoka object
     * @return true als het object werd verwijderd uit de lijst
     */
    public boolean verwijder(Judoka judoka){
        return  this.set.remove(judoka);
    }

    /**
     * Geeft een lijst terug als Arraylist gesorteerd op naam
     * @return Arraylist van Judoka objecten
     */
    public List<Judoka> gesorteerdOpNaam(){
        return new ArrayList<>(this.set);
    }

    /**
     * Geeft een lijst terug als Arraylist gesorteerd op geboortedatum
     * @return Arraylist van Judoka objecten
     */
    public List<Judoka> gesorteerdOpGeboorte(){
        List<Judoka> nieuweLijst = new ArrayList<>(this.set);
        Collections.sort(nieuweLijst, new Comparator<Judoka>() {
            @Override
            public int compare(Judoka o1, Judoka o2) {
                if (o1.getGeboorte().getYear() - o2.getGeboorte().getYear() == 0){
                    return o1.getGeboorte().getMonthValue() - o2.getGeboorte().getMonthValue();
                } else {
                    return o1.getGeboorte().getYear() - o2.getGeboorte().getYear();
                }
            }
        });
        return nieuweLijst;
    }

    /**
     * Zet de lijst met Judoka objecten om in een leesbaar formaat
     * @return de lijst Judokas als String
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Judoka judoka : set){
            stringBuilder.append(judoka.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
