import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A class of helper methods which allow for various
 * manipulations of arrays. Performs manipulations
 * such as deep copying an array, writing its contents
 * to output, and exchanging various elements.
 * @Author: Falko Noe
 * @Version: 1.0
 */
public class ArrayOperations {

  /**
   * Makes a copy of an input array by copying the int
   * values over into a new array of the same length. The input
   * array is not modified.
   * @param x: The integer array of which a copy should be made.
   * @return A deep copy of the input array. Will be identical
   */
  public static int[] makeCopy(int[] x) {
    int[] copy = new int[x.length];
    for (int i = 0; i < x.length; i++) {
      copy[i] = x[i];
    }
    return copy;
  }

  /**
   * Prints the contents of an integer array to stdout.
   * Delmits the elements by a " " character for legibility.
   * @param x: The input array of integers.
   */
  public static void printContents(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }

  /**
   * Writes the contents of an integer to a BufferedWriter object,
   * using a space character as a delimited. Will finish off the operation
   * by writing a newline character.
   * param x: The integer array the contents of which should be written
   * to stdout.
   * @param bw: The BufferedWriter object to which the contents of the
   *          array will be written.
   */
  public static void writeContents(int[] x, BufferedWriter bw) {
    try {
      for (int i = 0; i < x.length; i++) {
        bw.write(x[i] + " ");
      }
      bw.newLine();
    } catch (IOException e) {
      System.err.println("Unable to write array contents to file.");
    }
  }

  /**
   * Prints the contents of an integer array to stdout, giving
   * additional information regarding the 1-indexed index locations
   * of those elements within the array.
   * Delmits the elements by a ", " character for legibility.
   * @param x: The input array of integers.
   */
  public static void printContentsDetail(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print((i + 1) + ": " + x[i] + ", ");
    }
    System.out.println();
  }

  /**
   * A method which exchanges the elements at two locations within
   * an input array.
   * @param input: The input integer array we want to exchange the
   *             elements of
   * @param i: The index of the element we would like to swap. Must
   *         be a valid index
   * @param j: The index of the element we would like to swap with
   *         the first one. Must be a valid index
   */
  public static void exchangeElements(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
