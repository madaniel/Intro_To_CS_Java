package main.maman_11;

import java.util.Scanner;

public class Equations {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("This program solves a system of 2 linear equations");
        System.out.println("Enter the coefficients a11 a12 a21 a22 b1 b2");

        // User input
        int a11 = scan.nextInt();
        int a12 = scan.nextInt();
        int a21 = scan.nextInt();
        int a22 = scan.nextInt();
        int b1 = scan.nextInt();
        int b2 = scan.nextInt();

        // Calc
        String solution = "";

        //Output
        System.out.println("Eq1: " + a11 + "*x1+" + a12 + "*x2=" + b1);
        System.out.println("Eq2: " + a21 + "*x1+" + a22 + "*x2=" + b2);
        System.out.println(solution);
    }
}
