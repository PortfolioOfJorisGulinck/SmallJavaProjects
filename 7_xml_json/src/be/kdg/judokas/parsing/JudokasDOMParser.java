package be.kdg.judokas.parsing;

import be.kdg.judokas.model.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Joris Gulinck on 8/08/2017.
 */
public class JudokasDOMParser {
    public static Judokas domeReadXml(String filename){
        Judokas judokas = new Judokas();
        try {
            File inputfile = new File(filename);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputfile);

            Element rootElement = document.getRootElement();
            for (Element element : rootElement.getChildren()) {
                Judoka judoka = new Judoka(
                        getChildText(element, "naam"),
                        Geslacht.valueOf(getChildText(element, "geslacht")),
                        LocalDate.parse(getChildText(element, "geboorte")),
                        Integer.valueOf(getChildText(element, "gewicht")),
                        Medaille.valueOf(getChildText(element, "medaille")),
                        Kampioenschap.valueOf(getChildText(element, "kampioenschap"))
                );
                judokas.voegToe(judoka);
            }
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return judokas;
    }

    private static String getChildText(Element parent, String name){
        return parent.getChild(name).getText();
    }
}

