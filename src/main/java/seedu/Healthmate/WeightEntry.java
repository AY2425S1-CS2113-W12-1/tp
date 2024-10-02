package seedu.Healthmate;

import java.time.LocalDateTime;

public class WeightEntry {
    private double weight;
    private final LocalDateTime timestamp;

    public WeightEntry(double weight) {
        this.weight = weight;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "weight: " + this.weight;
    }
}