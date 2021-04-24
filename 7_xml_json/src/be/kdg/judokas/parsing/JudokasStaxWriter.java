package be.kdg.judokas.parsing;

import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import static be.kdg.judokas.parsing.StaxUtil.writeSimpleElement;

/**
 * Created by Joris Gulinck on 8/08/2017.
 */
public class JudokasStaxWriter {
    private Judokas judokas;

    public JudokasStaxWriter(Judokas judokas) {
        this.judokas = judokas;
    }

    public void xmlWriter(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("Judokas");
        for (Judoka judoka : judokas.gesorteerdOpNaam()) {
            judokaWriter(writer, judoka);
        }
        writer.writeEndElement();

    }

    public void judokaWriter(XMLStreamWriter writer, Judoka judoka) throws XMLStreamException{
        writer.writeStartElement("Judoka");
        writer.writeAttribute("gewichtsklasse", judoka.getGewichtsklasse().name());
        writeSimpleElement(writer, "naam", judoka.getNaam());
        writeSimpleElement(writer, "geslacht", judoka.getGeslacht().name());
        writeSimpleElement(writer, "geboorte", judoka.getGeboorte().toString());
        writeSimpleElement(writer, "gewicht", Integer.toString(judoka.getGewicht()));
        writeSimpleElement(writer, "medaille", judoka.getMedaille().name());
        writeSimpleElement(writer, "kampioenschap", judoka.getKampioenschap().name());
        writer.writeEndElement();
    }
}


