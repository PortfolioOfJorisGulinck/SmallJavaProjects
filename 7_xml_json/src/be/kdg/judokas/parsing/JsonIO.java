package be.kdg.judokas.parsing;

import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Judokas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Joris Gulinck on 13/08/2017.
 */
public class JsonIO {
    public static void writeJson(Judokas judokas, String fileName){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String jsonString = gson.toJson(judokas.getSet());
        try(FileWriter jsonWriter = new FileWriter(fileName)){
            jsonWriter.write(jsonString);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Judokas readJson(String fileName){
        Judokas judokas = new Judokas();
        try(BufferedReader data = new BufferedReader(new FileReader(fileName))){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.setPrettyPrinting().create();
            Judoka[] judoArray = gson.fromJson(data,Judoka[].class);
            for(Judoka judoka : judoArray){
                judokas.voegToe(judoka);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return judokas;
    }
}
