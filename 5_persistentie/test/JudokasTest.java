
import org.junit.Before;
import org.junit.Test;
import be.kdg.judokas.data.Data;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Joris Gulinck on 5/08/2017.
 */
public class JudokasTest {
    private Judokas judokas;

    @Before
    public void setUp() {
        judokas = new Judokas();
        List<Judoka> lijst = Data.getData();
        for (Judoka judoka : lijst) {
            judokas.voegToe(judoka);
        }
    }

    @Test
    public void serializableTest() {
        Judokas judokasKopie = null;
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("db" + File.separator + "judokas.ser"))){
            output.writeObject(judokas);
        } catch (IOException e) {
            System.out.println(e);
        }
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("db" + File.separator + "judokas.ser"))){
            judokasKopie = (Judokas) input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
        assertEquals(judokasKopie, judokas);
    }
}
