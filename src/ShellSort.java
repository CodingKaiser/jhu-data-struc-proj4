public class ShellSort {

  

  public static void sort(int[] toBeSorted) {
    System.out.print(toBeSorted.length + " has Knuth sequence: ");
    int[][] partitions = new int[][]{makePartitionsArray(toBeSorted)};
    ArrayOperations.printContents(partitions[0]);
    for (int[] partition : partitions) {
      int[] copy = ArrayOperations.makeCopy(toBeSorted);
      shellSort(copy, partition);
    }
  }

  private static int[] makePartitionsArray(int[] arr) {
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

  private static void shellSort(int[] input, int[] partition) {
    Long startTime = System.nanoTime();
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
    System.out.println("Time elapsed: " + (System.nanoTime() - startTime));
    if (input.length <= 50) {
      ArrayOperations.printContents(input);
    }
  }
}
