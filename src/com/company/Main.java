package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        File fin = new File("text.txt");
        Pattern adverb = Pattern.compile(".*о$");
        Matcher matcher;
	    try
        {
            FileReader reader = new FileReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String s;
            StringTokenizer st;
            while((s = buffReader.readLine()) != null){
                st = new StringTokenizer(s, " \t\n\r,:-.");
                while (st.hasMoreTokens())
                {
                    //System.out.println(st.nextToken());
                    matcher = adverb.matcher(st.nextToken());
                    while (matcher.find())
                    {
                        System.out.println(matcher.group());
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
