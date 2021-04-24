import org.junit.Before;
import org.junit.Test;
import be.kdg.judokas.model.Judoka;

import java.time.LocalDate;

import static be.kdg.judokas.model.Geslacht.*;
import static be.kdg.judokas.model.Kampioenschap.*;
import static be.kdg.judokas.model.Medaille.*;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class JudokaTest {
    private static Judoka judoka1;
    private static Judoka judoka2;

    @Before
    public void setUp() {
        judoka1 = new Judoka("Ingrid Berghmans", VROUW, LocalDate.of(1961, 8, 24), 72, GOUD, OLYMPISCH);
        judoka2 = new Judoka("Joachim Bottieau", MAN, LocalDate.of(1989, 3, 20), 73, GOUD, BELGISCH );
    }

    @Test
    public void testEquals() {
        Judoka judoka = new Judoka("Ingrid Berghmans", VROUW, LocalDate.of(1961, 8, 24), 72, GOUD, OLYMPISCH);
        assertEquals("De namen zijn gelijk", judoka1, judoka);
        assertEquals("De namen zijn ongelijk", judoka1, judoka2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testOngeldig(){
        judoka1.setNaam("");
        fail("De naam mag niet leeg zijn. Dit geeft een IllegalArgumentException");
    }

    @Test
    public void testGeldig(){
        judoka1.setNaam("John Beton");
    }

    @Test
    public void testCompareTo(){
        assertTrue("CompareTo sorteert op naam: ", judoka1.compareTo(judoka2) > 0);
    }

    @Test
    public void testMethode(){
        assertEquals("Deze waarden verschillen slechts 1 van elkaar: ",
                1,(double)judoka2.getGewicht() - (double)judoka1.getGewicht(),2.0);
    }

}
