package test.maman_13;
import main.maman_12.Box3D;
import main.maman_12.Point3D;
import main.maman_13.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLSyntaxErrorException;

import static org.junit.jupiter.api.Assertions.*;

class JunitCollectionTester {

    static private final int MAX_NUM_BOXES = 100;
    private Collection testCollection1;
    private Collection testCollection2;
    private Point3D base;

    @BeforeEach
    void setUp() {
        testCollection1 = new Collection();
        testCollection2 = new Collection();
        base = new Point3D(0.0, 0.0, 0.0);
        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    void testAddBox() {
        for(int i=1; i <= MAX_NUM_BOXES; i++){

            assertTrue(testCollection1.addBox(base, 1, 1, i));
        }

        assertFalse(testCollection1.addBox(base, 1, 1, 1));

        for(int i=MAX_NUM_BOXES; i > 0 ; i--){

            assertTrue(testCollection2.addBox(base, 1, 1, i));
        }

        assertEquals(testCollection1.toString(), testCollection2.toString());

    }

    @Test
    void testMostUpperBaseCorner() {
        Box3D b1 = new Box3D(new Point3D(0, 0, 10), 1, 1, 1);
        base = new Point3D();

        for(int i=1; i <= 10; i++)
            assertTrue(testCollection1.addBox(new Point3D(0, 0, i),1, 1, 1));

        base = new Point3D(0.0, 0.0, 100);
        Box3D b2 = new Box3D(base, 1, 1, 1);
        assertEquals(b1.toString(), testCollection1.mostUpperBaseCorner().toString());

        testCollection1.addBox(new Point3D(0.0, 0.0, 100), 1, 1, 1);
        assertEquals(b2.toString(), testCollection1.mostUpperBaseCorner().toString());
    }

    @Test
    void testTotalSurfaceArea(){
        for(int i=0; i < 3; i++){
            testCollection1.addBox(new Point3D(), 1, 1, 1);
        }
        assertEquals(6*3, testCollection1.totalSurfaceArea());

        for(int i=0; i < 3; i++){
            testCollection1.addBox(new Point3D(), 2, 2, 2);
        }
        assertEquals(6*3+6*2*2*3, testCollection1.totalSurfaceArea());
    }

    @Test
    void testLongestDistance(){
        assertEquals(0,testCollection1.longestDistance());

        for(int i=0; i < 5; i++)
            testCollection1.addBox(new Point3D(i, i, i), 2, 2, 2);

        assertEquals(testCollection1.getBoxes()[0].distance(testCollection1.getBoxes()[4]),testCollection1.longestDistance());
    }

    @Test
    void testHowManyContains(){
    }

    @Test
    void testVolumeOfSmallerBox(){

        base = new Point3D(0, 0, 0);

        Box3D f = new Box3D (base, 5, 4, 4);

        testCollection1.addBox(base, 1, 2, 3);
        testCollection1.addBox(base, 3, 2, 1);
        testCollection1.addBox(base, 3, 3, 3);
        testCollection1.addBox(base, 4, 3, 3);
        testCollection1.addBox(base, 1, 1, 1);

        int expectedVolume = f.getVolume();
        assertEquals(0, testCollection1.volumeOfSmallestBox(0, 5));
        assertEquals(0, testCollection1.volumeOfSmallestBox(0, 100));
        assertEquals(0, testCollection1.volumeOfSmallestBox(0, 5));
        assertEquals(0, testCollection1.volumeOfSmallestBox(-1, 4));

        assertEquals(expectedVolume, testCollection1.volumeOfSmallestBox(0, 4));
    }

    @Test
    void testGetBoxes(){
        for(int i=0; i < 1; i++)
            testCollection1.addBox(new Point3D(), 0, 0, 0);

        testCollection1.getBoxes();
    }
}
