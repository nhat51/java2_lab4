package lab4;

import java.sql.*;
import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to ebook store");
        System.out.println("==========================");
        controller objControl = new controller();
        int choice;
        do {
            System.out.println("1.Top 10 books newest");
            System.out.println("2.Bestselling books");
            System.out.println("3.Find books by ID");
            System.out.println("4.Find books by author");
            System.out.println("5.Find book by category" + "(1-detective,2-poem,3-literature)");
            System.out.println("6.Exit");
            System.out.println("Your choice is: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    objControl.top10new();
                    break;
                case 2:
                    objControl.topSale();
                    break;
                case 3:
                    objControl.FindByID();
                    break;
                case 4:
                    objControl.FindByAuthor();
                    break;
                case 5:
                    objControl.FindByCategory();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 6);
    }
}
