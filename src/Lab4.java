import java.io.*;

/**
 * Main driver and entry point into the application. Reads the input,
 * which should be files containing some quantity of integers, and
 * sorts those files using ShellSort and HeapSort. The amount of
 * time that it takes to complete each sort is recorded and
 * outputted in an output file.
 * @Author Falko Noe
 * @Version 1.0
 */
public class Lab4 {

  /**
   * The main entry point to the class. Will be called when the
   * user runs this program from the command-line.
   * @param args An array holding the two command-line arguments. The
   *             first argument is the path to the folder containing
   *             the input second argument is the path to the output
   *             text file. Both arguments must be valid paths.
   */
  public static void main(String[] args) {

    File inputDir; // will hold the input
    File outputFile; // will hold the output
    BufferedWriter bw; // will write output

    if (args.length != 2) {
      System.err.println("Usage:  java Lab4 [input files pathname]" +
          "[output file pathname");
      System.exit(1);
    }

    inputDir = new File(args[0]);
    if (!inputDir.isDirectory()) {
      System.err.println("Pathname is not a directory");
      System.exit(1);
    }

    outputFile = new File(args[1]);
    try {
      bw = new BufferedWriter(new FileWriter(outputFile));
    } catch (IOException e) {
      System.err.println("Output file path invalid.");
      return;
    }

    // Iterate through each file, parse it for ints, and sort
    for (File x : inputDir.listFiles()) {
      parseFile(x, bw);
    }

    try {
      bw.close();
    } catch (IOException e) {
      System.err.println("Error closing file");
    }
  }

  /**
   * Takes the input File, parses it for ints, loads the ints into an
   * array, and then passes that array on to the respective Sorts
   * @param f: The File object corresponding to the file currently being
   *         parsed for input.
   * @param bw: The BufferedWriter object that will write all of the
   *          output to the output file.
   */
  private static void parseFile(File f, BufferedWriter bw) {
    int numOfEntries =
        parseNameForExpectedSize(f.getName().toCharArray());
    int[] input = new int[numOfEntries];
    try {
      int currChar;
      char c;
      int curr = 0;
      int i = 0;
      bw.write("*********************************************");
      bw.newLine();
      bw.write("Sorting file: " + f.getName());
      bw.newLine();
      bw.write("Length of file: " + numOfEntries);
      bw.newLine();
      bw.newLine();
      BufferedReader br = new BufferedReader(new FileReader(f));
      while (((currChar = br.read()) != -1)) {
        c = (char) currChar;
        if (c == ' ') {
          throw new IOException("Encountered whitespace in file: " +
              f.getName() + ". Skipping file");
        } else if (IntParser.isDigit(c)) {
          if (curr == 0) {
            curr = IntParser.toDigit(c);
          } else {
            curr = curr * 10 + IntParser.toDigit(c);
          }
        } else if (c == '\r' || c == '\n') {
          input[i] = curr;
          curr = 0;
          i++;
          if (c == '\r') {
            br.read();
          }
        } else {
          throw new IOException("Invalid character. Digits only, please");
        }
      }
      br.close();
    } catch (IOException e) {
      System.err.println(e);
    }

    ShellSort.sort(input, bw);
    HeapSort.sort(input, bw);

  }

  /**
   * Method which
   * @param name
   * @return
   */
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
