package be.kdg.judokas.patterns;

import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;
import be.kdg.judokas.model.JudokasSet;

import java.util.Collections;
import java.util.List;

/**
 * Created by Joris Gulinck on 3/08/2017.
 */
public class UnmodifiableJudokas implements Judokas {
    private JudokasSet judokasSet;

    public UnmodifiableJudokas(JudokasSet judokasSet) {
        this.judokasSet = judokasSet;
    }

    @Override
    public boolean voegToe(Judoka judoka) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public boolean verwijder(Judoka judoka) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<Judoka> gesorteerdOpNaam() {
        return Collections.unmodifiableList(judokasSet.gesorteerdOpNaam());
    }

    @Override
    public List<Judoka> gesorteerdOpGeboorte() {
        return Collections.unmodifiableList(judokasSet.gesorteerdOpGeboorte());
    }
}
