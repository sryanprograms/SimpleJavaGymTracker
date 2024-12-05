package FitnessTracker;

import java.util.List;
import java.util.Scanner;

public class FitnessTracker {
    private Scanner scanner = new Scanner(System.in);
    private DataManager dataManager = new DataManager();
    private ProgressCalculator progressCalculator = new ProgressCalculator();
    private ProgressWeightCalculator progressWeightCalculator = new ProgressWeightCalculator();

    
    public double weight; 
    public double progress;

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nFitness Tracker Menu:");
            System.out.println("1. Log Workout");
            System.out.println("2. View Workout Progress");
            System.out.println("3. Log Weight");
            System.out.println("4. View Weight Progress");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            if (choice == 1) {
            	logWorkout();
            } else if (choice == 2) {
            	viewProgress();
            } else if (choice == 3) {
            	logWeight();
            } else if (choice == 4){
            	viewWeightProgress(); 	
            } else if (choice == 5) {
            	running = false; 
            } else {
            	System.out.println("Invalid choice. Try again");
            }
            
        }
    }

    private void logWorkout() {
        System.out.println("Enter exercise name: ");
        String name = scanner.nextLine();
        System.out.println("Enter weight lifted: ");
        double weight = scanner.nextDouble();
        System.out.println("Enter number of sets: ");
        int sets = scanner.nextInt();
        System.out.println("Enter number of reps: ");
        int reps = scanner.nextInt();
        scanner.nextLine(); 

        Exercise exercise = new Exercise(name, weight, sets, reps);
        dataManager.addWorkout(exercise);
        System.out.println("Workout logged!");
    }
    
    

    private void viewProgress() {
        System.out.println("Enter exercise name to track: ");
        String name = scanner.nextLine();
        double progress = progressCalculator.calculateProgress(name);
        System.out.println("Progress for " + name + ": " + progress + "% improvement.");
    }
    
    
    private void logWeight() {
    	System.out.println("Enter current weight: ");
    	double weight = scanner.nextDouble();
    	
    	Weight userWeight = new Weight(weight);
    	dataManager.addWeight(userWeight);
    	System.out.print("Weight logged!");
    }
    
    public void viewWeightProgress() {
    	List<Weight> weights = dataManager.getAllBodyWeights();
        if (weights.isEmpty()) {
            System.out.println("No weights logged yet. Please log a weight first.");
            return;
        }

        Weight currentWeight = weights.get(weights.size() - 1);

        double progress = progressWeightCalculator.calculateWeightProgress(currentWeight);

        if (progress != 0.0) {
            System.out.println("Your weight since last time has seen a " + progress + "% change.");
        }
    }
    
    
    
    
    
    	
}
