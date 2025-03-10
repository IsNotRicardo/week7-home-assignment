import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportsTimeTracker {
    private final List<SportActivity> activities = new ArrayList<>();

    public void addActivity(LocalDateTime startTime, LocalDateTime endTime, String name) {
        activities.add(new SportActivity(startTime, endTime, name));
    }

    public List<SportActivity> getActivities() {
        return activities;
    }

    // Calculate the total time in hours
    public float getTotalTime() {
        float totalTime = 0;
        for (SportActivity activity : activities) {
            totalTime += activity.getDuration();
        }
        return totalTime;
    }
}
