import java.util.Random;

/**
 * ProcessGenerator generates new Process objects
 * using a pseudo random number generator for certain
 * attributes.
 *
 * @author Benjamin Warner
 *
 * @param double - the probability to use for querying
 */

public class ProcessGenerator {
    private double probability;
    private Random random;

    /**
     * Create a new ProcessGenerator with probability.
     */
    public ProcessGenerator(double probability) {
        this.probability = probability;
        this.random = new Random();
    }

    /**
     * Check to see if the next random double is less than probability.
     *
     * @return boolean
     */
    public boolean query() {
        return this.random.nextDouble() < this.probability;
    }

    /**
     * Create a new ProcessObject.
     * Uses random integers for timeToFinish and priority.
     *
     * @param int - the current time
     * @param int - maximum amount of time to let the process run
     * @param int - the maximum priority the process can be
     *
     * @return Process
     */
    public Process getNewProcess(int currentTime, int maximumProcessTime, int maximumPriorityLevel) {
        int timeToFinish = this.random.nextInt(maximumProcessTime);
        int priority = this.random.nextInt(maximumPriorityLevel);
        return new Process(currentTime, priority, timeToFinish, maximumPriorityLevel);
    }

    /**
     * Setter for the probability instance variable.
     * This function does nothing because it's not needed.
     * Required for the assignment.
     *
     * @param double - the new probability
     */
    private void setProbability(double probability) {
        
    }
}
