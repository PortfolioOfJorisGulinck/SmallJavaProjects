package be.kdg.judokas;


import be.kdg.judokas.data.Data;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_03 {
    public static void main(String[] args) {
        Judokas judokas = new Judokas();
        List<Judoka> lijst = new ArrayList<>(Data.getData());
        for (Judoka judoka : lijst) {
            judokas.voegToe(judoka);
        }

        System.out.println("Judokas gesorteerd op naam");
        List<Judoka> naamSort = judokas.gesorteerdOpNaam();
        for(Judoka judoka : naamSort){
            System.out.println(judoka);
        }
        System.out.println();

        System.out.println("Judokas gesorteerd op geboortedatum");
        List<Judoka> titelSort = judokas.gesorteerdOpGeboorte();
        for(Judoka judoka : titelSort){
            System.out.println(judoka);
        }
    }
}
