package be.kdg.judokas;


import be.kdg.judokas.data.Data;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.persist.JudokasDbDao;

import java.util.List;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_05 {
    public static void main(String[] args) {
        int index = 0;
        JudokasDbDao judoDb = null;

        try {
            judoDb = new JudokasDbDao("jdbc:hsqldb:file:5_persistentie/db/judoDb");

            List<Judoka> lijst = Data.getData();
            for (Judoka judoka : lijst) {
                judoDb.voegToe(judoka);
                judoka.setId(index++);
            }

            System.out.println("Judoka met PK 0: ");
            System.out.println(judoDb.zoek(0));
            System.out.println();

            judoDb.verwijder(judoDb.zoek(0));

            System.out.println("Gesorteerd op naam: ");
            List<Judoka> naamLijst = judoDb.gesorteerdOpNaam();
            for(Judoka judoka : naamLijst){
                System.out.println(judoka);
            }

            System.out.println("Gesorteerd op geboortedatum: ");
            List<Judoka> geboorteLijst = judoDb.gesorteerdOpGeboorte();
            for(Judoka judoka : geboorteLijst){
                System.out.println(judoka);
            }

            System.out.println("Gefilterd op gewicht: ");
            List<Judoka> gewichtLijst = judoDb.filterGewicht(50);
            for(Judoka judoka : gewichtLijst){
                System.out.println(judoka);
            }

            System.out.println("Update met ID = 1: ");
            lijst.get(1).setNaam("John Beton");
            judoDb.updateJudoka(lijst.get(1));
            System.out.println(judoDb.zoek(1));

        } finally {
          judoDb.closeConnection();
        }
    }
}
