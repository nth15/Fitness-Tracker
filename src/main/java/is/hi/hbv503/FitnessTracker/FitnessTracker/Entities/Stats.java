package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;

public class Stats{

    public Stats() { }

    private ExerciseService exerciseService;

    public double getTotalTime(int size){
        int totalTime = 0;

        for (int i = 0; i < size; i++) {
            totalTime += exerciseService.findAll().get(i).getDuration();
        }
        System.out.println("Total time spent: " +  totalTime);
        return totalTime;
    }
}