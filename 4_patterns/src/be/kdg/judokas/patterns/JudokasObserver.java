package be.kdg.judokas.patterns;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Joris Gulinck on 3/08/2017.
 */
public class  JudokasObserver implements Observer {
    private ObservableJudokas judokas;

    public JudokasObserver(ObservableJudokas judokas) {
        this.judokas = judokas;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer meldt: " + arg);
    }
}

