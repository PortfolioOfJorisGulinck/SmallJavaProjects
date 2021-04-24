package be.kdg.judokas.parsing;

import be.kdg.judokas.model.Judokas;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Joris Gulinck on 13/08/2017.
 */
public class JaxbIO {
    public static void JaxbWriteXml(String file, Object root){
        try {
            JAXBContext context = JAXBContext.newInstance(root.getClass());
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(root, new File(file));
            jaxbMarshaller.marshal(root, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <T> T JaxbReadXml(String file, Class<T> typeParameterClass){
        Judokas judokas = new Judokas();
        try {
            JAXBContext context = JAXBContext.newInstance(typeParameterClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            judokas = (Judokas) unmarshaller.unmarshal(new File(file));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return (T) judokas;
    }
}
