package seedu.healthmate;

public class HealthGoal {

    private static final String WEIGHT_LOSS = "WEIGHT_LOSS";
    private static final String STEADY_STATE = "STEADY_STATE";
    private static final String BULKING = "BULKING";

    private static final double weightLossModifier = 0.7;
    private static final double steadyStateModifier = 1.1;
    private static final double bulkingModifier = 1.5;

    private String currentHealthGoal;

    public HealthGoal(String healthGoalInput) {
        saveHealthGoal(healthGoalInput);
    }

    public void saveHealthGoal(String healthGoalInput) {
        switch (healthGoalInput) {
        case WEIGHT_LOSS:
            currentHealthGoal = WEIGHT_LOSS;
            return;
        case STEADY_STATE:
            currentHealthGoal = STEADY_STATE;
            return;
        case BULKING:
            currentHealthGoal = BULKING;
            return;
        default:
            // If healthGoalInput is invalid
            UI.printReply("Invalid Health Goal", "Save Health Goal Error: ");
        }
    }

    public String getCurrentHealthGoal() {
        return currentHealthGoal;
    }

    public double getTargetCalories(double height, double weight, boolean isMale, int age) {
        // A lot of magic numbers but cannot be labelled
        double rawCaloriesTarget;
        if (isMale) {
            rawCaloriesTarget =  88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            rawCaloriesTarget =  447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
        switch (currentHealthGoal) {
        case WEIGHT_LOSS:
            return rawCaloriesTarget * weightLossModifier;

        case STEADY_STATE:
            return rawCaloriesTarget * steadyStateModifier;

        case BULKING:
            return rawCaloriesTarget * bulkingModifier;

        default:
            // If healthGoalInput is invalid
            return 0;

        }
    }

    public String toString() {
        return currentHealthGoal;
    }
}
