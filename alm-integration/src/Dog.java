public class Dog {

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

  public void setAge(int age) {
    if (age >= 0) {
      dogAge = age;
    } else
      dogAge = 0;
  }

  public void setName(String name) {
    dogName = name;
  }

  public Dog() {
    
  }
  public Dog(double s) {
    
  }
  
  
}
