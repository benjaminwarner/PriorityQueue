public class Process {
    private int priorityLevel;
    private int timeToFinish;
    private int timeNotProcessed;
    private int arrivalTime;
    private int maxPriorityLevel;

    public Process(int arrivalTime, int priorityLevel, int timeToFinish, int maxPriorityLevel) {
        this.arrivalTime = arrivalTime;
        this.priorityLevel = priorityLevel;
        this.timeToFinish = timeToFinish;
        this.maxPriorityLevel = maxPriorityLevel;
        this.timeNotProcessed = 0;
    }

    public void reduceTimeRemaining() {
        if (this.timeToFinish == 0)
            return;
        this.timeToFinish--;
    }

    public void incrementTimeNotProcessed() {
        this.timeNotProcessed++;
    }

    public int getTimeNotProcessed() {
        return this.timeNotProcessed;
    }

    public int getTimeRemaining() {
        return this.timeToFinish;
    }

    public boolean done() {
        return this.timeToFinish == 0;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getPriority() {
        return this.priorityLevel;
    }

    public void incrementPriority() {
        if (this.priorityLevel == this.maxPriorityLevel)
            return;
        this.priorityLevel++;
    }

    public void resetTimeNotProcessed() {
        this.timeNotProcessed = 0;
    }

    private void setPriorityLevel(int level) {
        if (level > this.maxPriorityLevel)
            return;
        this.priorityLevel = level;
    }

    public int getTimeToFinish() {
        return this.timeToFinish;
    }

    private void setTimeToFinish(int time) {
        if (time < 0)
            return;
        this.timeToFinish = time;
    }

    private void setTimeNotProcessed(int time) {
        this.timeNotProcessed = time;
    }

    private void setArrivalTime(int time) {
        // why would this ever change??
    }

    public int getMaxPriorityLevel() {
        return this.maxPriorityLevel;
    }

    public void setMaxPriorityLevel(int level) {
        this.maxPriorityLevel = level;
        if (this.priorityLevel > this.getMaxPriorityLevel())
            this.priorityLevel = level;
    }
}