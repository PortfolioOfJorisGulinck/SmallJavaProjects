import org.junit.Before;
import org.junit.Test;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;
import static org.junit.Assert.*;

import java.time.LocalDate;

import static be.kdg.judokas.model.Geslacht.MAN;
import static be.kdg.judokas.model.Geslacht.VROUW;
import static be.kdg.judokas.model.Kampioenschap.BELGISCH;
import static be.kdg.judokas.model.Kampioenschap.EUROPEES;
import static be.kdg.judokas.model.Kampioenschap.OLYMPISCH;
import static be.kdg.judokas.model.Medaille.GOUD;
import static be.kdg.judokas.model.Medaille.ZILVER;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class JudokasTest {
    private static Judokas lijst;
    private static Judoka judoka;
    private static Judoka judoka1;
    private static Judoka judoka2;

    @Before
    public void setUp() {
        lijst = new Judokas();
        judoka = new Judoka("Jean-Marie Dedecker", MAN, LocalDate.of(1952, 6, 13), 85, ZILVER, EUROPEES);
        judoka1 = new Judoka("Ingrid Berghmans", VROUW, LocalDate.of(1961, 8, 24), 72, GOUD, OLYMPISCH);
        lijst.voegToe(judoka);
        lijst.voegToe(judoka1);
    }

    @Test
    public void voegToe(){
        judoka2 = new Judoka("Joachim Bottieau", MAN, LocalDate.of(1989, 3, 20), 73, GOUD, BELGISCH);
        lijst.voegToe(judoka2);
        int aantal = lijst.getSet().size();
        assertEquals(3, aantal);
    }

    @Test
    public void verwijder(){
        lijst.verwijder(judoka);
        int aantal = lijst.getSet().size();
        System.out.println(aantal);
        assertEquals(1, aantal);
    }
}
