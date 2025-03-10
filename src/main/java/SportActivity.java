import java.time.LocalDateTime;

public record SportActivity(LocalDateTime startTime, LocalDateTime endTime, String name) {
    public SportActivity {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }

    public float getDuration() {
        return (float) startTime.until(endTime, java.time.temporal.ChronoUnit.MINUTES) / 60;
    }
}
