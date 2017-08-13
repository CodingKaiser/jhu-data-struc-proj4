/**
 * Created by falko on 10-08-17.
 */
public class HeapSort {
  public static void sort(int[] toBeSorted) {
    int[] result  = new int[toBeSorted.length];
    Long startTime = System.nanoTime();
    buildHeap(toBeSorted);
    getSortedSeq(toBeSorted, result);
    System.out.println("Time elapsed: " + (System.nanoTime() - startTime));
    if (toBeSorted.length <= 50) ArrayOperations.printContents(result);
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
