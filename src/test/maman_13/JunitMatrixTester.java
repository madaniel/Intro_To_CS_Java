package test.maman_13;

import main.maman_13.Matrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JunitMatrixTester {

    private Matrix matrix1;
    private Matrix matrix2;

    @BeforeEach
    void setUp() {
        matrix1 = new Matrix(3, 3);
        int[][] matArray = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        matrix2 = new Matrix(matArray);

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

        assertEquals(expected1, matrix1.toString());
        assertEquals(expected2, matrix2.toString());
    }
}


