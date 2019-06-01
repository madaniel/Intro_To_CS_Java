package test.maman_14;
import main.maman_14.Ex14;

public class Ex14StudentTester
{
    public static void main(String[] args){
        System.out.println ("********** Question 1 **********\n");

        int[] array1 = {2,1,1,4,1,1,2,3};
        System.out.println("Checking method waterVolume on array [2,1,1,4,1,1,2,3]\n");
        int studentResult;

        studentResult= Ex14.waterVolume(array1);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        System.out.println ("********** Question 2 **********\n");
        int[] array2 = {1,1,1,1,1,1,1};

        System.out.println("Checking method what on array [1,1,1,1,1,1,1]\n");

        studentResult= Ex14.what(array2);
        System.out.println();
        System.out.println("Result is: "+studentResult);
        System.out.println();
        System.out.println ("********** Question 3 **********\n");

        System.out.println("Checking method solutions with number 4\n");

        studentResult= Ex14.solutions(4);
        System.out.println();
        System.out.println("Result is: "+studentResult);
        System.out.println();
        System.out.println("********** Question 4**********\n");

        int[][] mat1 = {
                {1,1,1,1},
                {100,100,100,1},
                {100,100,100,1},
                {1,1,1,1}
            };

        int[][] path1 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
            };

        System.out.println ("Checking method findSum with number 600 and matrix:\n");
        printMat (mat1);

        boolean studentResultBool=Ex14.findSum(mat1,600,path1);
        System.out.println();
        System.out.println("Result is: "+studentResultBool);
        System.out.println();
        System.out.println("Path matrix is:");
        printMat (path1);

    }

    public static void printMat(int [][]mat){
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }
    }
}

