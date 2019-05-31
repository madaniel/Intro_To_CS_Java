package test.maman_14;
import main.maman_14.Ex14;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void testWhatNew(){
        int [] test1 = {2, 4, 6};
        assertEquals(3, Ex14.whatNew(test1));
        int [] test2 = {2, 4, 6, 1};
        assertEquals(3, Ex14.whatNew(test2));
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
}




