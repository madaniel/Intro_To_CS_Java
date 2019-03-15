package main.maman_11;

import java.util.Scanner;

/**
 * This class will get 6 ints of coefficients of 2 linear equations
 * It will return the solution, if exists, or "No Solution" / "Many Solution" accordingly.
 * Based on Cramer's rule
 *
 * @author  Daniel Madar
 * @version 1.0
 * @since   2/16/2019
 */


public class Equations {

    static private final double ROUND_PRECISION = 1000.0;

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

        // In case the system has a single solution
        boolean singleSolution = (a11 * a22) - (a12 * a21) != 0;
        boolean infiniteCondition1 = (b2 * a11) - (b1 * a21) == 0;
        boolean infiniteCondition2 = (b1 * a22) - (b2 * a12) == 0;
        boolean infiniteCondition3 = b1 != 0 && a11 == 0 && a12 == 0 || b2 !=0 && a21 == 0 && a22 == 0;

        // Conditions for the system to has infinite solutions
        boolean infiniteSolution = ! singleSolution && infiniteCondition1 && infiniteCondition2 && ! infiniteCondition3;

        // If the other conditions will not apply, the remained true condition will be "no solution"
        String answer = "No Solution";
        double solutionX1;
        double solutionX2;

        if (singleSolution){
            // Following Cramer's rule
            solutionX1 = (double)(b1 * a22 - b2 * a12) / (double)(a11 * a22 - a12 * a21);
            solutionX2 = (double)(b2 * a11 - b1 * a21) / (double)(a11 * a22 - a12 * a21);
            // Round the values to the requested precision
            double roundedSolutionX1 = (double)Math.round(solutionX1 * ROUND_PRECISION) / ROUND_PRECISION;
            double roundedSolutionX2 = (double)Math.round(solutionX2 * ROUND_PRECISION) / ROUND_PRECISION;
            answer = "Single solution: (" + roundedSolutionX1 + "," + roundedSolutionX2 + ")";
        }

        else if (infiniteSolution)
            answer = "Many solutions";

        //Output
        System.out.println("Eq1: " + a11 + "*x1+" + a12 + "*x2=" + b1);
        System.out.println("Eq2: " + a21 + "*x1+" + a22 + "*x2=" + b2);
        System.out.println(answer);
    }
}
