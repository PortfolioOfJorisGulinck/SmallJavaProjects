package be.kdg.judokas.parsing;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by Joris Gulinck on 13/08/2017.
 */
public class LocalDateAdapter extends XmlAdapter<String,LocalDate> {

    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }
}