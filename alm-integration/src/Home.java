// Ariana Monsalve
// COP  2006
// Integration Project

// This project will showcase the programming skills 
// and techniques I have learned throughout the semester.

import java.util.Scanner;

public class Home {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Welcome prompt
    System.out.println("Welcome to my Integration Project!");
    boolean running = true;
    while (running) {
      System.out.println("Navigate pages 1-3");
      System.out.println("Enter 0 to exit");
      int page = Integer.valueOf(scan.nextLine());

      // Navigation
      switch (page) {
        case 0:
          running = false;
          System.out.println("Goodbye!");
          break;

        case 1:
          demonstrateVariables(scan);

          break;

        case 2:
          objectsDemo(scan);

          break;

        case 3:
          System.out.println("Write a time in HHMM ex: 2359");
          int timeInput = Integer.valueOf(scan.nextLine());
          String time = TimeCalc.calculateTime(timeInput);
          System.out.println("The time is " + time);

          break;

        default:
          System.out.println("Invalid page number");

          break;
      }
    }
    scan.close();
  }

  public static void demonstrateVariables(Scanner scan) {
    String txt1 = "A variable is a spot in memory where the program "
        + "can store a value";

    System.out.println(txt1);

    System.out.println("Hello World!");
    System.out.println(":)");
    System.out.println("What is your name?");
    String name1 = scan.nextLine();
    System.out.println("Name: " + name1);

    System.out.println("Enter n1");
    int num1 = Integer.valueOf(scan.nextLine());
    System.out.println("n1: " + num1);

    System.out.println("Enter a nickname");
    String name2 = scan.nextLine();
    System.out.println("Nickname :" + name2);

    System.out.println("Enter a rate");
    double dou1 = Double.valueOf(scan.nextLine());
    System.out.println("Double :" + dou1);
  }

  public static void objectsDemo(Scanner scan) {
    Dog dog1 = new Dog();

    dog1.setSize(30.5);
    dog1.setAge(3);
    dog1.setName("Fizzy");

    System.out.println();

    System.out.println("Enter a floating point number.");
    String txtnum = scan.nextLine();
    double num2 = Double.valueOf(txtnum);
    System.out.println("The negation of your number is " + (-num2));
    System.out
        .println("Your number is equal to " + (int) num2 + " plus " + num2 % 1);
  }

}