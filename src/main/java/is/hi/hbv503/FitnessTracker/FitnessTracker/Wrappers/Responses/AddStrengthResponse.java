package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Strength;
import java.util.List;

public class AddStrengthResponse extends GenericResponse {
    private Strength strength;

    public AddStrengthResponse() { }

    public AddStrengthResponse(Strength strength) {
        this.strength = strength;
    }

    public AddStrengthResponse(String message, List<?> errors) {
        this(null, message, errors);
    }
    public AddStrengthResponse(Strength strength, String message, List<?> errors) {
        super(message, errors);
        this.strength = strength;
    }


    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }
}
