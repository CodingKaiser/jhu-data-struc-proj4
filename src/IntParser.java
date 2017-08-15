/**
 * Class which provides helper methods related to detection of
 * and conversion of characters into integers.
 * @Author: Falko Noe
 * @Version: 1.0
 */
class IntParser {

  /**
   * Checks whether an int representation of a char corresponds
   * to a digit, 0-9
   * @param c: The integer corresponding to the character
   * @return A boolean. True if the character is an integer,
   * false otherwise.
   */
  static boolean isDigit(int c) {
    return (c > 47 && c < 58);
  }

  /**
   * Converts the ASCII char in int form to the actual
   * integer value that the char represents, 0-9.
   * @param c: The int representation of a char
   * @return An integer corresponding to the actual int
   * value of the character that was inputted. Conversion
   * based on ASCII 256 codes.
   */
  static int toDigit(int c) {
    return (c - 48);
  }

  /**
   * Converts a string to an integer. If the string contains
   * integers, it will add them to the final result from
   * left to right. The integer "bar43f430r0" will be
   * converted to 434300
   * @param s: The input string that we wou would like to
   *         parse into an integer. Should only contain
   *         ints, won't handle negative signs
   * @return The integer corresponding to the digits
   *         found inside of the string.
   */
  static int toInteger(String s) {
    int res = 0;
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (isDigit(c)) {
        res = res * 10 + toDigit(c);
      }
    }
    return res;
  }
}
