package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner info = new Scanner(new File("imports.txt"));

        String lines = new String[5000];
        String firstName = new String[50];
        String lastName = new String[50];
        int grades = new int[50];
        int avgAbs = new int[50];

        int maxIndx = -1;
        info.useDelimiter("\\t");

        while(info.hasNext())
        {
            maxIndx++;
            lines[maxIndx] = info.next();
        }

        for(String a: lines)
        {
            System.out.println(a);
        }

    }
}
