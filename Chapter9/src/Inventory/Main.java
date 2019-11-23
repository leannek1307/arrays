/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;


import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Inventory application that keeps track of the inventory for a sports store.
 * @author leannekim
 */

public class Main {
    private static ArrayList<Integer> stockNum = new ArrayList<>();
    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<Integer> stockAmt = new ArrayList<>();
    private static int stockNumber;

    /**
     * constructor
     * pre: none
     * post: stockNumber has been initialized.
     */
    public Main(){
        stockNumber = 999;
    }
    
    /**
     * Create a new item, enter info
     * pre: none
     * post: A new item has been created.
     */
    public static void addItem(){
        Scanner input = new Scanner(System.in);

        stockNumber += 1;           // stock # 1000 is at index 0... so on.
        System.out.println("stock #: " + stockNumber);
        stockNum.add(stockNumber);
        
        System.out.print("\nEnter name of the new item: ");
        String newName = input.nextLine();
        name.add(newName);
        
        System.out.print("\nEnter the amount of stock: ");
        int newStockAmt = input.nextInt();
        stockAmt.add(newStockAmt);
    }
    
    /**
     * Discontinue item. Name of stock is reset to "discontinued", stockAmt is reset to 0.
     * pre: none
     * post: An item has been discontinued.
     */
    public static void discontinueItem(){
        Scanner input = new Scanner(System.in);
       
        System.out.print("\nEnter the stock # of the stock you would like to discontinue: ");
        int disStockNum = input.nextInt();
        disStockNum -= 1000;    // to get index #
        
        name.set(disStockNum, "discontinued");
        stockAmt.set(disStockNum, 0);
    }
    
    /**
     * Display the amount of item.
     * pre: none
     * post: Amount of the item has been displayed.
     */
    public static void displayStockAmt(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter stock # to display the amount in stock: ");
        int userInput = input.nextInt();
        userInput -= 1000;
        
        System.out.println(stockAmt.get(userInput) + " of " + name.get(userInput) + " in stock");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        
        while (!userChoice.equals("q")){    // Enter q to quit.
            System.out.print("\nEnter a choice\n(a)dd an item\n(d)iscontinue item\ndisplay (s)tock for an item\n(q) to quit: ");
            userChoice = input.nextLine();

            if (userChoice.equals("a")){
                addItem();
            } else if (userChoice.equals("d")){
                discontinueItem();
            } else if (userChoice.equals("s")){
                displayStockAmt();
            } else if (userChoice.equals("q")){
                break;
            } else {
                System.out.println("Incorrect input");
            }
        }
        
    }
}

