package main.maman_11;

import java.util.Scanner;

/**
 * This class will get 4 int numbers from the user
 * The numbers represent left-upper point and right-bottom point of a rectangle
 *
 * The class will print the radius, perimeter and area of the in-circle and ex-circle of the rectangle
 *
 * @author  Daniel Madar
 * @version 1.0
 * @since   2/16/2019
 */

public class Circle {

    static private final double PI = 3.141592653589793;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nThis program calculates the areas and the perimeters of the ex-circle and the in-circle of a given rectangle.\n");
        System.out.print("Please enter the two coordinates of the left-upper point of the rectangle: ");

        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();

        System.out.print("Please enter the two coordinates of the right-bottom point of the rectangle: ");

        int rightDownX = scan.nextInt();
        int rightDownY = scan.nextInt();

        //calc
        int rectangleHeight = (leftUpY - rightDownY);
        double inCircleRadius = rectangleHeight / 2.0;
        double inCircleArea = PI * Math.pow(inCircleRadius, 2);
        double inCirclePerimeter = 2.0 * PI * inCircleRadius;

        // Rectangle diagonal distance from left upper point to right lower point
        double rectangleDiagonal = Math.sqrt(Math.pow(leftUpX-rightDownX, 2) + Math.pow(leftUpY-rightDownY, 2));
        double exCircleRadius = rectangleDiagonal / 2.0;
        double exCircleArea = PI * Math.pow(exCircleRadius, 2);
        double exCirclePerimeter = 2.0 * PI * exCircleRadius;

        // Output
        System.out.println("Incircle: radius = " + inCircleRadius + ", area = " + inCircleArea + ", perimeter = " + inCirclePerimeter);
        System.out.println("Excircle: radius = " + exCircleRadius + ", area = " + exCircleArea + ", perimeter = " + exCirclePerimeter);
    }
}
