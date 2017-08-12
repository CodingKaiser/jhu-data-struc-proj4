/**
 * Created by falko on 10-08-17.
 */
public class HeapSort {
  public static void sort(int[] toBeSorted) {
    buildHeap(toBeSorted);
    getSortedSeq(toBeSorted);
  }

  public static void buildHeap(int[] toBeSorted) {
    int partitionEdge = 2;
    while (partitionEdge < toBeSorted.length) {
      int currIndex = partitionEdge;
      while (toBeSorted[currIndex - 1] > toBeSorted[(currIndex - 1)/2]) {
        ArrayOperations.exchangeElements(toBeSorted, currIndex - 1, (currIndex - 1)/2);
        currIndex /= 2;
      }
      partitionEdge++;
    }
  }

  public static void getSortedSeq(int[] heap) {

  }
}
