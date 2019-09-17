import java.util.Random;

public class ProcessGenerator {
    private double probability;
    private Random random;

    public ProcessGenerator(double probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public boolean query() {
        return this.random.nextDouble() < this.probability;
    }

    public Process getNewProcess(int currentTime, int maximumProcessTime, int maximumPriorityLevel) {
        int timeToFinish = this.random.nextInt(maximumProcessTime);
        int priority = this.random.nextInt(maximumPriorityLevel);
        return new Process(currentTime, priority, timeToFinish, maximumPriorityLevel);
    }

    private void setProbability(double probability) {
        
    }
}
