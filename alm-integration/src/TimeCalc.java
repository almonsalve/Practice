public class TimeCalc {
  public static String calculateTime(int timeInput) {
    String time = "";
    int hourInput = timeInput / 100;
    int minInput = timeInput % 100;
    int ampm = 0;
    int hours;
    String minutes;
    String timeSuffix;
    if (minInput > 59) {
      return "Invalid time.";
    }
    if (hourInput >= 13) {
      hours = hourInput % 12;
      ampm = (hourInput / 12) % 2;
    } else {
      hours = hourInput;
    }
    if (hours == 0) {
      hours = 12;
    }
    if (ampm == 1) {
      timeSuffix = "PM";
    } else {
      timeSuffix = "AM";
    }
    if(minInput >= 10) {
      minutes = "" + minInput;
    } else {
      minutes = "0" + minInput;
    }

    time = hours + ":" + minutes + timeSuffix;
    
    return time;
  }
}
