package be.kdg.judokas.persist;

import be.kdg.judokas.model.Judoka;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joris Gulinck on 5/08/2017.
 */
public interface JudokasDao extends Serializable {
    boolean voegToe(Judoka judoka);

    boolean verwijder(Judoka judoka);

    List<Judoka> gesorteerdOpNaam();

    List<Judoka> gesorteerdOpGeboorte();
}
