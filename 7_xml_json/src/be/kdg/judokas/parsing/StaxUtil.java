package be.kdg.judokas.parsing;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Joris Gulinck on 8/08/2017.
 */
public class StaxUtil {
    static void writeSimpleElement(XMLStreamWriter writer, String naam, String text) throws XMLStreamException {
        writer.writeStartElement(naam);
        writer.writeCharacters(text);
        writer.writeEndElement();
    }

    public static void writeFile(String fileName, JudokasStaxWriter processor){
        try {
            XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(fileName));
            writer = new IndentingXMLStreamWriter(writer);
            writer.writeStartDocument();
            processor.xmlWriter(writer);
            writer.writeEndDocument();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
