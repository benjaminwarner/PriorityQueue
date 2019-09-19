/**
 * This class models a CPU process.
 *
 * @author Benjamin Warner
 *
 * @param int - the arrival time of the process
 * @param int - the priority for the process
 * @param int - the amount of time it'll take for the process to finish
 * @param int - the maximum priority for the process
 */

public class Process {
    private int priorityLevel;
    private int timeToFinish;
    private int timeNotProcessed;
    private int arrivalTime;
    private int maxPriorityLevel;

    /**
     * Create a new Process object
     */
    public Process(int arrivalTime, int priorityLevel, int timeToFinish, int maxPriorityLevel) {
        this.arrivalTime = arrivalTime;
        this.priorityLevel = priorityLevel;
        this.timeToFinish = timeToFinish;
        this.maxPriorityLevel = maxPriorityLevel;
        this.timeNotProcessed = 0;
    }

    /**
     * Decrement timeToFinish by one.
     */
    public void reduceTimeRemaining() {
        if (this.timeToFinish == 0)
            return;
        this.timeToFinish--;
    }

    /**
     * Increment timeNotProcessed by one.
     */
    public void incrementTimeNotProcessed() {
        this.timeNotProcessed++;
    }

    /**
     * Getter for timeNotProcessed instance variable.
     *
     * @return int
     */
    public int getTimeNotProcessed() {
        return this.timeNotProcessed;
    }

    /**
     * Getter for timeToFinish instance variable.
     *
     * @return int
     */
    public int getTimeRemaining() {
        return this.timeToFinish;
    }

    /**
     * Determine if the process has finished or not.
     * 
     * A process has finished if the timeToFinish has been reduced to 0.
     * @return boolean
     */
    public boolean done() {
        return this.timeToFinish == 0;
    }

    /**
     * Getter for arrivalTime instance variable.
     *
     * @return int
     */
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Getter for priorityLevel instance variable.
     *
     * @return int
     */
    public int getPriority() {
        return this.priorityLevel;
    }

    /**
     * Increment the priorityLevel by one.
     * If the priorityLevel is at the max, do nothing.
     */
    public void incrementPriority() {
        if (this.priorityLevel == this.maxPriorityLevel)
            return;
        this.priorityLevel++;
    }

    /**
     * Reset the timeNotProcessed instance variable to 0.
     */
    public void resetTimeNotProcessed() {
        this.timeNotProcessed = 0;
    }

    /**
     * Set the priorityLevel to level.
     * If the level provided is greater than max, do nothing.
     *
     * @param int
     */
    private void setPriorityLevel(int level) {
        if (level > this.maxPriorityLevel)
            return;
        this.priorityLevel = level;
    }

    /**
     * Getter for the timeToFinish instance variable.
     *
     * @return int
     */
    public int getTimeToFinish() {
        return this.timeToFinish;
    }

    /**
     * Set the timeToFinish to time. If time is less than 0, do nothing.
     *
     * @param int - new amount of time it'll take to finish
     */
    private void setTimeToFinish(int time) {
        if (time < 0)
            return;
        this.timeToFinish = time;
    }

    /**
     * Set the timeNotProcessed to time. If time is less than 0, do nothing.
     *
     * @param int - new amount of time the process hasn't processed
     */
    private void setTimeNotProcessed(int time) {
        if (time < 0)
	    return;
        this.timeNotProcessed = time;
    }

    /**
     * Set the arrivalTime to time. Function does nothing
     * because this shouldn't change, and the variable
     * is private. Here because the assignment requires it.
     *
     * @param int - new arrival time
     */
    private void setArrivalTime(int time) {
    }

    /**
     * Getter for the maxPriorityLevel instance variable.
     *
     * @return int
     */
    public int getMaxPriorityLevel() {
        return this.maxPriorityLevel;
    }

    /**
     * Setter for the maxPriorityLevel instance variable.
     * If the current priorityLevel is greater than the new
     * max, set the priorityLevel to the new max.
     *
     * @param int - the new maximum for the processes priority
     */
    public void setMaxPriorityLevel(int level) {
        this.maxPriorityLevel = level;
        if (this.priorityLevel > this.getMaxPriorityLevel())
            this.priorityLevel = level;
    }
}
