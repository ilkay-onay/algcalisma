package kirmizisiyah;

import java.util.*;


public class RedBlackOrnek {


	public static void main(String[] args) {
        // TODO code application logic here
        // instance of the Scanner class  
        Scanner scan = new Scanner(System.in);  
  
        //Create instance of the createRedBlackTree class and pass minimum integer value to the constructor to make it header node  
        CreateRedBlackTree obj = new CreateRedBlackTree(Integer.MIN_VALUE);   
        char choice;  
  
        //create switch case for performing the operation in Red Black Tree  
        do      
        {  
            System.out.println("\nSelect an operation:\n");  
            System.out.println("1. Insert a node ");  
            System.out.println("2. Search a node");  
            System.out.println("3. Get total number of nodes in Red Black Tree");  
            System.out.println("4. Is Red Black Tree empty?");  
            System.out.println("5. Remove all nodes from Red Black Tree");  
            System.out.println("6. Display Red Black Tree in Post order");  
            System.out.println("7. Display Red Black Tree in Pre order");  
            System.out.println("8. Display Red Black Tree in In order");  
  
            //get choice from user  
            int ch = scan.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Please enter an element to insert in Red Black Tree");  
                    obj.insertNewNode( scan.nextInt() );                       
                    break;                            
                case 2 :   
                    System.out.println("Enter integer element to search");  
                    System.out.println(obj.searchNode( scan.nextInt() ));  
                    break;                                            
                case 3 :   
                    System.out.println(obj.nodesInTree());  
                    break;       
                case 4 :   
                    System.out.println(obj.checkEmpty());  
                    break;       
                case 5 :   
                    obj.removeAll();  
                    System.out.println("\nTree Cleared successfully");  
                    break;  
                case 6 :   
                    System.out.println("\nDisplay Red Black Tree in Post order");  
                    obj.postorderTraversal();  
                    break;  
                case 7 :   
                    System.out.println("\nDisplay Red Black Tree in Pre order");  
                    obj.preorderTraversal();  
                    break;  
                case 8 :   
                    System.out.println("\nDisplay Red Black Tree in In order");  
                    obj.inorderTraversal();  
                    break;  
                default :   
                    System.out.println("\n ");  
                    break;      
            }  
            System.out.println("\nPress 'y' or 'Y' to continue \n");  
            choice = scan.next().charAt(0);                          
        } while (choice == 'Y'|| choice == 'y');                 
    }  


}
