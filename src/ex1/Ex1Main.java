package ex1;

import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here
                System.out.println("num1= " + num1 + " is number: true , value: " + num1);
                System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                num2 = sc.next();
                System.out.println("num2= " + num2 + " is number: true , value: " + num2);
                System.out.println("Enter a base for output: (a number [2,16]");
                String num3;
                num3 = sc.next();
                int z = Ex1.number2Int(num1);
                int e = Ex1.number2Int(num2);
                System.out.println(num1 + " + " + num2 + " = " + (z + e));
                System.out.println(num1 + " * " + num2 + " = " + (z * e));
                System.out.println("Max number over [" + num1 + "," + num2 + "");
                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
