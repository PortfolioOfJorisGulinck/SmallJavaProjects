package be.kdg.judokas.model;

import java.util.List;

/**
 * Created by Joris Gulinck on 3/08/2017.
 */
public interface Judokas {
    boolean voegToe(Judoka judoka);

    boolean verwijder(Judoka judoka);

    List<Judoka> gesorteerdOpNaam();

    List<Judoka> gesorteerdOpGeboorte();

    @Override
    String toString();
}
