package be.kdg.judokas.model;

import java.util.*;
import java.util.function.Function;

/**
 * MULTIKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

public class Judokas {
    private Set<Judoka> set;

    public Judokas() {
        this.set = new TreeSet<>();
    }

    public boolean voegToe(Judoka judoka){
        return this.set.add(judoka);
    }

    public boolean verwijder(Judoka judoka){
        return  this.set.remove(judoka);
    }

    public List<Judoka> gesorteerdOpNaam(){
        return gesorteerdOp(Judoka::getNaam);
    }

    public List<Judoka> gesorteerdOpGeboorte(){
       return gesorteerdOp(Judoka::getGeboorte);
    }

    public List<Judoka> gesorteerdOp (Function<Judoka,Comparable> function) {
        List<Judoka> lijst = new ArrayList<>(this.set);
        Collections.sort(lijst, Comparator.comparing(function));
        return lijst;
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
