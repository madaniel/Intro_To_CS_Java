/**
 * Student Tester for Maman 15
 */
public class Maman15StudentTester
{
    public static void main (String[] args)
    {
        System.out.println("\n-----Testing IntListTwo Class:-----\n"); 
               
        int[] arr = {2, -4, 8, 5};        
       
        // test constructor
        IntListTwo list = new IntListTwo();   
        
        // test toString()
        System.out.println("list.toString() = " + list);
        System.out.println();
        
        // test addNumber(int num)
        for(int i = 0; i < arr.length; ++i) {            
            list.addNumber(arr[i]);
            System.out.println("list.addNumber(" + arr[i] + ")" + "\tlist.toString() = " + list);
        }
        
        System.out.println("\nlist.toString() = " + list);
        
        // test length()
        System.out.println("list.length() = " + list.length());
        
        // test sum()
        System.out.println("list.sum() = " + list.sum());
        
        // test maxLength()
        System.out.println("list.maxLength() = " + list.maxLength());
        
        // test isAverage(int num)
        int num = 1;
        System.out.println("list.isAverage(" + num + ") = " + list.isAverage(num));
        
        // test removeNumber(int num)
        System.out.println();
        for(int i = 0; i < arr.length; ++i) {                       
            System.out.println("list.toString() = " + list + "\tlist.removeNumber(" + arr[i] + ")");
            list.removeNumber(arr[i]);
        }  
        System.out.println("list.toString() = " + list);
        
        // test readToList()
        System.out.println("\nPlease enter a list of integer numbers (and enter -9999 to mark the end of list): ");
        list = new IntListTwo();
        list.readToList();
        System.out.println("list.toString() = " + list);
    }
}   


