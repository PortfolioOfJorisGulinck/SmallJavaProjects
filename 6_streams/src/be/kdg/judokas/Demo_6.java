package be.kdg.judokas;

import be.kdg.judokas.data.Data;
import be.kdg.judokas.model.Judoka;
import be.kdg.util.Functions;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by Joris Gulinck on 6/08/2017.
 */
public class Demo_6 {
    public static void main(String[] args) {
        List<Judoka> lijst = new ArrayList<>(Data.getData());

        long aantal = lijst.stream()
                .filter(judoka -> judoka.getGewicht() > 70)
                .count();
        System.out.println("Aantal judokas met een gewicht boven de 70kg: " + aantal);
        System.out.println();

        System.out.println("Alle judokas gesorteerd op medaille en dan op gewicht:");
        lijst.stream()
                .sorted((o1, o2) -> {
                    if (o1.getMedaille().equals(o2.getMedaille())) {
                        return o2.getGewicht() - o1.getGewicht();
                    }
                    return o1.getMedaille().compareTo(o2.getMedaille());
                })
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Alle gewichtsklasses in hoofdletters, omgekeerd gesorteerd en zonder dubbels:");
        String gewKlasses = lijst.stream()
                .map(judoka -> judoka.getGewichtsklasse().name().toUpperCase())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
        System.out.println(gewKlasses);
        System.out.println();

        System.out.println("Een willekeurige judoka met en gewicht hoger dan 80kg: ");
        Optional<Judoka> optionalJudoka = lijst.stream()
                .filter(judoka -> judoka.getGewicht() > 80)
                .findAny();
        Judoka anyJudoka = optionalJudoka.get();
        System.out.println(anyJudoka.getNaam() + " : " + anyJudoka.getGewicht());
        System.out.println();

        System.out.print("De judoka met de hoogste leeftijd: ");
        Judoka judoka = lijst.stream()
                .min(Comparator.comparing(Judoka::getGeboorte))
                .get();
        System.out.print(judoka.getNaam() + ", geboren te " + judoka.getGeboorte());
        System.out.println();

        System.out.println("List met gesorteerde judokanamen die beginnen met 'A': ");
        List<String> judokasMetA = lijst.stream()
                .filter(judoPersoon -> judoPersoon.getNaam().charAt(0) == 'A')
                .sorted()
                .map(Judoka::getNaam)
                .collect(Collectors.toList());
        System.out.println(judokasMetA);
        System.out.println();

        System.out.println("Sublist met judokas geboren voor 1970: ");
        Map<Boolean,List<Judoka>> judoMap = lijst.stream()
                .sorted(Comparator.comparing(Judoka::getGeboorte))
                .collect(Collectors.partitioningBy(judoka1 -> judoka1.getGeboorte().isBefore(LocalDate.of(1970,1,1))));
        for(Judoka judoPersoon : judoMap.get(true)){
            System.out.println(judoPersoon);
        }
        System.out.println();
        System.out.println("Sublist met kampioenen geboren na 1970: ");
        for(Judoka judoPersoon : judoMap.get(false)){
            System.out.println(judoPersoon);
        }
        System.out.println();

        // Uit de klasse Functions:
        long gewicht = Functions.countWith(lijst, judoka2 -> judoka2.getGewicht() > 80);
        System.out.println("Aantal judokas met een gewicht boven de 80kg: " + gewicht);
        Functions.countWith(lijst, judoka2 -> judoka2.getGewichtsklasse().name().endsWith("licht"));
        System.out.println("Aantal judokas waarvan de gewichtsklasse eindigt op 'licht': " + aantal);
    }
}
