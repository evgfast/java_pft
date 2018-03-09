package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
//        String[] langs = new String[4];
//        langs[0] = "Java";
//        langs[1] = "C#";
//        langs[2] = "Python";
//        langs[3] = "PHP";
//
//        for(int i = 0; i < langs.length; i++){
//            System.out.println("I want to learn " + langs[i]);
//        }
//
//        for(String lang : langs){
//            System.out.println("I want to learn : " + lang);
//        }

//        List<String> languages = new ArrayList<String>();
//        languages.add("Java");
//        languages.add("C#");
//        languages.add("PYTHON");
//        languages.add("PHP");
        List<String> languages = Arrays.asList("Java", "C++", "Python", "C#", "PHP");
        for(String s : languages){
            System.out.println("learn :" + s);
        }
        System.out.println();

        for(int i = 0; i< languages.size(); i++){
            System.out.println("i want to learn: " + languages.get(i));
        }

    }

}
