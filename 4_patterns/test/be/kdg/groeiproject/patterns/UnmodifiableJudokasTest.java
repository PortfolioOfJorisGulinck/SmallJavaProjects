package be.kdg.groeiproject.patterns;

import org.junit.Before;
import org.junit.Test;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.JudokasSet;
import be.kdg.judokas.patterns.UnmodifiableJudokas;

import java.time.LocalDate;

/**
 * Created by Joris Gulinck on 3/08/2017.
 */
public class UnmodifiableJudokasTest {
    private static Judoka judoka;
    private static JudokasSet judokasSet;
    private static UnmodifiableJudokas proxySet;

    @Before
    public void setUp() {
        judoka = new Judoka("Ingrid Berghmans", VROUW, LocalDate.of(1961, 8, 24), 72, GOUD, OLYMPISCH);
        judokasSet = new JudokasSet();
        judokasSet.voegToe(judoka);
        proxySet = new UnmodifiableJudokas(judokasSet);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void voegToe()  {
        Judoka judoka1 = new Judoka("Joachim Bottieau", MAN, LocalDate.of(1989, 3, 20), 73, GOUD, BELGISCH);
        proxySet.voegToe(judoka1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verwijder()  {
        Judoka judoka2 = new Judoka("Théo Guldemont", MAN, LocalDate.of(1930, 12, 19), 65,  BRONS, BELGISCH);
        proxySet.verwijder(judoka2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void gesorteerdOpNaam(){
        Judoka judoka3 = new Judoka("Daniel Outelet", MAN, LocalDate.of(1936, 3, 11), 73, GOUD, EUROPEES);
        proxySet.gesorteerdOpNaam().add(judoka3);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void gesorteerdOpTitels(){
        proxySet.gesorteerdOpNaam().remove(judoka);
    }

}
