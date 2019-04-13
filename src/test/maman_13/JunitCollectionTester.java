package test.maman_13;
import main.maman_12.Box3D;
import main.maman_12.Point3D;
import main.maman_13.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            Box3D b1 = new Box3D(base, 1, 1, i);
            assertTrue(testCollection1.addBox(b1));
        }

        Box3D b1 = new Box3D(base, 1, 1, 1);
        assertFalse(testCollection1.addBox(b1));

        for(int i=MAX_NUM_BOXES; i > 0 ; i--){
            Box3D b2 = new Box3D(base, 1, 1, i);
            assertTrue(testCollection2.addBox(b2));
        }

        assertEquals(testCollection1.toString(), testCollection2.toString());

    }

    @Test
    void testMostUpperBaseCorner() {
        Box3D b1 = new Box3D();
        base = new Point3D();

        for(int i=1; i <= 10; i++){
            base = new Point3D(0, 0, i);
            b1 = new Box3D(base, 1, 1, 1);
            assertTrue(testCollection1.addBox(b1));
        }
        assertEquals(b1.toString(), testCollection1.mostUpperBaseCorner().toString());

        base = new Point3D(0.0, 0.0, 100);
        Box3D b2 = new Box3D(base, 1, 1, 1);
        testCollection1.addBox(b2);
        assertEquals(b2.toString(), testCollection1.mostUpperBaseCorner().toString());
    }

    @Test
    void testTotalSurfaceArea(){

    }

    @Test
    void testLongestDistance(){

    }

    @Test
    void testHowManyContains(){
    }

    @Test
    void testVolumeOfSmallerBox(){
    }





}
