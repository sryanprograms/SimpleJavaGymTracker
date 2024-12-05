package FitnessTracker;

import java.util.List;

public class ProgressCalculator {
    private DataManager dataManager = new DataManager();

    public double calculateProgress(String exerciseName) {
        List<Exercise> workouts = dataManager.getWorkouts(exerciseName);
        if (workouts.isEmpty()) {
            System.out.println("No workouts found for " + exerciseName);
            return 0.0;
        }
        
        double initialWeight = workouts.get(0).getWeight();
        double latestWeight = workouts.get(workouts.size() - 1).getWeight();
        return ((latestWeight - initialWeight) / initialWeight) * 100;
    }
}

