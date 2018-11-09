package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner info = new Scanner(new File("myInf.txt"));

        String lines[] = new String[200];
        String firstName[] = new String[50];
        String lastName[] = new String[50];
        int grades[] = new int[50];
        int abs[] = new int[50];

        int maxIndx = -1;
        info.nextLine();

        while(info.hasNext())
        {
            maxIndx++;
            lines[maxIndx] = info.useDelimiter("\\t").nextLine() + "\t";

        }

        Scanner storeInfo;

        for(int a = 0; a < maxIndx; a++)
        {
            storeInfo = new Scanner(lines[a]);
            storeInfo.useDelimiter("\\t");
            firstName[a] = storeInfo.next();
            lastName[a] = storeInfo.next();
            grades[a] = Integer.parseInt(storeInfo.next());
            abs[a] = Integer.parseInt(storeInfo.next());
        }

        //FINDING AVERAGE
        int befDiv = 0;

        for(int i = 0; i < grades.length; i++) {

            befDiv = befDiv + grades[i];

        }

        double avgGrade = befDiv / grades.length;


        //PRINTING DIFF GRADES
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        for(int a = 0; a < grades.length; a++){

            if(grades[a] > 90) {
                gradeA = gradeA + 1;
            } else if(grades[a] >= 80){
                gradeB = gradeB + 1;
            } else if(grades[a] >= 70) {
                gradeC = gradeC + 1;
            } else if(grades[a] >= 60) {
                gradeD = gradeD + 1;
            } else {
                gradeF = gradeF + 1;
            }

        }

        //THE PRINTOUTS
        System.out.println("Average of class: " + avgGrade);
        System.out.println("A Grades: " + gradeA + "\n B Grades: " + gradeB + "\n C Grades: " + gradeC + "\n D Grades: " + gradeD + "\n F Grades: " + gradeF);


        //SEARCH FEATURE
        System.out.println("Welcome to the Student Search Feature!");
        //can't be zero bc there is a 0 spot in the arrays so it has to be -1 here
        int studSpot = -1;

        System.out.println("Please enter the student's first name: \n");
        Scanner searchFirst = new Scanner(System.in);
        String theirFirst = searchFirst.next();

        System.out.println("Please enter the student's last name: \n");
        Scanner searchLast = new Scanner(System.in);
        String theirLast = searchLast.next();

        for(int a = 0; a <firstName.length; a++) {

            if((theirFirst.equalsIgnoreCase(firstName[a])) && (theirLast.equalsIgnoreCase(lastName[a]))) {

                studSpot = a;

            }

        }

        if(studSpot == -1) {

            System.out.println("Sorry! I couldn't find that student in my database, make sure you don't have any typos then try again please!");

        } else {

            String studName = firstName[studSpot] + lastName[studSpot];
            System.out.println(studName + ": ");
            System.out.println(studName + "'s Average: " + grades[studSpot]);
            //I've already scrubbed data so grades are in order so this works
            System.out.println(studName + "'s Class Rank: " + studSpot);

            if((abs[studSpot] >= 5) && (grades[studSpot] <= 81)) {
                System.out.println("Warning! This student's absences(" + abs[studSpot] + ") is affecting their grade!");
            }
        }
    }
}

