package main.maman_12;

/**
 * This class represents point in 3D dimensions
 *
 * @author  Daniel Madar
 * @version 1.0
 * @since   3/2/2019
 */

public class Point3D {

    private double _x;
    private double _y;
    private double _z;

    // Empty Constructor
    public Point3D(){
        this._x = 0.0;
        this._y = 0.0;
        this._z = 0.0;
    }

    // Constructor with arguments
    public Point3D(double x, double y, double z){
        this._x = x;
        this._y = y;
        this._z = z;
    }

    // Copy Constructor
    public Point3D(Point3D pointToCopy){

        if (pointToCopy != null) {
            this._x = pointToCopy._x;
            this._y = pointToCopy._y;
            this._z = pointToCopy._z;
        }
    }

    public double getX(){
        return this._x;
    }

    public double getY(){
        return this._y;
    }

    public double getZ(){
        return this._z;
    }

    public void setX(double num){
        this._x = num;
    }

    public void setY(double num){
        this._y = num;
    }

    public void setZ(double num){
        this._z = num;
    }

    public String toString(){
        return "(" + this._x + "," + this._y + "," + this._z + ")";
    }

    public boolean equals(Point3D other){
        return this._x == other._x && this._y == other._y && this._z == other._z;
    }

    public boolean isAbove(Point3D other){
        return this._z > other._z;
    }

    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    public boolean isLeft(Point3D other){
        return this._y < other._y;
    }

    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }

    public boolean isBehind(Point3D other){
        return this._x <  other._x;
    }

    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    public void move(double dx, double dy, double dz){
        this._x += dx;
        this._y += dy;
        this._z += dz;
    }

    public double distance(Point3D p){
        return Math.sqrt(squareDiff(this._x, p._x) + squareDiff(this._y, p._y) + squareDiff(this._z, p._z));
    }

    private double squareDiff(double number1, double number2){
        return Math.pow((number1 - number2), 2);
    }

}






