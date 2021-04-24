package be.kdg.judokas.data;

import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Medaille;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */

public class Data {
    public static List<Judoka> getData() {
        List<Judoka> data = new ArrayList<>();
        data.add(new Judoka("Ingrid Berghmans", VROUW, LocalDate.of(1961, 8, 24), 72, Medaille.GOUD, OLYMPISCH));
        data.add(new Judoka("Joachim Bottieau", MAN, LocalDate.of(1989, 3, 20), 81, Medaille.GOUD, BELGISCH ));
        data.add(new Judoka("Jean-Marie Dedecker", MAN, LocalDate.of(1952, 6, 13), 85, Medaille.ZILVER, EUROPEES));
        data.add(new Judoka("Roland Cambier", MAN, LocalDate.of(1925, 11, 12), 72, Medaille.GOUD, BELGISCH));
        data.add(new Judoka("Lotte Denoo", VROUW, LocalDate.of(1990, 11, 5), 57, Medaille.GOUD, BELGISCH));
        data.add(new Judoka("Théo Guldemont", MAN, LocalDate.of(1930, 12, 19), 65,  Medaille.BRONS, BELGISCH));
        data.add(new Judoka("Ilse Heylen", VROUW, LocalDate.of(1977, 3, 21), 52, Medaille.BRONS, OLYMPISCH));
        data.add(new Judoka("Jeannine Meulemans", VROUW, LocalDate.of(1951, 3, 30), 56, Medaille.GOUD, BELGISCH));
        data.add(new Judoka("Daniel Outelet", MAN, LocalDate.of(1936, 3, 11), 73, Medaille.GOUD, EUROPEES));
        data.add(new Judoka("Robert Plomb", MAN, LocalDate.of(1920, 10, 19), 67, Medaille.ZILVER, EUROPEES));
        data.add(new Judoka("Heidi Rakels", VROUW, LocalDate.of(1968, 6, 22), 70, Medaille.BRONS, OLYMPISCH));
        data.add(new Judoka("Amalie Rosseneu", VROUW, LocalDate.of(1988, 1, 18), 47, Medaille.GOUD, BELGISCH));
        data.add(new Judoka("Ann Simons", VROUW, LocalDate.of(1980, 8, 5), 48, Medaille.BRONS, OLYMPISCH));
        data.add(new Judoka("Marc Vallot", MAN, LocalDate.of(1962, 5, 24), 78, Medaille.GOUD, BELGISCH));
        data.add(new Judoka("Harry Van Barneveld", MAN, LocalDate.of(1967, 2, 18), 125, Medaille.BRONS, OLYMPISCH));
        return data;
    }
}
