package be.kdg.judokas;

import be.kdg.judokas.model.JudokasSet;
import be.kdg.judokas.data.Data;
import be.kdg.judokas.patterns.JudokasObserver;
import be.kdg.judokas.patterns.ObservableJudokas;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_04 {
    public static void main(String[] args) {
        JudokasSet judokasSet = new JudokasSet();
        ObservableJudokas judokas = new ObservableJudokas(judokasSet);
        JudokasObserver observer = new JudokasObserver(judokas);
        judokas.addObserver(observer);

        judokas.voegToe(Data.getData().get(5));
        judokas.voegToe(Data.getData().get(6));
        judokas.verwijder(Data.getData().get(5));
    }
}

