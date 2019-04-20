package main.maman_13;

public class Matrix {

    private int [] [] _array;

    public Matrix(int [] [] array){
        this._array = new int[array.length][array[0].length];

        for(int row=0; row < array.length; row++)
            for(int col=0; col < array[row].length; col++)
                this._array[row][col] = array[row][col];
    }

    public Matrix(int size1, int size2){
        this._array = new int[size1][size2];

        for(int row=0; row < size1; row++)
            for(int col=0; col < size2; col++)
                this._array[row][col] = 0;
    }

    public String toString(){
        String result = "";

        for(int row=0; row < _array.length; row++) {
            for (int col = 0; col < _array[row].length; col++) {
                result += String.valueOf(this._array[row][col]);
                // Adding tab only for the inner cells
                result += col < (_array[row].length - 1) ? "\t" : "";
            }
            result += "\n";
        }

        return result;
    }

//    public Matrix makeNegative(){
//
//    }
//
//    public Matrix imageFilterAverage(){
//
//    }
//
//    public Matrix rotateClockwise(){
//
//    }
//
//    public Matrix rotateCounterClockwise(){
//
//    }
}
