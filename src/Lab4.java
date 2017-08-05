import java.io.*;

/**
 * Main driver and entry point into the application. Reads the input
 * matrices and calculates the corresponding determinant.
 * Writes the matrix and the calculated value to output.
 * This application must be called
 * from the command line with valid input/output file paths
 * as arguments.
 * @Author Falko Noe
 * @Version 1.0
 */
public class Lab4 {

  /**
   * The main entry point to the class. Will be called when the
   * user runs this program from the command-line.
   * @param args An array holding the two command-line arguments. The
   *             first argument is the input file in text format. The
   *             second argument is the path to the output text file.
   *             Both arguments must be valid paths.
   */
  public static void main(String[] args) {

    BufferedReader input; // will hold the input
    BufferedWriter output; // will hold the output
    Lab4 lab;

    if (args.length != 2) {
      System.err.println("Usage:  java Lab3 [input file pathname]" +
              " [output file pathname]");
      System.exit(1);
    }

    try {
      input = new BufferedReader(new FileReader(args[0]));
      output = new BufferedWriter(new FileWriter(args[1]));
    } catch (IOException e) {
      System.err.println("Make sure the input/output path is correct.");
      return;
    }

    lab = new Lab4();

    try {
      /* Close the input and output, writes file output,
       * and exit the application */
      input.close();
      output.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
