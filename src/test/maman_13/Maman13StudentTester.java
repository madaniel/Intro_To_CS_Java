package test.maman_13;
import main.maman_12.Box3D;
import main.maman_12.Point3D;
import main.maman_13.Collection;

/**
 * class Maman13StudentTester here.
 * 
 * @author
 * @version
 */
public class Maman13StudentTester {
	public static void main(String[] args) {
		System.out.println("check the following results and make sure tha it ia OK");
		// create points
		Point3D p0 = new Point3D();
		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 2, 2);
		System.out.println("create 3 points \n"
				+ "p0 = " + p0 + 
				"\np1 = " + p1 +
				"\np2 = " + p2);
		// Collection	
		Collection c1 = new Collection();
		c1.addBox(p0, 3, 3, 3);
		c1.addBox(p0, 2, 2, 2);
		c1.addBox(p1, 2, 2, 2);
		c1.addBox(p2, 1, 1, 1);
		System.out.println("adding the following boxes (p0,3,3,3) (p0,2,2,2) (p1,2,2,2) (p2,1,1,)");
		System.out.println("toString :\n" + c1);
		int numOfBoxes = c1.getNumOfBoxes();
		System.out.println("numOfBoxes = " + numOfBoxes);
		double longestDistance = c1.longestDistance();
		System.out.println("longestDistance = " + longestDistance);
		double totalSurfaceArea = c1.totalSurfaceArea();
		System.out.println("totalSurfaceArea = " + totalSurfaceArea);
		Box3D b1 = new Box3D(p1, 20, 20, 20);
		int howManyContains = c1.howManyContains(b1);
		System.out.println("create box b1 = " + b1);
		System.out.println("c1.howManyContains(b1) = " + howManyContains);
		Box3D mostUpperBaseCorner = c1.mostUpperBaseCorner();
		System.out.println("mostUpperBaseCorner = " + mostUpperBaseCorner);
		Box3D[] boxArray = c1.getBoxes();
		int volumeOfSmallestBox = c1.volumeOfSmallestBox(1, 2);
		System.out.println("volumeOfSmallestBox = " + volumeOfSmallestBox);

//
//
//		// MATRIX
//		System.out.println("\nTest Matrix:\n");
//		System.out.println("for Matrix m2 = new Matrix(3, 3); the toString of m2 is:");
//		Matrix m2 = new Matrix(3, 3);
//		System.out.println(m2);
//
//		System.out.println("\nfor a = { { 10, 30, 50 }, { 100, 150, 200 } };");
//		int[][] a = { { 10, 30, 50 }, { 100, 150, 200 } };
//		Matrix m1 = new Matrix(a);
//		System.out.println("\nfor Matrix m1 = new Matrix(a); the toString of m1 is:");
//		System.out.println(m1);
//		Matrix temp;
//
//		temp = m1.makeNegative();
//		System.out.println("resuls of m1.makeNegative(); \n" + temp);
//
//		temp = m1.imageFilterAverage();
//		System.out.println("resuls of m1.imageFilterAverage(); \n" + temp);
//
//		temp = m1.rotateClockwise();
//		System.out.println("resuls of m1.rotateClockwise(); \n" + temp);
//
//		temp = m1.rotateCounterClockwise();
//		System.out.println("resuls of m1.rotateCounterClockwise(); \n" + temp);

	}// main
}// class