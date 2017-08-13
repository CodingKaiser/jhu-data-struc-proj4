import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateIntData {
  public static void main(String[] args) {
    File inputDir = new File("input/ran25K.dat"); // will hold the input

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(inputDir));
//      makeAscending(25000, bw);
//      makeDescending(25000, bw);
      makeRandom(25000, bw);
      bw.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  public static void makeAscending(int size, BufferedWriter bw) throws IOException {
    for (int i = 1; i <= size; i++) {
      bw.write(String.valueOf(i));
      bw.newLine();
    }
  }

  public static void makeDescending(int size, BufferedWriter bw) throws IOException {
    for (int i = size; i >= 1; i--) {
      bw.write(String.valueOf(i));
      bw.newLine();
    }
  }

  public static void makeRandom(int size, BufferedWriter bw) throws IOException {
    int[] something = new int[size];
    for (int i = 1; i <= size; i++) {
      something[i-1] = i;
    }
    for (int i = 0; i < size * size; i++) {
      int randIndex1 = (int) (Math.random() * size);
      int randIndex2 = (int) (Math.random() * size);
      ArrayOperations.exchangeElements(something, randIndex1, randIndex2);
    }
    for (int i = 0; i < something.length; i++) {
      bw.write(String.valueOf(something[i]));
      bw.newLine();
    }
  }
}
