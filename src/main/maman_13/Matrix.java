package main.maman_13;

public class Matrix {

    private int [] [] _matrixArray;

    public Matrix(int [] [] array){
        this._matrixArray = new int[array.length][array[0].length];

        for(int row=0; row < array.length; row++)
            for(int col=0; col < array[row].length; col++)
                this._matrixArray[row][col] = array[row][col];
    }

    public Matrix(int size1, int size2){
        this._matrixArray = new int[size1][size2];

        for(int row=0; row < size1; row++)
            for(int col=0; col < size2; col++)
                this._matrixArray[row][col] = 0;
    }

    public String toString(){
        String result = "";

        for(int row = 0; row < _matrixArray.length; row++) {
            for (int col = 0; col < _matrixArray[row].length; col++) {
                result += String.valueOf(this._matrixArray[row][col]);
                // Adding tab only for the inner cells
                result += col < (_matrixArray[row].length - 1) ? "\t" : "";
            }
            result += "\n";
        }

        return result;
    }

    public int [][] makeNegative(){
        int [][] negativeMatrix = _getMatrix(this._matrixArray);

        for(int row=0; row < negativeMatrix.length; row++)
            for(int col=0; col < negativeMatrix[0].length; col++)
                negativeMatrix[row][col] = 255 - this._matrixArray[row][col];

        return negativeMatrix;
    }

    public int [][] rotateCounterClockwise(){
        int [][] rotatedClockwiseMatrix = _getMatrix(new int [this._matrixArray[0].length][this._matrixArray.length]);

        for(int row=0; row < this._matrixArray.length; row++)
            for(int col=0; col < this._matrixArray[0].length; col++)
                rotatedClockwiseMatrix[col][row] = this._matrixArray[row][this._matrixArray[0].length - 1 - col];

        return rotatedClockwiseMatrix;
    }

    private int [][] _getMatrix(int [][] matrixSource){
        int [][] matrixCopy = new int [matrixSource.length][matrixSource[0].length];

        for(int row=0; row < matrixCopy.length; row++)
            for(int col=0; col < matrixCopy[0].length; col++)
                matrixCopy[row][col] = matrixSource[row][col];

        return matrixCopy;
    }

//    public int [][] imageFilterAverage(){
//
//    }
//

//
//    public int [][] rotateCounterClockwise(){
//
//    }


}