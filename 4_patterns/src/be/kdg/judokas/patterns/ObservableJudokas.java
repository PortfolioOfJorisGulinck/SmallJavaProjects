package be.kdg.judokas.patterns;

import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;
import be.kdg.judokas.model.JudokasSet;

import java.util.List;
import java.util.Observable;

/**
 * Created by Joris Gulinck on 3/08/2017.
 */
public class ObservableJudokas extends Observable implements Judokas {
    private JudokasSet judokas;

    public ObservableJudokas(JudokasSet judokas) {
        this.judokas = judokas;
    }

    @Override
    public boolean voegToe(Judoka judoka) {
        boolean nieuweJudoka = judokas.voegToe(judoka);
        if (nieuweJudoka) {
            setChanged();
            notifyObservers("Toegevoegd: " + judoka );
        }
        return nieuweJudoka;
    }

    @Override
    public boolean verwijder(Judoka judoka) {
        boolean overbodigeJudoka = judokas.verwijder(judoka);
        if (overbodigeJudoka) {
            setChanged();
            notifyObservers("Verwijderd: " + judoka);
        }
        return overbodigeJudoka;
    }

    @Override
    public List<Judoka> gesorteerdOpNaam() {
        return judokas.gesorteerdOpNaam();
    }

    @Override
    public List<Judoka> gesorteerdOpGeboorte() {
        return judokas.gesorteerdOpGeboorte();
    }
}
