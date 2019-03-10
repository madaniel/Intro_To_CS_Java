package test.maman_12;
import main.maman_12.Point3D;


public class TesterPoint3D {
    public static void main(String[] args) {
        System.out.println("********************************************************************************************************************************");
        System.out.println("IMPORTANT: Please note that this is only a basic test class. You will need to write your own test to fully test class your code.");
        System.out.println("********************************************************************************************************************************\n");
        testPoint3D();
    }

    private static void testPoint3D() {
        System.out.println("Testing Point3D:");

        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D(4,5,6);
        Point3D p3 = new Point3D(p2);

        System.out.println("Calling getters and setters...");
        p1.setX(1);
        p1.setY(2);
        p1.setZ(3);
        double x = p1.getX();
        double y = p1.getY();
        double z = p1.getZ();
        if (x != 1) {
            System.out.println("\tEither getX or setX are not correct");
        }
        if (y != 2) {
            System.out.println("\tEither getY or setY are not correct");
        }
        if (z != 3) {
            System.out.println("\tEither getZ or setZ are not correct");
        }

        System.out.println("Calling toString...");

        if (!p1.toString().equals("(1.0,2.0,3.0)")) {
            System.out.println("\ttoString is not correct");
        }

        System.out.println("Calling equals...");

        if (!p2.equals(p3)) {
            System.out.println("\tequals is not correct");
        }
        if (p1.equals(p2)) {
            System.out.println("\tequals is not correct");
        }

        System.out.println("Calling isAbove...");

        if (p1.isAbove(p2)) {
            System.out.println("\tisAbove is not correct");
        }
        if (!p2.isAbove(p1)) {
            System.out.println("\tisAbove is not correct");
        }
        if (p2.isAbove(p3)) {
            System.out.println("\tisAbove is not correct");
        }

        System.out.println("Calling isUnder...");

        if (p2.isUnder(p1)) {
            System.out.println("\tisUnder is not correct");
        }
        if (!p1.isUnder(p2)) {
            System.out.println("\tisUnder is not correct");
        }
        if (p2.isUnder(p3)) {
            System.out.println("\tisUnder is not correct");
        }

        System.out.println("Calling isLeft...");

        if (p2.isLeft(p1)) {
            System.out.println("\tisLeft is not correct");
        }
        if (!p1.isLeft(p2)) {
            System.out.println("\tisLeft is not correct");
        }
        if (p2.isLeft(p3)) {
            System.out.println("\tisLeft is not correct");
        }

        System.out.println("Calling isRight...");

        if (p1.isRight(p2)) {
            System.out.println("\tisRight is not correct");
        }
        if (!p2.isRight(p1)) {
            System.out.println("\tisRight is not correct");
        }
        if (p2.isRight(p3)) {
            System.out.println("\tisRight is not correct");
        }

        System.out.println("Calling isBehind...");

        if (p2.isBehind(p1)) {
            System.out.println("\tisBehind is not correct");
        }
        if (!p1.isBehind(p2)) {
            System.out.println("\tisBehind is not correct");
        }
        if (p2.isBehind(p3)) {
            System.out.println("\tisBehind is not correct");
        }

        System.out.println("Calling isInFrontOf...");

        if (p1.isInFrontOf(p2)) {
            System.out.println("\tisInFrontOf is not correct");
        }
        if (!p2.isInFrontOf(p1)) {
            System.out.println("\tisInFrontOf is not correct");
        }
        if (p2.isInFrontOf(p3)) {
            System.out.println("\tisInFrontOf is not correct");
        }

        System.out.println("Calling move...");
        p1.move(1, 1, 1);

        if (p1.getX() != 2 || p1.getY() != 3 || p1.getZ() != 4) {
            System.out.println("\tmove is not correct");
        }

        System.out.println("Calling distance...");
        double distance1 = p1.distance(p2);
        double distance2 = p2.distance(p3);

        if (distance1 - 3.4641016151377544 > 0.001) {
            System.out.println("\tdistance is not correct");
        }
        if (distance2 != 0) {
            System.out.println("\tdistance is not correct");
        }
    }
}
