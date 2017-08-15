import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by falko on 10-08-17.
 */
public class HeapSort {
  public static void sort(int[] toBeSorted, BufferedWriter bw) {
    try {
      if (toBeSorted.length == 50) {
        bw.write("Sorting with HeapSort...");
        bw.newLine();
      }
      int[] result  = new int[toBeSorted.length];
      int numRepeats = 20;
      AverageTimer at = new AverageTimer();
      for (int i = 0; i < numRepeats; i++) {
        at.startTimer();
        buildHeap(toBeSorted);
        getSortedSeq(toBeSorted, result);
        at.stopTimer();
        if (toBeSorted.length == 50 && i == 0) {
          bw.write("Sorted result: ");
          ArrayOperations.writeContents(result, bw);
        }
      }
      if (toBeSorted.length == 50) {
        bw.write("Time elapsed: " + at.getAverage() + " nsec");
        bw.newLine();
        bw.newLine();
      }
    } catch (IOException e) {

    }
  }

  public static void buildHeap(int[] toBeSorted) {
    int partitionEdge = 1;
    while (partitionEdge < toBeSorted.length) {
      int currIndex = partitionEdge;
      while (currIndex > 0 && toBeSorted[currIndex] > toBeSorted[(currIndex - 1) / 2]) {
        ArrayOperations.exchangeElements(toBeSorted, currIndex, (currIndex - 1)/2);
        currIndex = (currIndex - 1) / 2;
      }
      partitionEdge++;
    }
  }

  public static void getSortedSeq(int[] heap, int[] result) {
    int partitionEdge = heap.length - 1;
    while (partitionEdge >= 0) {
      result[partitionEdge] = heap[0];
      ArrayOperations.exchangeElements(heap, 0, partitionEdge);
      int currIndex = 0;
      while ((currIndex * 2) + 1 < partitionEdge) {
        int whichChild = 0;
        if (currIndex * 2 + 2 < partitionEdge &&
            heap[currIndex * 2 + 1] < heap[currIndex * 2 + 2]) {
          whichChild = 1;
        }
        if (heap[currIndex] < heap[currIndex * 2 + 1 + whichChild]) {
          ArrayOperations.exchangeElements(heap, currIndex, currIndex * 2 + 1 + whichChild);
        } else {
          currIndex = partitionEdge;
        }
        currIndex = currIndex * 2 + 1 + whichChild;
      }
      partitionEdge--;
    }
  }
}
