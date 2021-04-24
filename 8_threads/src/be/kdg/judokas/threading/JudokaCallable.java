package be.kdg.judokas.threading;

import be.kdg.judokas.model.Judoka;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Joris Gulinck on 13/08/2017.
 */
public class JudokaCallable implements Callable {
    private List<Judoka> judokas;

    public JudokaCallable(List<Judoka> judokas) {
        this.judokas = judokas;
    }

    @Override
    public Object call() throws Exception {
        return judokas.stream()
                .mapToInt(Judoka::getGewicht)
                .average()
                .getAsDouble();
    }
}
