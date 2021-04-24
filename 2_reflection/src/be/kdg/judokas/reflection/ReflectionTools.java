package be.kdg.judokas.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

/**
 * Created by Joris Gulinck on 30/07/2017.
 */
public class ReflectionTools {
    public static void classAnalysis(Class aClass){
        System.out.println("Analyse van de klasse: " + aClass.getSimpleName());
        System.out.println(String.join("", Collections.nCopies(30,"=")));
        System.out.println();

        //volledige naam
        System.out.println("Volledige naam: " + aClass.getName());
        System.out.println();

        //Naam van de supperklasse
        System.out.println("Naam van de superklasse: " + aClass.getSuperclass().getSimpleName());
        System.out.println();

        //Naam van de package
        System.out.println("Naam van de package: " + aClass.getPackage());
        System.out.println();

        //Naam van de interfaces
        System.out.print("Naam van de interfaces: ");
        for(int i = 0;i < aClass.getInterfaces().length;i++){
            System.out.print(aClass.getInterfaces()[i].getSimpleName() + " ");
        }
        System.out.println();
        System.out.println();


        //De constructors
        System.out.println("Constructors: ");
        for(Constructor constructor : aClass.getDeclaredConstructors()){
            System.out.printf("%s%n",constructor);
        }
        System.out.println();

        //Namen van de attributen
        System.out.print("Attributen: ");
        for(Field field : aClass.getDeclaredFields()){
            System.out.print(field.getName() + " ");
        }
        System.out.println();

        //namen van de getters, setters en andere methoden
        System.out.print("Getters: ");
        for(Method method : aClass.getDeclaredMethods()){
            if (method.getName().startsWith("get")) {
                System.out.print(method.getName() + " ");
            }
        }
        System.out.println();

        System.out.print("Setters: ");
        for(Method method : aClass.getDeclaredMethods()){
            if (method.getName().startsWith("set")) {
                System.out.print(method.getName() + " ");
            }
        }
        System.out.println();

        System.out.print("De andere methoden: ");
        for(Method method : aClass.getDeclaredMethods()){
            if (!method.getName().startsWith("set") && !method.getName().startsWith("get")) {
                System.out.print(method.getName() + " ");
            }
        }
        System.out.println();
    }

    public static Object runAnnotated (Class aClass){
        Object object = null;
        try {
            object = aClass.newInstance();
            for(Method method : aClass.getMethods()){
                CanRun canRun = method.getAnnotation(CanRun.class);
                if(canRun != null){
                    method.invoke(object,"dummy");
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;

    }


}
