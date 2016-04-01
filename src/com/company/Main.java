package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
	    try (FileInputStream fin = new FileInputStream("text.txt"))
        {
            int i=-1;
            while (((i=fin.read())!=-1))
            {
                System.out.print((char)i);
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
