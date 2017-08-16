/**
 * A tool which allows the user to perform multiple timings
 * and then get the average time of those splits. Used in
 * sorting algorithms to get multiple readings from the
 * same sort and therefore get more accurate data.
 * @Author: Falko Noe
 * @Version: 1.0
 */
public class AverageTimer {

  private int numOfTimes;
  private Long startTime;
  private Long average;

  /**
   * Constructor. Sets initial value of
   * average and numOfTimes to 0 since no
   * timings have been performed
   */
  AverageTimer() {
    numOfTimes = 0;
    average = (long) 0;
  }

  /**
   * Reassigns the startTime to the current system
   * time in nanoseconds. Effectively resetting the
   * timer to 0
   */
  void startTimer() {
    startTime = System.nanoTime();
  }

  /**
   * Stops the timer and calculates the amount of time that
   * has passed since the timer was stopped. Calculates the
   * average time of this split and the previous ones.
   */
  void stopTimer() {
    Long diff = System.nanoTime() - startTime;
    average = average * numOfTimes; // Get sum of previous splits
    numOfTimes += 1;
    average = (average + diff) / numOfTimes; // Add split to sum and avg
  }

  /**
   * Gets the average time of the splits performed thus far
   * @return A Long respresenting the average split time. Subject
   *         to rounding errors resulting from long division.
   */
  long getAverage() {
    return average;
  }
}
