import java.io.*;

/**
 * Main driver and entry point into the application. Reads the input,
 * process
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

    File inputDir; // will hold the input

    if (args.length != 1) {
      System.err.println("Usage:  java Lab4 [input files pathname]");
      System.exit(1);
    }

    inputDir = new File(args[0]);
    if (!inputDir.isDirectory()) {
      System.err.println("Pathname is invalid");
      System.exit(1);
    }

    for (File x : inputDir.listFiles()) {
      System.out.println("Sorting file: " + x.getName());
      parseFile(x);
    }
//
//    try {
//      input = new BufferedReader(new FileReader(args[0]));
//      output = new BufferedWriter(new FileWriter(args[1]));
//    } catch (IOException e) {
//      System.err.println("Make sure the input/output path is correct.");
//      return;
//    }
//
//    lab = new Lab4();
//
//    try {
//      /* Close the input and output, writes file output,
//       * and exit the application */
//      input.close();
//      output.close();
//    } catch (IOException e) {
//      System.err.println(e);
//    }
  }

  private static void parseFile(File f) {
    int numOfEntries = parseNameForExpectedSize(f.getName().toCharArray());
    System.out.println(numOfEntries);
  }

  private static int parseNameForExpectedSize(char[] name) {
    int num = 0;
    for (char c : name) {
      if (IntParser.isDigit(c)) {
        if (num == 0) {
          num = IntParser.toDigit(c);
        } else {
          num = num * 10 + IntParser.toDigit(c);
        }
      } else if (c == 'k' || c == 'K') {
        num *= 1000;
      } else if (c == '.') {
        return num;
      }
    }
    return num;
  }
}
