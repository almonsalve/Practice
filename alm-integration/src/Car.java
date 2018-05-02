
public class Car {
  
  private int speed;
  private String make;

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public int getSpeed() {
    return speed;
  }

  public String getMake() {
    return make;
  }

  public Car(String m) {
    speed = 0;
    make = m;
  }
  
  public Car() {
    speed = 0;
    make = "unknown";
  }
  
  public void printDetails() {
    System.out.println("Speed: " + speed + " mph");
    System.out.println("Make: " + make);
  }
}
