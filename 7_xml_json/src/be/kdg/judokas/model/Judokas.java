package be.kdg.judokas.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * MULTIKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

@XmlRootElement
public class Judokas {
    private List<Judoka> set;

    public Judokas() {
        this.set = new ArrayList<>();
    }

    public boolean voegToe(Judoka judoka){
        return this.set.add(judoka);
    }

    public boolean verwijder(Judoka judoka){
        return  this.set.remove(judoka);
    }

    public List<Judoka> gesorteerdOpNaam(){
        return new ArrayList<>(this.set);
    }

    public List<Judoka> gesorteerdOpGeboorte(){
        List<Judoka> nieuweLijst = new ArrayList<>(this.set);
        Collections.sort(nieuweLijst, (o1, o2) -> {
            if (o1.getGeboorte().getYear() - o2.getGeboorte().getYear() == 0){
                return o1.getGeboorte().getMonthValue() - o2.getGeboorte().getMonthValue();
            } else {
                return o1.getGeboorte().getYear() - o2.getGeboorte().getYear();
            }
        });
        return nieuweLijst;
    }

    public List<Judoka> getSet() {
        return set;
    }

    @XmlElement(name = "judoka")
    public void setSet(List<Judoka> set) {
        this.set = set;
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
