package be.kdg.judokas;

import be.kdg.judokas.model.Judokas;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.data.Data;
import be.kdg.judokas.parsing.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class Demo_07 {
    public static void main(String[] args) {
        // Vraag 2.2
        Judokas judokas = new Judokas();
        List<Judoka> lijst = Data.getData();
        for(Judoka judoka : lijst){
            judokas.voegToe(judoka);
        }

        JudokasStaxWriter processor = new JudokasStaxWriter(judokas);
        StaxUtil.writeFile("7_xml_json\\files\\judokas.xml",processor);

        // vraag 2.6
        Judokas readXml = JudokasDOMParser.domeReadXml("7_xml_json\\files\\judokas.xml");
        System.out.println(readXml.toString());
        System.out.println();

        // vraag 2.8
        JaxbIO.JaxbWriteXml("7_xml_json\\files\\jaxb_judokas.xml",judokas);
        System.out.println();

        // vraag 2.9
        Judokas inJaxb = JaxbIO.JaxbReadXml("7_xml_json\\files\\jaxb_judokas.xml",Judokas.class);
        System.out.println(inJaxb.toString());
        System.out.println();

        // vraag 3
        JsonIO.writeJson(judokas,"7_xml_json\\files\\json_judokas.json");
        Judokas inJson = JsonIO.readJson("7_xml_json\\files\\json_judokas.json");
        System.out.println(inJson.toString());

    }
}
