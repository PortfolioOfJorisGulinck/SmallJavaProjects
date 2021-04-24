package be.kdg.util;

import be.kdg.judokas.model.Judoka;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Joris Gulinck on 6/08/2017.
 */
public class Functions {
    public static <T> long countWith(List<T> basislijst, Predicate<T> predicate){
        long aantal = 0;
        for(T match : basislijst){
            if(predicate.test(match)){
                aantal++;
            }
        }
        return aantal;
    }
}
