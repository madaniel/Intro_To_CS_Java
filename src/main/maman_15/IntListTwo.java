package main.maman_15;

/**
 * Maman 15 -
 *
 * Bi-directional linked list
 *
 * The list will be sorted in increasing order
 *
 * @author Daniel Madar
 * @version 2/6/2019
 */

public class IntListTwo {

    private IntNodeTwo _head, _tail;

    /**
     * Empty constructor
     * Head and tail will be null
     */
    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    /**
     * Constructor with head and tail
     * @param h head of the list
     * @param t tail of the list
     */
    public IntListTwo(IntNodeTwo h, IntNodeTwo t) {
        _head = h;
        _tail = t;
    }

    /**
     * Will add number to the list by increasing order
     * @param num number to add
     */
    public void addNumber(int num){

    }

    /**
     * Will remove number from the list, keeping the order
     * @param num number to remove
     */
    public void removeNumber(int num){

    }

    /**
     * Reads from the user list of int numbers until number -9999
     * The numbers will be added to the list
     */
    public void readToList(){

    }

    public String toString(){
        return "";
    }

    public int length(){
        return 0;
    }

    public int sum(){
        return 0;

    }

    public int maxLength(){
        return 0;
    }

    public boolean isAverage(double num){
        return false;
    }

}
