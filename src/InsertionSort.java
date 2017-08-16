import java.io.BufferedWriter;
import java.io.IOException;

/**
 * InsertionSort static class. Allows the user to sort an int array
 * of any size using InsertionSort. User should expect O(n^2) time
 * in worst case and O(n) in best case. Results of the sort are
 * written to out using a BufferedWriter object provided by the
 * user.
 * @Author: Falko Noe
 * @Version: 1.0
 */
public class InsertionSort {

  /**
   * Main entry-point to the Sort. Sets up the timer, and iterate
   * @param toBeSorted: The int array to be sorted
   * @param bw: The BufferedWriter object which will contain all of the
   *          output. Program will write sorted result and time here.
   */
  static void sort(int[] toBeSorted, BufferedWriter bw) {
    try {
      if (toBeSorted.length == 50) {
        bw.write("Sorting with InsertionSort...");
        bw.newLine();
      }
      /* Define how many times we want to do the sort
       * Higher repeats increase accuracy but take
       * longer */
      int numRepeats = 10; // Less than other sorts to save time
      AverageTimer at = new AverageTimer();
      for (int i = 0; i < numRepeats; i ++) {
        // Make copy so sort starts fresh every time
        int[] copy = ArrayOperations.makeCopy(toBeSorted);
        at.startTimer();
        insertionSort(copy);
        at.stopTimer(); // store result
        if (toBeSorted.length == 50 && i == 0) {
          // Write results of the sort only once
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

  /**
   * Performs the actual sort. Does so in-place, i.e.
   * will modify the initial array and does not produce
   * any output.
   * @param toBeSorted: The int array to be sorted.
   */
  private static void insertionSort(int[] toBeSorted) {
    for (int j = 0; j < toBeSorted.length; j+=1) {
      int curr = j + 1; // Compare item after j with j
      while (curr > 0 && curr < toBeSorted.length &&
          toBeSorted[curr] < toBeSorted[curr - 1]) {
        ArrayOperations.exchangeElements(toBeSorted, curr, curr - 1);
        curr -= 1;
      }
    }
  }
}
