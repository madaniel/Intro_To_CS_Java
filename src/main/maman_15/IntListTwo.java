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
        IntNodeTwo newNum = new IntNodeTwo(num);
        IntNodeTwo pointer;

        // List is empty
        if(isListEmpty()){
            this._head = newNum;
            this._tail = newNum;
            return;
        }

        // List is not empty
        for(pointer = this._head; pointer.getNext() != null && pointer.getNum() < num ; pointer = pointer.getNext());

        // newNum should be first
        if(isSingle(pointer) && num <= pointer.getNum()){
            newNum.setNext(pointer);
            pointer.setPrev(newNum);
            this._head = newNum;
            this._tail = pointer;
        }

        // newNum should be second
        else if(isSingle(pointer) && num > pointer.getNum()){
            newNum.setPrev(pointer);
            pointer.setNext(newNum);
            this._tail = newNum;
        }

        // newNum should be last
        else if(isLast(pointer) && num > pointer.getNum()){
            newNum.setPrev(newNum);
            pointer.setNext(newNum);
            this._tail = pointer;
        }

        // newNum should be in between
        else {
            IntNodeTwo prev = pointer.getPrev();
            pointer.setPrev(newNum);
            prev.setNext(newNum);
        }
    }

    /**
     * Will remove number from the list, keeping the order
     * @param num number to remove
     */
    public void removeNumber(int num){
        // Looking for target number
        IntNodeTwo pointer;
        for(pointer = this._head; pointer != null && pointer.getNum() != num ; pointer = pointer.getNext());

        // Either List is empty or number not found - do nothing
        if(pointer == null);

        // Number is single in list, we detach the head and tail
        else if(this.isSingle(pointer)){
            this._head = null;
            this._tail = null;
        }

        // Number is first in list, head will point 2nd number and its previous will detach
        else if(this.isFirst(pointer)){
            IntNodeTwo nextNumber = pointer.getNext();
            this._head = nextNumber;
            nextNumber.setPrev(null);
        }

        // Number is last in list
        else if(this.isLast(pointer)){
            IntNodeTwo prev = pointer.getPrev();
            prev.setNext(null);
            this._tail = prev;
        }

        // Number is in the middle, we attach previous node to next one and next one to previous
        else if(this.isInBetween(pointer)){
            IntNodeTwo prev = pointer.getPrev();
            IntNodeTwo next = pointer.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }
    }

    /**
     * Reads from the user list of int numbers until number -9999
     * The numbers will be added to the list
     */
    public void readToList(){

    }

    public String toString(){
        IntNodeTwo pointer;
        String listString = "{";

        for(pointer = this._head; pointer != null; pointer = pointer.getNext())
            listString += pointer.getNum() + ", ";

        listString += "}";

        return listString;
    }

    /**
     * Returns the number of the numbers in the list
     * @return number of numbers in the list
     */
    public int length(){
        IntNodeTwo pointer;
        int counter = 0;

        for(pointer = this._head; pointer != null; pointer = pointer.getNext())
            counter++;

        return counter;
    }

    /**
     * Returns the sum of the numbers in the list
     * @return sum of the numbers in the list
     */
    public int sum(){
        IntNodeTwo pointer;
        int sum = 0;

        for(pointer = this._head; pointer != null; pointer = pointer.getNext())
            sum += pointer.getNum();

        return sum;
    }

    /**
     * Returns the length of the longest sub-array even sum
     * @return length of the longest sub-array even sum
     */
    public int maxLength(){
        if(isListEmpty())
            return 0;

        IntNodeTwo leftPointer=_head, rightPointer=_tail;
        int sum = sum();
        int count = length();

        // Base case - sum is even
        if (sum % 2 == 0)
            return count;

        // Sum is odd + odd number from the right
        // Iterate from the right, decreasing value until the sum is even
        int tmpSum = sum, rightLength = count;

        while(tmpSum % 2 != 0){
            tmpSum -= rightPointer.getNum();
            rightLength --;
            rightPointer = rightPointer.getPrev();
        }

        // Sum is odd + odd number from the left
        // Iterate from the left, decreasing value until the sum is even
        int leftLength = count;
        tmpSum = sum;

        while(tmpSum % 2 != 0){
            tmpSum -= leftPointer.getNum();
            leftPointer = leftPointer.getNext();
            leftLength --;
        }

        return Math.max(leftLength, rightLength);
    }

    /**
     * Returns true if there's sub-array with average num
     * @param num real num
     * @return true if there's sub-array with average num, false otherwise
     */
    public boolean isAverage(double num){
        if(isListEmpty())
            return false;

        IntNodeTwo leftPointer=_head, rightPointer=_tail;
        int sum = sum();
        int count = length();
        double average = sum /(double)count;

        // Increasing or decreasing the average to find the target num
        while(leftPointer != rightPointer || num != average){

            if(average < num){
                sum -= leftPointer.getNum();
                count -= 1;
                average = sum /(double)count;
                leftPointer = leftPointer.getNext();
            }

            else if(average > num){
                sum -= rightPointer.getNum();
                count -= 1;
                average = sum /(double)count;
                rightPointer = rightPointer.getPrev();
            }
        }

        return num == average;
    }

    private boolean isSingle(IntNodeTwo nodePointer){
        return this._head == nodePointer && this._tail == nodePointer;
    }

    private boolean isFirst(IntNodeTwo nodePointer){
        return this._head == nodePointer && this._tail != nodePointer;
    }

    private boolean isLast(IntNodeTwo nodePointer){
        return this._head != nodePointer && this._tail == nodePointer;
    }

    private boolean isInBetween(IntNodeTwo nodePointer){
        return nodePointer.getNext() != null && nodePointer.getPrev() != null;
    }

    private boolean isListEmpty(){
        return this._head == null && this._tail == null;
    }
}