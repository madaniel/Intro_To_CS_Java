package main.maman_13;
import main.maman_12.Box3D;
import main.maman_12.Point3D;

/**
 * This class represents a collection of 3D boxes
 *
 *  @author  Daniel Madar
 *  @version 1.0
 *  @since   4/12/2019
 */

public class Collection {

    static private final int MAX_NUM_BOXES = 100;

    private Box3D [] _boxes;
    private int _numberOfBoxes;

    public Collection() {
        this._boxes = new Box3D[MAX_NUM_BOXES];
        this._numberOfBoxes = 0;
    }

    public int totalSurfaceArea(){
        int total = 0;

        for(int i=0; i < this._numberOfBoxes; i++)
            total += this._boxes[i].getSurfaceArea();

        return total;
    }

    public double longestDistance(){
        if(this._numberOfBoxes < 2)
                return 0;

        return _getMinCenterPoint(this._boxes).distance(_getMaxCenterPoint(this._boxes));
    }

    public int howManyContains(){
        return 0;
    }

    public int volumeOfSmallerBox(){
        return 0;
    }

    public Box3D [] getBoxes(){
        Box3D [] boxCopy = new Box3D[this._numberOfBoxes];

        for(int i=0; i < boxCopy.length; i++)
            boxCopy[i] = new Box3D(this._boxes[i]);

        return boxCopy;
    }

    public int getNumOfBoxes(){
        return this._numberOfBoxes;
    }

    public Box3D mostUpperBaseCorner() {
    /*
    Returns the box with the higher base point
    */
    // Setting the first box as the upper base
    int maxBaseIndex = 0;
    Point3D maxBasePoint = this._boxes[0].getBase();

    // Comparing the first box with the others
    for (int i=1; i < this._numberOfBoxes ; i++){

        if (this._boxes[i].getBase().isAbove(maxBasePoint)){
            maxBaseIndex = i;
            maxBasePoint = this._boxes[i].getBase();
            }
        }

    return this._boxes[maxBaseIndex];
    }

    public boolean addBox(Box3D box){
        /*
          This method will push box into the Collection, based on its dimensions.
          The insertion will keep the collection sorted - small to large box
         */

        // The collection is full
        if (this._numberOfBoxes == MAX_NUM_BOXES)
            return false;

        int indexToAdd = _findIndexToAdd(box);

        assert indexToAdd > -1: "Index to insert Box was not found !";

        _insertBoxByIndex(box, indexToAdd);

        this._numberOfBoxes += 1;

        return true;
    }

    public String toString(){
        String result = "";

        for (int i=0; i < this._numberOfBoxes; i++){
            result += this._boxes[i].toString();
            result += '\n';
        }

        return result;
    }

    private Point3D _getMinCenterPoint(Box3D [] boxesArray){
        /*
        Return the minimum sum of center point in array
        */
        int minIndex = 0;

        for(int i=1; i < this._numberOfBoxes; i++)
            if (_sumOfPoint(boxesArray[i].getCenter()) < _sumOfPoint(boxesArray[minIndex].getCenter()))
                minIndex = i;

        return boxesArray[minIndex].getCenter();
    }

    private Point3D _getMaxCenterPoint(Box3D [] boxesArray){
        /*
        Return the maximum sum of point in array
        */
        int maxIndex = 0;

        for(int i=1; i < this._numberOfBoxes; i++)
            if (_sumOfPoint(boxesArray[i].getCenter()) > _sumOfPoint(boxesArray[maxIndex].getCenter()))
                maxIndex = i;

        return boxesArray[maxIndex].getCenter();
    }

    private double _sumOfPoint(Point3D point){
        return point.getX() + point.getY() + point.getZ();
    }

    private void _insertBoxByIndex(Box3D box, int index){
        // Cell is empty
        if (this._boxes[index] != null)
            _shiftArrayRight(index);

        this._boxes[index] = box;
    }

    private void _shiftArrayRight(int index){
        // Shift elements on array to the right, one step
        // overwriting the last element (assuming it's null)
        // freeing the element in the index place

        // example: [1, 3, 5, 7, null] index=0
        for (int i = this._boxes.length - 2; index <= i; i--)
            this._boxes[i+1] = this._boxes[i];

        // [1, 1, 3, 5, 7]

        // removing the element in the target index
        this._boxes[index] = null;

        // result: [null, 1, 3, 5, 7]
    }

    private int _findIndexToAdd(Box3D box){
        // looking for null element or equal / larger box in Collection
        for (int i=0; i < this._boxes.length; i++){
            if (_isCurrentCellEmpty(i))
                return i;

            // Skip boxes in Collection larger than target box
            if (box.isLargerCapacity(this._boxes[i]))
                continue;

            // Target box is smaller or equals to current
            return i;
        }
        //All boxes scanned but slot has not found
        return -1;
    }

    private boolean _isCurrentCellEmpty(int boxIndex){
        return this._boxes[boxIndex] == null;
    }

}
