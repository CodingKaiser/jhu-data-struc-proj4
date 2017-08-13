public class ArrayOperations {

  public static int[] makeCopy(int[] x) {
    int[] copy = new int[x.length];
    for (int i = 0; i < x.length; i++) {
      copy[i] = x[i];
    }
    return copy;
  }

  public static void printContents(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }

  public static void printContentsDetail(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print((i + 1) + ": " + x[i] + ", ");
    }
    System.out.println();
  }

  public static void exchangeElements(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
