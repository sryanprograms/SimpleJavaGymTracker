package FitnessTracker;

import java.util.List;

public class ProgressWeightCalculator {
	private DataManager dataManager = new DataManager();

	public double calculateWeightProgress(Weight currentWeight) {
        List<Weight> weights = dataManager.getAllBodyWeights();

        if (weights.isEmpty()) {
            System.out.println("No body weight data found. Progress cannot be calculated.");
            return 0.0;
        }

        if (weights.size() == 1) {
            System.out.println("Not enough data to calculate progress. Please log more weights.");
            return 0.0;
        }

        double previousWeight = weights.get(weights.size() - 2).getWeight(); 
        double latestWeight = currentWeight.getWeight();

        return ((latestWeight - previousWeight) / previousWeight) * 100;
    }
}
