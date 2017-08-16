import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class wi
 */
public class ShellSort {

  private static final int[] SEQ1 = new int[]{1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341};
  private static final int[] SEQ2 = new int[]{1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160};
  private static final int[] SEQ3 = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147};
  private static final int[] SEQ4 = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};


  public static void sort(int[] toBeSorted, BufferedWriter bw) {
    try {
      if (toBeSorted.length == 50) {
        bw.write("Sorting with ShellSort...");
        bw.newLine();
        bw.newLine();
      }
      int[][] partitions = makePartitionsArray(toBeSorted);
      for (int[] partition : partitions) {
        if (toBeSorted.length == 50) {
          bw.write("With step sizes: ");
          ArrayOperations.writeContents(partition, bw);
        }
        int numRepeats = 20;
        AverageTimer at = new AverageTimer();
        for (int i = 0; i < numRepeats; i ++) {
          int[] copy = ArrayOperations.makeCopy(toBeSorted);
          at.startTimer();
          shellSort(copy, partition);
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
        }
      }
      if (toBeSorted.length == 50) {
        bw.newLine();
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  private static int[][] makePartitionsArray(int[] arr) {
    int[][] partitions = new int[5][];
    int[] knuthSequence = makeKnuthSequence(arr);
    int[] seq1 = makeSequence(arr, SEQ1);
    int[] seq2 = makeSequence(arr, SEQ2);
    int[] seq3 = makeSequence(arr, SEQ3);
    int[] seq4 = makeSequence(arr, SEQ4);
    partitions[0] = knuthSequence;
    partitions[1] = seq1;
    partitions[2] = seq2;
    partitions[3] = seq3;
    partitions[4] = seq4;
    return partitions;
  }

  private static int[] makeKnuthSequence(int[] arr) {
    int h = 1;
    int n = 1;
    while (h < arr.length) {
      h = h * 3 + 1;
      n++;
    }
    n -= 2;
    if (n < 1) {
      n = 1;
    }
    int[] knuthPartition = new int[n];
    h = 1;
    for (int i = n - 1; i >= 0; i--) {
      knuthPartition[i] = h;
      h = h * 3 + 1;
    }
    return knuthPartition;
  }

  private static int[] makeSequence(int[] arr, int[] sequence) {
    int size = arr.length;
    int h = 0;
    while (sequence[h] < size) {
      h++;
    }
    h -= 2;
    if (h < 0) {
      h = 0;
    }
    int[] partition = new int[h + 1];
    int n = h;
    for (int i = 0; i <= n; i++) {
      partition[i] = sequence[h];
      h--;
    }
    return partition;
  }

  private static void shellSort(int[] input, int[] partition) {
    for (int skip : partition) {
      for (int i = 0; i < skip; i++) {
        for (int j = i; j < input.length; j+=skip) {
          int curr = j + skip;
          while (curr > i && curr < input.length && input[curr] < input[curr - skip]) {
            ArrayOperations.exchangeElements(input, curr, curr - skip);
            curr -= skip;
          }
        }
      }
    }
  }
}
