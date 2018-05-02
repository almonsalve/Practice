// Ariana Monsalve
// COP  2006
// Integration Project

// This project will showcase the programming skills 
// and techniques I have learned throughout the semester.

import java.util.Scanner;

public class Home {

  /**
   * The main method. This is the first method the program runs.
   * 
   * @param args
   *          TODO Describe what args is and why I need them in this method.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Welcome prompt
    System.out.println("Welcome to my Integration Project!");
    boolean running = true;
    while (running) {
      System.out.println("Navigate pages 1-12");
      System.out.println("Enter 0 to exit");
      int page;
      try {
        page = Integer.parseInt(scan.nextLine());
      } catch (Exception ex) {
        page = -1;
      }
      // Navigation
      switch (page) {
        case 0:
          running = false;
          System.out.println("Goodbye!");
          break;

        case 1:
          // Method call: using the method signature, which contains the method
          // name, then the arguments to be passed into the method inside
          // parentheses.
          variableInfo(scan);
          // demonstrateVariables(scan);

          break;

        case 2:
          objectsDemo(scan);

          break;

        case 3:
          System.out.println("The current time is " + TimeCalc.currentTime());
          System.out.println("Write a time in HHMM ex: 2359");
          int timeInput = InputHandler.intInLoop(scan);
          String time = TimeCalc.calculateTime(timeInput);
          System.out.println("The time is " + time);

          break;

        case 4:
          carDemo(scan);

          break;

        case 5:

          System.out.println("1: Create a List");
          System.out.println("2: Return a List");
          System.out.println("3: Remove items from a list");
          boolean confirm5 = false;
          int grListPage = 0;
          while (!confirm5) {
            try {
              grListPage = Integer.parseInt(scan.nextLine());
              confirm5 = true;
            } catch (Exception ex) {
              System.out.println("Invalid input.");
            }
          }
          switch (grListPage) {

            case 1:
              GroceryList.createList(scan);
              break;

            case 2:
              GroceryList.readList();
              break;

            case 3:
              GroceryList.removeItem(scan);
              break;

            default:
              System.out.println("Invalid input.");
          }
          break;

        case 6:
          PriceCalc.calculatePrice(scan);
          break;

        case 7:
          Beverage.coffeeSim(scan);
          break;

        case 8:
          RandGen.color(scan);
          break;

        case 9:
          ConnectFour game = new ConnectFour();
          game.displayBoard();
          while (game.isItRunning()) {
            System.out.println("It is " + game.getActivePlayer() + "'s turn.");
            System.out.println("Place a token. Type X to exit.");
            String gameInput = scan.nextLine();
            gameInput = gameInput.toLowerCase();
            if (gameInput.contains("x")) {
              game.shutDown();
            } else {
              try {
                gameInput = gameInput.trim();
                game.placeToken(Integer.parseInt(gameInput));
              } catch (Exception ex) {
                System.out.println("Invalid input.");
              }
            }
          }
          break;
        case 10:
          new RpsGame(scan);
          break;
        case 11:
          StringManipulationDemo.menu(scan);
          break;
        case 12:
          new People(scan);
          break;
        default:
          System.out.println("Invalid page number");

          break;
      }
    }
    scan.close();
  }

  /**
   * An early method that creates variables and stores information in them based
   * on user input.
   * 
   * @param scan
   *          The Scanner object that is reading input.
   */

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
    try {
      int num1 = Integer.parseInt(scan.nextLine());
      System.out.println("n1: " + num1);
    } catch (Exception ex) {
      System.out.println("Invalid input.");
    }

    System.out.println("Enter a nickname");
    String name2 = scan.nextLine();
    System.out.println("Nickname :" + name2);

    System.out.println("Enter a rate");
    try {
      double dou1 = Double.valueOf(scan.nextLine());
      System.out.println("Double :" + dou1);
    } catch (Exception ex) {
      System.out.println("Invalid input.");
    }

    System.out.println("Enter an integer to divide");
    boolean confirm = false;
    int divnum1 = 0;
    while (!confirm) {
      try {
        divnum1 = Integer.parseInt(scan.nextLine());
        confirm = true;
      } catch (Exception ex) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    System.out.println("Enter an integer to be the divisor");
    confirm = false;
    int divnum2 = 0;
    while (!confirm) {
      try {
        divnum2 = Integer.parseInt(scan.nextLine());
        confirm = true;
      } catch (Exception ex) {
        System.out.println("Invalid input. Please try again.");
      }
    }

    if (divnum2 == 0) {
      System.out.println("Cannot divide by zero.");
    } else {
      // Dividing two ints results in an int.
      // To return the decimal value, the numbers are converted to double
      double ddivsum = (double) divnum1 / (double) divnum2;
      System.out.println(divnum1 + " divided by " + divnum2 + " equals");
      System.out.println(ddivsum);
      // to return the whole number and remainder, directly divide the ints
      // then repeat using the modulo operator
      System.out.println("or " + (divnum1 / divnum2) + " with a remainder of "
          + (divnum1 % divnum2));
    }
  }

  /**
   * Creates a dog object, sets its information and gets it from the instance.
   * 
   * @param scan
   *          The Scanner object that is reading input.
   */
  public static void objectsDemo(Scanner scan) {
    // PSI 1: Create Java classes and use object references
    Dog dog1 = new Dog();

    dog1.setSize(30.5);
    dog1.setAge(3);
    dog1.setName("Copper");

    System.out.println("Name: " + dog1.getName());
    System.out.println("Age: " + dog1.getAge());
    System.out.println("Size: " + dog1.getSize());
    System.out.println("Enter a floating point number.");
    boolean confirm = false;
    while (!confirm) {
      try {
        String txtnum = scan.nextLine();
        double num2 = Double.valueOf(txtnum);
        System.out.println("The negation of your number is " + (-num2));
        System.out.println(
            "Your number is equal to " + (int) num2 + " plus " + num2 % 1);
        confirm = true;
      } catch (Exception ex) {
        System.out.println("Invalid input. Please try again.");
      }
    }

  }

  // PSI 1: Write Java code that uses variables
  // all eight types defined

  /**
   * Presents a list of primitive variables. When the user inputs the name of a
   * variable, the program prints the definition of that variable.
   * 
   * @param in
   *          The Scanner object accepting input.
   */

  // Header of method: Access modifiers first, then the name of the method, and
  // then the parameters in parentheses, followed by curly braces.
  public static void variableInfo(Scanner in) {
    boolean loop = true;
    while (loop) {
      System.out.println("Definitions for primitive variables");
      System.out.println("- byte");
      System.out.println("- short");
      System.out.println("- int");
      System.out.println("- long");
      System.out.println("- float");
      System.out.println("- double");
      System.out.println("- boolean");
      System.out.println("- char");
      System.out.println("Type x to exit.");
      String input = in.nextLine();
      if (input.equalsIgnoreCase("x")) {
        loop = false;
      } else {
        System.out.println(MenuText.getDefinition(input));
        System.out.println();
      }
    }
  }

  /**
   * Demonstrates Objects and the use of setters and getters.
   * 
   * @param scan
   *          The Scanner object accepting input.
   */
  public static void carDemo(Scanner scan) {
    Car car1 = new Car();
    car1.setSpeed(40);
    car1.setMake("Honda");
    Car car2 = new Car("Toyota");
    car1.printDetails();
    car2.printDetails();
  }
}