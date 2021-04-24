package be.kdg.judokas;

import be.kdg.judokas.model.Judokas;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.data.Data;
import be.kdg.judokas.threading.JudokaCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_08 {
    public static void main(String[] args) {
        List<Judoka> judokaList = Data.getData();
        List<Judoka> zwareJudokas = judokaList.stream()
                .sorted()
                .filter(j -> j.getGewicht() > 70)
                .collect(Collectors.toList());

        List<Judoka> lichteJudokas = judokaList.stream()
                .sorted()
                .filter(j -> j.getGewicht() < 71)
                .collect(Collectors.toList());

        ExecutorService pool = Executors.newFixedThreadPool(2);
        JudokaCallable callable1 = new JudokaCallable(zwareJudokas);
        Future future1 = pool.submit(callable1);
        JudokaCallable callable2 = new JudokaCallable(lichteJudokas);
        Future future2 = pool.submit(callable2);

        System.out.println("Zware judokas: ");
        zwareJudokas.forEach(System.out::println);
        try {
            System.out.printf("Gemiddelde van de zware judokas: %s%n", future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Lichte judokas: ");
        lichteJudokas.forEach(System.out::println);
        try {
            System.out.printf("Gemiddelde van de lichte judokas: %s%n", future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println();

        pool.shutdown();
    }
}
