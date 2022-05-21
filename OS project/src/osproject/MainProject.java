/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osproject;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class  MainProject{


    boolean exit;

    public static void main(String[] args) throws FileNotFoundException  {
        MainProject menu = new MainProject();
        menu.runMenu();
    }

    public void runMenu() throws FileNotFoundException {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    private void printHeader() {
         
         System.out.println("*************************************");
         System.out.println("|      mai Hashlamoon      191075    |");
         System.out.println("*************************************");

    }

    private void printMenu() {
        displayHeader("Please Enter a selection");
        System.out.println("1) Part1: Simulate a CPU scheduler");
        System.out.println("2) Part2: Simulate a Paging Memory Manager");
        System.out.println("3) Exit");
    }

    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection, only Numbers  please.");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of range, Please choose again.");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    private void performAction(int choice) throws FileNotFoundException {
        switch (choice) {
            case 3:
                System.out.println("God Bey");
                System.exit(0);
                break;
                
            case 1: {
                 System.out.println("PART 1 \n*********************************************************************\n FCFS ALGORITHM");
 
        FCFS.fcfs(); 
        
        System.out.println("*********************************************************************\n SJF ALGORITHM");
  
        SJF.sjf();
        System.out.println("*********************************************************************\n ROUND ROBIN ALGORITHM");
 
        RR.roundRobin();
            }
            break;
            
            case 2:
         System.out.println("\n*********************************************************************\nPART 2 ");
        Part2.simulation(); 
   
                break;
        
            default:
                System.out.println("Unknown error has occurred.");
        }
    }



    


    private void displayHeader(String message){
        System.out.println();        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < width; ++i){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    
    }
     }