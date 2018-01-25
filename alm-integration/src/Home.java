// Ariana Monsalve

// This project will showcase the programming skills 
// and techniques I have learned throughout the semester.
import java.util.Scanner;

class Dog {
	double dogSize;
	int dogAge;
}

public class Home {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Hello World!");
			System.out.println(":)");
			
			System.out.println("What is your name?");
			String name1 = scan.nextLine();
			System.out.println("Name: " + name1);
			
			System.out.println("Enter n1");
			int n1 = scan.nextInt();
			System.out.println("n1: " + n1);
			
			scan.nextLine();
			System.out.println("Enter a nickname");
			String name2 = scan.nextLine();
			System.out.println("Nickname :" + name2);
			
			System.out.println("Enter a rate");
			double d1 = scan.nextDouble();
			System.out.println("Double :" + d1);
			
			Dog tim = new Dog();
			tim.dogAge = 3;
			tim.dogSize = 30.5;
			
			String txtnum = "66.5";
			double n2 =Double.valueOf(txtnum);
			System.out.println((int)n2);
	}

}