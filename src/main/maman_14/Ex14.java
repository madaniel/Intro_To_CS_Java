package main.maman_14;

public class Ex14 {
    /**
     * Maman 14 - static methods for questions 1-4
     *
     * @author Daniel Madar
     * @version 25/5/2019
     */
    private static int f (int[]a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    public static int what(int[]a){
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
     * Return the last index of the positive sum in array
     * @param a array of int, positive and negative
     * @return last index of positive sum
     */
    public static int whatNew(int[] a){
        int lastIndex = a.length;
        int sum = 0;

        // Looping over array a to find the total sum
        for(int i=0; i < a.length; i++)
            sum += a[i];

        // Decrementing sum from last index until sum gets odd
        for(int i=a.length-1; i >= 0; i--) {
            if (sum % 2 == 0)
                break;
            sum -= a[i];
            lastIndex -= 1;
        }

        return lastIndex;
        }
    }


