package main.maman_12;
import main.maman_12.Point3D;

/**
 * This class represents a 3D box
 * The box will be created based on a 3D point and size of length, width and height
 *
 * @author  Daniel Madar
 * @version 1.0
 * @since   15/3/2019
 */


public class Box3D {

    private Point3D _base;  // Represents the frontal, left, lowest point
    private int _length;  // axis X
    private int _width;  // axis Y
    private int _height;  // axis Z

    // Empty constructor
    public Box3D(){
        this._base = new Point3D(0.0, 0.0, 0.0);
        this._length = 1;
        this._width = 1;
        this._height = 1;
    }

    public Box3D(Point3D base, int length, int width, int height){
        this._base = new Point3D(base);
        this._length = (length <= 0) ? 1 : length;
        this._width = (width <= 0) ? 1 : width;
        this._height = (height <= 0) ? 1 : height;
    }

    // Copy constructor
    public Box3D(Box3D sourceBox){
        this._base = new Point3D(sourceBox._base);
        this._length = sourceBox._length;
        this._width = sourceBox._width;
        this._height = sourceBox._height;
    }

    public int getLength(){
        return this._length;
    }

    public int getWidth(){
        return this._width;
    }

    public int getHeight(){
        return this._height;
    }

    public Point3D getBase(){
        return new Point3D(this._base);
    }

    public void setLength(int length){
        this._length = (length <= 0) ? 1 : length;
    }

    public void setWidth(int width){
        this._width = (width <= 0) ? 1 : width;
    }

    public void setHeight(int height){
        this._height = (height <= 0) ? 1 : height;
    }

    public void setBase(Point3D base){
        this._base = new Point3D(base);
    }

    public String toString(){
        return "The base point is " + this._base + ", length = " + this._length + ", width = " + this._width + ", height = " + this._height;
    }

    public boolean equals (Box3D other){
        boolean isSameBase = other._base.equals(this._base);
        boolean isSameLength = other._length == this._length;
        boolean isSameWidth = other._width == this._width;
        boolean isSameHeight = other._height == this._height;

        return isSameBase && isSameLength && isSameWidth && isSameHeight;
    }

    public Box3D move(double dx, double dy, double dz){
        //Using copy Contractor of Box3D
        Box3D movedBox = new Box3D(this);
        movedBox._base.move(dx, dy, dz);

        return movedBox;
    }

    public Point3D getUpRightBackPoint(){
        // Starting from base point: frontal, left, lowest point
        Point3D upRightBackPoint = new Point3D(this._base);

        // moving to back, right, lowest point by moving to the length (axis X)
        // moving to frontal, right, lowest point by moving to the width (axis Y)
        // moving to back, right, up point by moving to the height (axis Z)
        upRightBackPoint.move(-this._length, this._width, this._height);

        return upRightBackPoint;
    }

    public Point3D getCenter(){
        // Starting from base point: frontal, left, lowest point
        Point3D centerPoint = new Point3D(this._base);

        // moving to the center of length (axis X)
        // moving to the center of width (axis Y)
        // moving to the center of height (axis Z)
        centerPoint.move(-this._length / 2.0, this._width / 2.0, this._height / 2.0);

        return centerPoint;
    }

    public double distance(Box3D other){
        Point3D centerOfThis = this.getCenter();
        Point3D centerOfOther = other.getCenter();

        return centerOfThis.distance(centerOfOther);
    }

    public int getVolume(){
        return this._length * this._width * this._height;
    }

    public int getSurfaceArea(){
        int frontSurface = this._width * this._height;
        int sideSurface = this._length * this._height;
        int upSurface = this._width * this._length;

        // Surface Area calc
        return frontSurface * 2 + sideSurface * 2 + upSurface * 2;
    }

    public boolean isLargerCapacity(Box3D other){
        return this.getSurfaceArea() > other.getSurfaceArea();
    }

    public boolean contains(Box3D other){
        boolean isThisSmallerLength = this._length > other._length;
        boolean isThisSmallerWidth = this._width > other._width;
        boolean isThisSmallerHeight = this._height > other._height;

        return isThisSmallerLength && isThisSmallerWidth && isThisSmallerHeight;
    }

    public boolean isAbove(Box3D other){
        return this._base.isAbove(other.getUpRightBackPoint());
    }
}
