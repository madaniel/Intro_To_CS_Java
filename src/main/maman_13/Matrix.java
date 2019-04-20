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

    public Matrix makeNegative(){
        int [][] negativeMatrix = _getMatrix(this._matrixArray);

        for(int row=0; row < negativeMatrix.length; row++)
            for(int col=0; col < negativeMatrix[0].length; col++)
                negativeMatrix[row][col] = 255 - this._matrixArray[row][col];

        return new Matrix(negativeMatrix);
    }

    public Matrix rotateCounterClockwise(){
        int [][] rotatedClockwiseMatrix = _getMatrix(new int [this._matrixArray[0].length][this._matrixArray.length]);

        for(int row=0; row < this._matrixArray.length; row++)
            for(int col=0; col < this._matrixArray[0].length; col++)
                rotatedClockwiseMatrix[col][row] = this._matrixArray[row][this._matrixArray[0].length - 1 - col];

        return new Matrix(rotatedClockwiseMatrix);
    }

    public Matrix rotateClockwise(){
        int [][] rotatedClockwiseMatrix = _getMatrix(new int [this._matrixArray[0].length][this._matrixArray.length]);

        for(int row=0; row < this._matrixArray.length; row++)
            for(int col=0; col < this._matrixArray[0].length; col++)
                rotatedClockwiseMatrix[col][this._matrixArray.length -1 - row] = this._matrixArray[row][col];

        return new Matrix(rotatedClockwiseMatrix);
    }

    public Matrix imageFilterAverage(){
        int [][] imageFilterAverageMatrix = _getMatrix(new int [this._matrixArray.length][this._matrixArray[0].length]);

        for(int row=0; row < this._matrixArray.length; row++)
            for(int col=0; col < this._matrixArray[0].length; col++)
                imageFilterAverageMatrix[row][col] = _getAllNeighborsAverage(row, col);

        return new Matrix(imageFilterAverageMatrix);
    }

    private int _getAllNeighborsAverage(int row, int col){
        int [] neighbors = new int[9];

        neighbors[0] = _getNeighborValue(row, col +1); // right
        neighbors[1] = _getNeighborValue(row + 1, col +1);  // rightDown
        neighbors[2] = _getNeighborValue(row + 1, col);  // down
        neighbors[3] = _getNeighborValue(row + 1, col -1); // downLeft
        neighbors[4] = _getNeighborValue(row, col -1);  // left
        neighbors[5] = _getNeighborValue(row - 1, col -1);  // leftUp
        neighbors[6] = _getNeighborValue(row - 1, col);  // up
        neighbors[7] = _getNeighborValue(row - 1, col + 1);  // upRight
        neighbors[8] = this._matrixArray[row][col];

        int count = 0;
        double sum = 0;

        for(int i=0; i < neighbors.length; i++)
            // only if neighbor does exist
            if(neighbors[i] != -1){
                count++;
                sum += neighbors[i];
            }

        return (int)Math.floor(sum / count);
    }



    private int _getNeighborValue(int row, int col){
        int value;

        try {
            value = this._matrixArray[row][col];
        }
        catch(IndexOutOfBoundsException e) {
            value = -1;
        }

        return value;
    }




    private int [][] _getMatrix(int [][] matrixSource){
        int [][] matrixCopy = new int [matrixSource.length][matrixSource[0].length];

        for(int row=0; row < matrixCopy.length; row++)
            for(int col=0; col < matrixCopy[0].length; col++)
                matrixCopy[row][col] = matrixSource[row][col];

        return matrixCopy;
    }
}
