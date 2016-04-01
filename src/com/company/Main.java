package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        File fin = new File("text.txt");

        Pattern adverb = Pattern.compile(".*о$");
        Pattern verb = Pattern.compile(".*ть?с?я?$");
        Pattern adjective = Pattern.compile(".*[аоеиыя][еймя]с?я?$");

        //int advNum=0, verbNum=0, adjNum=0;
        System.out.println("Hello, world");

        Matcher matcher;
	    try
        {
            FileReader reader = new FileReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String s;
            StringTokenizer st;
            String temp;
            while((s = buffReader.readLine()) != null){
                st = new StringTokenizer(s, " \t\n\r,:-.,!?");
                while (st.hasMoreTokens())
                {
                    temp = st.nextToken();
                    matcher = adverb.matcher(temp);
                    while (matcher.find())
                    {
                        System.out.println(matcher.group() + " - наречие");
                    }
                    matcher = adjective.matcher(temp);
                    while (matcher.find())
                    {
                        System.out.println(matcher.group() + " - прилагательное");
                    }
                    matcher = verb.matcher(temp);
                    while (matcher.find())
                    {
                        System.out.println(matcher.group() + " - глагол");
                    }
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
