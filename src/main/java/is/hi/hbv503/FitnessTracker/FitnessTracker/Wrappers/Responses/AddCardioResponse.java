package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Cardio;
import java.util.List;

public class AddCardioResponse extends GenericResponse {
    private Cardio cardio;

    public AddCardioResponse() { }

    public AddCardioResponse(Cardio cardio) {
        this.cardio = cardio;
    }

    public AddCardioResponse(String message, List<?> errors) {
        this(null, message, errors);
    }
    public AddCardioResponse(Cardio cardio, String message, List<?> errors) {
        super(message, errors);
        this.cardio = cardio;
    }


    public Cardio getCardio() {
        return cardio;
    }

    public void setCardio(Cardio cardio) {
        this.cardio = cardio;
    }
}
