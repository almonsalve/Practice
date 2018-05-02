/**
 * A demonstration of overloaded constructors and general instance class
 * structure.
 * 
 * @author Ariana Monsalve
 *
 */
public class Dog {
  // PSI 1: Create Java classes and use object references
  // PSI 2: Encapsulate a class using access modifiers and overloaded
  // constructors

  private double dogSize;
  private int dogAge;
  private String dogName;

  // Accessors
  public double getSize() {
    return dogSize;
  }

  public int getAge() {
    return dogAge;
  }

  public String getName() {
    return dogName;
  }

  // Mutators
  public void setSize(double size) {
    dogSize = size;
  }

  /**
   * Sets the age. If the given age is less than 0, the age is set to 0.
   * 
   * @param age
   *          The given age as an integer.
   */
  public void setAge(int age) {
    if (age > 0) {
      dogAge = age;
    } else {
      dogAge = 0;
    }
  }

  public void setName(String name) {
    dogName = name.substring(0, 1).toUpperCase()
        + name.substring(1).toLowerCase();
  }

  public Dog() {
    this(0.0, 0, "");
  }

  public Dog(double size) {
    this(size, 0, "");
  }

  public Dog(String name) {
    this(0.0, 0, "name");
  }

  /**
   * Constructs a Dog object given its size, name, and age.
   * 
   * @param size
   *          The height of the dog in centimeters.
   * @param age
   *          The age in years.
   * @param name
   *          The name of the dog.
   */
  public Dog(double size, int age, String name) {
    dogSize = size;
    if (age >= 0) {
      dogAge = age;
    } else {
      dogAge = 0;
    }
    if (name.length() > 1) {
      dogName = name.substring(0, 1).toUpperCase()
          + name.substring(1).toLowerCase();
    } else {
      dogName = name;
    }
  }

}
