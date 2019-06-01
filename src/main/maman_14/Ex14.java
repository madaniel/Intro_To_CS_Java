package main.maman_14;
import java.util.Arrays;

/**
 * Maman 14 - static methods for questions 1-4
 *
 * @author Daniel Madar
 * @version 25/5/2019
 */
public class Ex14 {

    /**
     * Question 1:
     * Return volume of water can accumulate between array of heights
     * @param height array of heights
     * @return amount of water
     */

    public static int waterVolume(int [] heights){
        // Waters cannot accumulate on the edges
        if (heights.length < 3)
                return 0;

        int [] leftMaxList = new int[heights.length];
        int [] rightMaxList = new int[heights.length];

        int waterSum=0;
        int leftMax=0;
        int rightMax=0;

        int leftIndex = 1;
        int rightIndex = heights.length-2;

        while(leftIndex <= heights.length && rightIndex >=0){
            leftMax = Math.max(leftMax, heights[leftIndex-1]);
            leftMaxList[leftIndex] = leftMax;

            rightMax = Math.max(rightMax, heights[rightIndex+1]);
            rightMaxList[rightIndex] = rightMax;

            leftIndex++;
            rightIndex--;
        }

        int waterPerCell;
        int actualWaterPerCell;

        for(int i=0; i<heights.length; i++){
            waterPerCell = Math.min(leftMaxList[i], rightMaxList[i]);
            actualWaterPerCell = Math.max(0, waterPerCell - heights[i]);
            waterSum += actualWaterPerCell;
        }

        return waterSum;
        }

    private static int f (int[]a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    public static int whatOld(int[]a){
        int temp = 0;

        for (int i=0; i < a.length; i++){

            for (int j=i; j<a.length; j++){

                int c = f(a, i, j);
                if (c % 2 == 0){
                    if (j-i+1 > temp)
                        temp = j-i+1;
                }
            }
        }

        return temp;
    }

    /**
     * Question 2:
     * Return the last index of the even sum in array
     * @param a array of int, positive and negative
     * @return length of longest sub array of positive numbers
     */
    public static int what(int[] a){
        int sum = 0;
        int maxLengthEvenSum = a.length;

        for(int i=0; i < a.length; i++)
            sum += a[i];

        // Sum is even
        if (sum % 2 == 0)
            return maxLengthEvenSum;

        // Sum is odd
        // We need to find first odd number in array from right and left
        int rightSum = sum;
        int leftSum = sum;
        int rightLengthEvenSum = maxLengthEvenSum;
        int leftLengthEvenSum = maxLengthEvenSum;
        int leftIndex = 0;
        int rightIndex = a.length-1;

        while(rightSum %2 != 0 && rightIndex >= 0){
            rightSum -= a[rightIndex];
            rightIndex --;
            rightLengthEvenSum --;
            }

        while(leftSum %2 != 0 && leftIndex < a.length){
            leftSum -= a[leftIndex];
            leftIndex ++;
            leftLengthEvenSum --;
            }

        return Math.max(rightLengthEvenSum, leftLengthEvenSum);
        }



    /**
     * Question 3:
     * Return the number of solutions for equation x1+x2+x3 = num
     * @param num result of the equation
     * @return number of solutions
     */
    public static int solutions(int num){
        return solutions(num, 1, 1, 1, new int[100][3]);
        }

    private static int solutions(int num, int x1, int x2, int x3, int[][] recordList){
        if(num < 3)
            return 0;

        int [] arrayX = {x1, x2, x3};

        if(x1 > 10 || x2 > 10 || x3 > 10 || isArrayIn(arrayX, recordList))
            return 0;

        if(x1 + x2 + x3 == num){
            System.out.println(x1 + " + " + x2 + " + " + x3);
            append(arrayX, recordList);
            return 1;
            }

        return solutions(num, x1+1, x2, x3, recordList) + solutions(num, x1, x2+1, x3, recordList) + solutions(num, x1, x2, x3+1, recordList);
        }

    /**
     * Checks if ArrayA exists in ArrayB (array of arrays)
     * @param array array source
     * @param mat array target
     * @return found or not found
     */
    private static boolean isArrayIn(int [] array, int [][] mat){
        int [] emptyCell = {0, 0, 0};

        for(int i=0; i<mat.length; i++)
            if(Arrays.equals(array, mat[i]))
                return true;
            else if(Arrays.equals(emptyCell, mat[i]))
                return false;

        return false;
        }

    /**
     * Add array to last available place in matrix
     * @param array array to add
     * @param mat target matrix
     */
    private static void append(int [] array, int [][] mat){
        int [] emptyCell = {0, 0, 0};
        int i=0;

        // Search for last empty cell
        while (!Arrays.equals(emptyCell, mat[i]))
            i ++;

        mat[i] = array;
        }

    /**
     * Question 4:
     * Find and returns the path in matrix of target sum
     * @param mat matrix of positive number
     * @param sum target sum to find in matrix
     * @param path matrix of 0 to mark the path of sum with 1
     * @return true - if sum found false - sum not found in matrix
     */
    public static boolean findSum (int [][] mat, int sum, int [][] path){
        return findSumIterator(mat, path, sum, 0, 0);
        }

    /**
     * Triggers findSum for each matrix cell in recursion
     *
     * @param mat matrix of positive number
     * @param path matrix of 0 to mark the path of sum with 1
     * @param sum target sum to find in matrix
     * @param x index of column in matrix
     * @param y index of line in matrix
     * @return true - if sum found false - sum not found in matrix
     */
    private static boolean findSumIterator(int [][] mat, int [][] path, int sum, int x, int y){
        if(x > mat[0].length-1 || y > mat.length-1)
            return false;

        if(findSum(mat, path, sum, x, y))
            return true;

        return findSumIterator(mat, path, sum, x+1, y) || findSumIterator(mat, path, sum, x, y+1);
        }

    /**
     * Search in recursion over the matrix for numbers which summed to sum argument
     * Recursion starts from x and y arguments
     * @param mat matrix of positive number
     * @param path matrix of 0 to mark the path of sum with 1
     * @param sum target sum to find in matrix
     * @param x index of column in matrix
     * @param y index of line in matrix
     * @return true - if sum found false - sum not found in matrix
     */
    private static boolean findSum(int [][] mat, int [][] path, int sum, int x, int y){
        if(sum < 0 || x < 0 || y < 0 || x > mat[0].length-1 || y > mat.length-1 || path[y][x]==1)
            return false;

        // Sum was found
        if(sum == 0)
            return true;

        // Tag this cell as visited
        path[y][x] = 1;

        if(x < mat[0].length-1 && findSum(mat, path, sum - mat[y][x], x + 1, y))
            return true;

        else if(y < mat.length-1 && findSum(mat, path, sum - mat[y][x], x, y + 1))
            return true;

        else if(y > 0 && findSum(mat, path, sum - mat[y][x], x, y - 1))
            return true;

        else if(x > 0 && findSum(mat, path, sum - mat[y][x], x - 1, y))
            return true;

        else
            path[y][x] = 0;
            return false;
        }
    }






