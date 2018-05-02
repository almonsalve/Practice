import java.util.HashMap;
import java.util.Map;

public class MenuText {
  static boolean created = false;
  static Map<String, String> def = new HashMap<String, String>();

  protected static String getDefinition(String input) {
    if (!created) {
      def.put("byte",
          "A byte holds an 8-bit integer. A byte is the smallest-sized integer"
              + " primitive data type");
      def.put("short",
          "A short holds a 16-bit integer. It is the second smallest of the"
              + " integer primitives.");
      def.put("int", "An int holds a 32-bit integer");
      def.put("long", "A long holds a 64-bit integer and is the largest"
          + " of the integer primitives");
      def.put("float", "A float holds a 32-bit floating point number,"
          + " which allows it to hold numbers with a decimal point.");
      def.put("double",
          "A double holds a 64-bit floating point number,"
              + "which can have a decimal point. This is the default primitive"
              + " for decimal values.");
      def.put("boolean",
          "A boolean holds a true/false value. It may be used for"
              + " simple flags for checking conditions");
      def.put("char", "A char holds a single UTF-16 character");
      def.put("string", "A String IS NOT a primitive data type, but a class,"
          + "as indicated by its capitalization.");
      created = true;
    }
    String definition = def.get(input.toLowerCase());
    if (definition == null) {
      return "Sorry, I could not find what you were looking for."
          + "Please select from the given terms";
    } else {
      return definition;
    }
  }
}
