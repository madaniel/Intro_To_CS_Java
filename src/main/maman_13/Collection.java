package main.maman_13;
import main.maman_12.Box3D;

/**
 * This class represents a collection of 3D boxes
 *
 *  @author  Daniel Madar
 *  @version 1.0
 *  @since   4/12/2019
 */

public class Collection {

    static private final int MAX_NUM_BOXES = 10;

    private Box3D [] _boxes;
    private int _numberOfBoxes;

    public Collection() {
        this._boxes = new Box3D[MAX_NUM_BOXES];
        this._numberOfBoxes = 0;
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
            result += "\n";
        }

        return result;
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
