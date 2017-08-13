public class AverageTimer {

  private int numOfTimes;
  private Long startTime;
  private Long average;

  AverageTimer() {
    numOfTimes = 0;
    average = (long) 0;
  }

  void startTimer() {
    startTime = System.nanoTime();
  }

  void stopTimer() {
    Long diff = System.nanoTime() - startTime;
//    System.out.print(diff + " ");
    average = average * numOfTimes;
    numOfTimes += 1;
    average = (average + diff) / numOfTimes;
  }

  long getAverage() {
    return average;
  }
}
