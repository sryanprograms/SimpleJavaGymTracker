package FitnessTracker;

public class Exercise {
    private String name;
    private double weight;
    private int reps;
    private int sets; 
    
    public Exercise(String name, double weight, int reps, int sets){
    	this.name = name;
    	this.weight = weight;
    	this.reps = reps;
    	this.sets = sets; 
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String inputName) {
    	name = inputName; 
    }
    
    public double getWeight() {
    	return weight;
    }
    
    public void setWeight(double inputWeight) {
    	weight = inputWeight;
    }
    
    public int getReps() {
    	return reps;
    }
    
    public void setReps(int inputReps) {
    	reps = inputReps;
    }
    
    public int getSet() {
    	return sets;
    }
    
    public void setSets(int inputSets) {
    	sets = inputSets; 
    }
}

