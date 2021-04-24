package be.kdg.judokas;



import be.kdg.judokas.model.Persoon;
import be.kdg.judokas.reflection.ReflectionTools;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_02 {
    public static void main(String[] args) {
        //ReflectionTools.classAnalysis(Judoka.class);
        //System.out.println();
        //ReflectionTools.classAnalysis(Judokas.class);
        System.out.println("Aangemaakt object door runAnnotated");
        System.out.println(ReflectionTools.runAnnotated(Persoon.class));
    }
}
