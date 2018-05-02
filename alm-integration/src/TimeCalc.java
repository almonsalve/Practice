import java.util.Date;

// Utilizes % and /
/**
 * A class for calculating time values.
 * 
 * @author Ariana Monsalve
 *
 */

public class TimeCalc {
  /**
   * Converts a 24-hour time to a 12-hour time with an AM or PM suffix.
   * 
   * @param timeInput
   *          Time in 24-hour military time.
   * @return The converted time.
   */
  public static String calculateTime(int timeInput) {
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
    if (minInput >= 10) {
      minutes = "" + minInput;
    } else {
      minutes = "0" + minInput;
    }
    String time = "";
    time = hours + ":" + minutes + timeSuffix;

    return time;
  }

  public static String currentTime() {
    Date date = new Date(System.currentTimeMillis());
    return date.toString();
  }
}
