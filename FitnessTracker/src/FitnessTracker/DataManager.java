package FitnessTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String WORKOUTS_FILE = "data/workouts.csv";
    private static final String BODYWEIGHT_FILE = "data/bodyweight.csv";

    public void addWorkout(Exercise exercise) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORKOUTS_FILE, true))) {
            writer.write(exercise.getName() + "," + exercise.getWeight());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving workout: " + e.getMessage());
        }
    }
    

    public List<Exercise> getWorkouts(String exerciseName) {
        List<Exercise> workouts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(WORKOUTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(exerciseName)) {
                    workouts.add(new Exercise(parts[0], Double.parseDouble(parts[1]), 0, 0));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading workouts: " + e.getMessage());
        }
        return workouts;
    }
    
    public void addWeight(Weight weight) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(BODYWEIGHT_FILE, true))) {
            writer.write(Double.toString(weight.getWeight())); 
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving body weight: " + e.getMessage());
        }
    }
    
    public List<Weight> getAllBodyWeights(){
    	List<Weight> weights = new ArrayList<>();
    	try (BufferedReader reader = new BufferedReader(new FileReader(BODYWEIGHT_FILE))) {
    		String line;
            while ((line = reader.readLine()) != null) {
                double weightValue = Double.parseDouble(line);
                weights.add(new Weight(weightValue));
            }
        } catch (IOException e) {
            System.out.println("Error reading body weights: " + e.getMessage());
        }
        return weights;
    }
}
