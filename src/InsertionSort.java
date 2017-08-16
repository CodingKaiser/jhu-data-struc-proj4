import java.io.BufferedWriter;
import java.io.IOException;

public class InsertionSort {

  static void sort(int[] toBeSorted, BufferedWriter bw) {
    try {
      if (toBeSorted.length == 50) {
        bw.write("Sorting with InsertionSort...");
        bw.newLine();
      }
      int numRepeats = 20;
      AverageTimer at = new AverageTimer();
      for (int i = 0; i < numRepeats; i ++) {
        int[] copy = ArrayOperations.makeCopy(toBeSorted);
        at.startTimer();
        insertionSort(copy);
        at.stopTimer();
        if (toBeSorted.length == 50 && i == 0) {
          bw.write("Sorted result: ");
          ArrayOperations.writeContents(copy, bw);
        }
      }
      if (toBeSorted.length == 50) {
        bw.write("Time elapsed: " + at.getAverage() + " nsec");
        bw.newLine();
        bw.newLine();
        bw.newLine();
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  private static void insertionSort(int[] toBeSorted) {
    for (int j = 0; j < toBeSorted.length; j+=1) {
      int curr = j + 1;
      while (curr > 0 && curr < toBeSorted.length && toBeSorted[curr] < toBeSorted[curr - 1]) {
        ArrayOperations.exchangeElements(toBeSorted, curr, curr - 1);
        curr -= 1;
      }
    }
  }
}
