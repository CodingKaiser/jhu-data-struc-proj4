public class ShellSort {

  private static final int[] SEQ1 = new int[]{1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341};
  private static final int[] SEQ2 = new int[]{1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160};
  private static final int[] SEQ3 = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147};


  public static void sort(int[] toBeSorted) {
    int[][] partitions = makePartitionsArray(toBeSorted);
    ArrayOperations.printContents(partitions[0]);
    for (int[] partition : partitions) {
      AverageTimer at = new AverageTimer();
      for (int i = 0; i < 7; i ++) {
        int[] copy = ArrayOperations.makeCopy(toBeSorted);
        at.startTimer();
        shellSort(copy, partition);
        at.stopTimer();
        if (copy.length <= 50 && i == 0) {
          ArrayOperations.printContents(copy);
        }
      }
      System.out.println("Time elapsed: " + at.getAverage());
    }
  }

  private static int[][] makePartitionsArray(int[] arr) {
    int[][] partitions = new int[4][];
    int[] knuthSequence = makeKnuthSequence(arr);
    int[] seq1 = makeSequence(arr, SEQ1);
    int[] seq2 = makeSequence(arr, SEQ2);
    int[] seq3 = makeSequence(arr, SEQ3);
    partitions[0] = knuthSequence;
    partitions[1] = seq1;
    partitions[2] = seq2;
    partitions[3] = seq3;
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
    ArrayOperations.printContents(partition);
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
