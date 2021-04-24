package be.kdg.judokas.data;

import be.kdg.judokas.model.Geslacht;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Kampioenschap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */

public class Data {
    public static List<Judoka> getData() {
        List<Judoka> data = new ArrayList<>();
        data.add(new Judoka("Ingrid Berghmans", Geslacht.VROUW, LocalDate.of(1961, 8, 24), 72, GOUD, Kampioenschap.OLYMPISCH));
        data.add(new Judoka("Joachim Bottieau", Geslacht.MAN, LocalDate.of(1989, 3, 20), 81, GOUD, Kampioenschap.BELGISCH ));
        data.add(new Judoka("Jean-Marie Dedecker", Geslacht.MAN, LocalDate.of(1952, 6, 13), 85, ZILVER, Kampioenschap.EUROPEES));
        data.add(new Judoka("Roland Cambier", Geslacht.MAN, LocalDate.of(1925, 11, 12), 72, GOUD, Kampioenschap.BELGISCH));
        data.add(new Judoka("Lotte Denoo", Geslacht.VROUW, LocalDate.of(1990, 11, 5), 57, GOUD, Kampioenschap.BELGISCH));
        data.add(new Judoka("Théo Guldemont", Geslacht.MAN, LocalDate.of(1930, 12, 19), 65,  BRONS, Kampioenschap.BELGISCH));
        data.add(new Judoka("Ilse Heylen", Geslacht.VROUW, LocalDate.of(1977, 3, 21), 52, BRONS, Kampioenschap.OLYMPISCH));
        data.add(new Judoka("Jeannine Meulemans", Geslacht.VROUW, LocalDate.of(1951, 3, 30), 56, GOUD, Kampioenschap.BELGISCH));
        data.add(new Judoka("Daniel Outelet", Geslacht.MAN, LocalDate.of(1936, 3, 11), 73, GOUD, Kampioenschap.EUROPEES));
        data.add(new Judoka("Robert Plomb", Geslacht.MAN, LocalDate.of(1920, 10, 19), 67, ZILVER, Kampioenschap.EUROPEES));
        data.add(new Judoka("Heidi Rakels", Geslacht.VROUW, LocalDate.of(1968, 6, 22), 70, BRONS, Kampioenschap.OLYMPISCH));
        data.add(new Judoka("Amalie Rosseneu", Geslacht.VROUW, LocalDate.of(1988, 1, 18), 47, GOUD, Kampioenschap.BELGISCH));
        data.add(new Judoka("Ann Simons", Geslacht.VROUW, LocalDate.of(1980, 8, 5), 48, BRONS, Kampioenschap.OLYMPISCH));
        data.add(new Judoka("Marc Vallot", Geslacht.MAN, LocalDate.of(1962, 5, 24), 78, GOUD, Kampioenschap.BELGISCH));
        data.add(new Judoka("Harry Van Barneveld", Geslacht.MAN, LocalDate.of(1967, 2, 18), 125, BRONS, Kampioenschap.OLYMPISCH));
        return data;
    }
}
