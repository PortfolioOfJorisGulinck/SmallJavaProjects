package be.kdg.judokas.model;

import be.kdg.judokas.persist.JudokasDao;

import java.io.Serializable;
import java.util.*;

/**
 * MULTIKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

public class Judokas implements Serializable, JudokasDao{
    private Set<Judoka> set;

    public Judokas() {
        this.set = new TreeSet<>();
    }

    @Override
    public boolean voegToe(Judoka judoka){
        return this.set.add(judoka);
    }

    @Override
    public boolean verwijder(Judoka judoka){
        return  this.set.remove(judoka);
    }

    @Override
    public List<Judoka> gesorteerdOpNaam(){
        return new ArrayList<>(this.set);
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Judokas judokas = (Judokas) o;

        return set.equals(judokas.set);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Judoka judoka: set){
            stringBuilder.append(judoka.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
