package FitnessTracker;

import java.util.ArrayList;

public class Workout {
	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	
	public void addExercise(Exercise inputExercise) {
		exercises.add(inputExercise);
	}
	
	public void getExercises(){
		Exercise output = null;
		for(int i = 0; i < exercises.size(); i++) {
			output = exercises.get(i);
		}
		
		System.out.print(output);
	}
}

