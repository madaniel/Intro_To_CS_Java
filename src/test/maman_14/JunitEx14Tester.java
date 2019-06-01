package test.maman_14;
import main.maman_14.Ex14;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;


public class JunitEx14Tester {

    @BeforeEach
    void setUp() {
        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    void testWhat() {
        int [] test1 = {2, 4, 6};
        assertEquals(3, Ex14.what(test1));

        int [] test2 = {2, 4, 6, 1};
        assertEquals(3, Ex14.what(test2));

        int [] test3 = {-2, -4, 6, 8, 10, 1};
        assertEquals(5, Ex14.what(test3));

        int [] test5 = {1};
        assertEquals(0, Ex14.what(test5));

        int [] test6 = {};
        assertEquals(0, Ex14.what(test6));

        int [] test7 = {1, 5, 7, 9};
        assertEquals(4, Ex14.what(test7));

        int [] test75 = {3, 5, 7, 4, 6, 8};
        assertEquals(5, Ex14.what(test75));



        int [] test8 ={19, 73, 65, -69, 37, 98, 93, -89, 20, -31, 63, -14, -87, 49, 41, 19, 22, 64};
        assertEquals(17, Ex14.what(test8));
        int[] test9 = {4, 38, 21, 82, 35, 7, 51, -10, 26, 56, 49, -67, 44, 87, 84, 5, -51, 70};
        assertEquals(16, Ex14.what(test9));

    }

    @Test
    void testWhatNew(){
        int [] test1 = {2, 4, 6};
        assertEquals(3, Ex14.what(test1));
        int [] test2 = {2, 4, 6, 1};
        assertEquals(3, Ex14.what(test2));
        int [] test3 = {-2, -4, 6, 8, 10, 1};
        assertEquals(5, Ex14.what(test3));
        int[] test4 = {4, 38, 21, 82, 35, 7, 51, -10, 26, 56, 49, -67, 44, 87, 84, 5, -51, 70};
        assertEquals(16, Ex14.what(test4));
        int [] test5 = {1};
        assertEquals(0, Ex14.what(test5));
        int [] test6 = {};
        assertEquals(0, Ex14.what(test6));
        int [] test7 = {1, 5, 7, 9};
        assertEquals(4, Ex14.what(test7));
    }

    @Test
    void testWaterVolume(){
        int [] test1 = {2, 1, 1, 4, 1, 1, 2, 3};
        int [] test2 = {2, 1, 0, 2, 0, 0, 1, 3};
        assertEquals(7, Ex14.waterVolume(test1));
        assertEquals(8, Ex14.waterVolume(test2));
    }

    @Test
    void testSolution(){
        assertEquals(1, Ex14.solutions(3));
        assertEquals(0, Ex14.solutions(1));
        assertEquals(6, Ex14.solutions(5));
    }

    @Test
    void testFindSum(){
        int [][] test1 = {{3, 6, 7}, {20, 20, 20}, {10, 2, 3}};
        int [][] path1 = {{0, 0, 0}, {0, 0, 0}, {0, 1, 1}};
        int [][] test2 = {{3, 6, 7}, {20, 20, 20}, {10, 6, 6}};
        int [][] path2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int [][] test3 = {{3, 6, 7}, {4, 20, 20}, {1, 6, 6}};
        int [][] path3 = {{0, 0, 0}, {1, 0, 0}, {1, 0, 0}};
        int [][] test4 = {{1, 1, 1}, {6, 6, 1}, {10, 6, 1}};
        int [][] path4 = {{1, 1, 1}, {0, 0, 1}, {0, 0, 1}};
        int [][] test5 = {{1, 1, 0}, {10, 1, 10}, {10, 1, 1}};
        int [][] path5 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};

        int [][] path = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Ex14.findSum(test1, 5, path));
        assertTrue(Arrays.deepEquals(path, path1));

        int [][] path22 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertFalse(Ex14.findSum(test2, 5, path22));
        assertTrue(Arrays.deepEquals(path22, path2));

        int [][] path33 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Ex14.findSum(test3, 5, path33));
        assertTrue(Arrays.deepEquals(path33, path3));

        int [][] path44 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Ex14.findSum(test4, 5, path44));
        assertTrue(Arrays.deepEquals(path44, path4));

        int [][] path55 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Ex14.findSum(test5, 5, path55));
        assertTrue(Arrays.deepEquals(path55, path5));
    }
}




