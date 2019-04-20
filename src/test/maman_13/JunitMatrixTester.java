package test.maman_13;

import main.maman_13.Matrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunitMatrixTester {

    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix matrix3;
    private Matrix matrix4;

    @BeforeEach
    void setUp() {
        int[][] matArray2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] matArray3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matArray4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        matrix1 = new Matrix(3, 3);
        matrix2 = new Matrix(matArray2);
        matrix3 = new Matrix(matArray3);
        matrix4 = new Matrix(matArray4);

        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    void testMatrixToString(){
        String expected1 =
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n";
        String expected2 =
                "1" + "\t" + "2" + "\t" + "3" + "\n" +
                "1" + "\t" + "2" + "\t" + "3" + "\n" +
                "1" + "\t" + "2" + "\t" + "3" + "\n";
        String expected3 =
                "1" + "\t" + "2" + "\t" + "3" + "\n" +
                "4" + "\t" + "5" + "\t" + "6" + "\n" +
                "7" + "\t" + "8" + "\t" + "9" + "\n";
        String expected4 =
                "1" + "\t" + "2" + "\t" + "3" + "\t" + "4" + "\n" +
                "5" + "\t" + "6" + "\t" + "7" + "\t" + "8" + "\n" +
                "9" + "\t" + "10"+ "\t" + "11"+ "\t" + "12"+ "\n";
        assertEquals(expected1, matrix1.toString());
        assertEquals(expected2, matrix2.toString());
        assertEquals(expected3, matrix3.toString());
        assertEquals(expected4, matrix4.toString());
    }

    @Test
    void testMakeNegative(){
        String expected1 =
                "255" + "\t" + "255" + "\t" + "255" + "\n" +
                "255" + "\t" + "255" + "\t" + "255" + "\n" +
                "255" + "\t" + "255" + "\t" + "255" + "\n";
        String expected2 =
                "254" + "\t" + "253" + "\t" + "252" + "\n" +
                "254" + "\t" + "253" + "\t" + "252" + "\n" +
                "254" + "\t" + "253" + "\t" + "252" + "\n";

        Matrix matrixNegative1 = new Matrix(matrix1.makeNegative());
        Matrix matrixNegative2 = new Matrix(matrix2.makeNegative());

        assertEquals(expected1, matrixNegative1.toString());
        assertEquals(expected2, matrixNegative2.toString());
    }

    @Test
    void testRotateCounterClockwise(){
        String expected1 =
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n";
        String expected2 =
                "3" + "\t" + "3" + "\t" + "3" + "\n" +
                "2" + "\t" + "2" + "\t" + "2" + "\n" +
                "1" + "\t" + "1" + "\t" + "1" + "\n";
        String expected3 =
                "3" + "\t" + "6" + "\t" + "9" + "\n" +
                "2" + "\t" + "5" + "\t" + "8" + "\n" +
                "1" + "\t" + "4" + "\t" + "7" + "\n";
        String expected4 =
                "4" + "\t" + "8" + "\t" + "12" + "\n" +
                "3" + "\t" + "7" + "\t" + "11" + "\n" +
                "2" + "\t" + "6" + "\t" + "10" + "\n" +
                "1" + "\t" + "5" + "\t" + "9" + "\n";

        Matrix matrixRotateCounterClockwise1 = new Matrix(matrix1.rotateCounterClockwise());
        Matrix matrixRotateCounterClockwise2 = new Matrix(matrix2.rotateCounterClockwise());
        Matrix matrixRotateCounterClockwise3 = new Matrix(matrix3.rotateCounterClockwise());
        Matrix matrixRotateCounterClockwise4 = new Matrix(matrix4.rotateCounterClockwise());

        assertEquals(expected1, matrixRotateCounterClockwise1.toString());
        assertEquals(expected2, matrixRotateCounterClockwise2.toString());
        assertEquals(expected3, matrixRotateCounterClockwise3.toString());
        assertEquals(expected4, matrixRotateCounterClockwise4.toString());
    }

    @Test
    void testRotateClockwise(){
        String expected1 =
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n" +
                "0" + "\t" + "0" + "\t" + "0" + "\n";
        String expected2 =
                "1" + "\t" + "1" + "\t" + "1" + "\n" +
                "2" + "\t" + "2" + "\t" + "2" + "\n" +
                "3" + "\t" + "3" + "\t" + "3" + "\n";
        String expected3 =
                "7" + "\t" + "4" + "\t" + "1" + "\n" +
                "8" + "\t" + "5" + "\t" + "2" + "\n" +
                "9" + "\t" + "6" + "\t" + "3" + "\n";
        String expected4 =
                "9"  + "\t" + "5" + "\t" + "1" + "\n" +
                "10" + "\t" + "6" + "\t" + "2" + "\n" +
                "11" + "\t" + "7" + "\t" + "3" + "\n" +
                "12" + "\t" + "8" + "\t" + "4" + "\n";

        Matrix matrixRotateClockwise1 = new Matrix(matrix1.rotateClockwise());
        Matrix matrixRotateClockwise2 = new Matrix(matrix2.rotateClockwise());
        Matrix matrixRotateClockwise3 = new Matrix(matrix3.rotateClockwise());
        Matrix matrixRotateClockwise4 = new Matrix(matrix4.rotateClockwise());

        assertEquals(expected1, matrixRotateClockwise1.toString());
        assertEquals(expected2, matrixRotateClockwise2.toString());
        assertEquals(expected3, matrixRotateClockwise3.toString());
        assertEquals(expected4, matrixRotateClockwise4.toString());
    }
}


