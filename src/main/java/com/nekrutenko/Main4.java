package com.nekrutenko;

public class Main4 {
    public static void main(String[] args) {
        //Ex.1
        String hello = "Hello world!";
        char firstIndex = hello.charAt(hello.indexOf("H"));
        char lastIndex = hello.charAt(hello.length() - 1);
        System.out.println("The first character is: " + firstIndex);
        System.out.println("The last character is: " + lastIndex);

        //Ex.2
        String text = "Java Exercises";
        if (text.endsWith("se")) {
            System.out.println(text + " : ends on \"se\"");
        } else {
            System.out.println(text + " : not ends on \"se\"");
        }

        //Ex.3

        String  stephen = "Stephen Edwin King";
        String walter =  "Walter Winchell";
        String subStephen = stephen.substring(8,13);
        boolean contain = (stephen.contains(subStephen)) || (stephen.contains(walter)) ? true : false;
        System.out.println(contain);

        //Ex.4
        String lowerCase = "stephen edwin king";
        if (stephen.equalsIgnoreCase(walter)) {
            System.out.println(stephen + " = " + walter);
        } else if (stephen.equalsIgnoreCase(lowerCase)) {
            System.out.println(stephen + " = " + lowerCase);
        } else if ((walter.equalsIgnoreCase(lowerCase))){
            System.out.println(walter + " = " + lowerCase);
        }

        //Ex.5
        String line = "Red is favorite color";
        String line2 = "Orange is also my favorite color";
        String checkStart = "Red";
        String result = (line.startsWith(checkStart)) || (line2.startsWith(checkStart)) ? "True" : "False";
        System.out.println(result);

    }
}
