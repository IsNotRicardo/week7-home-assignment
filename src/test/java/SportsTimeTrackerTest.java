import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SportsTimeTrackerTest {
    private SportsTimeTracker sportsTimeTracker;

    @BeforeEach
    void setUp() {
        sportsTimeTracker = new SportsTimeTracker();
    }

    @Test
    void testAddActivity() {
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 1, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 3, 1, 12, 0);

        sportsTimeTracker.addActivity(startTime, endTime, "Running");
        assertEquals(1, sportsTimeTracker.getActivities().size());
    }

    @Test
    void testAddActivityInvalid() {
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 1, 12, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 3, 1, 9, 0);

        try {
            sportsTimeTracker.addActivity(startTime, endTime, "Running");
        } catch (IllegalArgumentException e) {
            assertEquals("Start time must be before end time", e.getMessage());
        }
    }

    @Test
    void testGetActivities() {
        LocalDateTime startTime1 = LocalDateTime.of(2025, 3, 1, 9, 30);
        LocalDateTime endTime1 = LocalDateTime.of(2025, 3, 1, 12, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2025, 3, 1, 13, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2025, 3, 1, 15, 0);

        sportsTimeTracker.addActivity(startTime1, endTime1, "Running");
        sportsTimeTracker.addActivity(startTime2, endTime2, "Swimming");

        List<SportActivity> activities = sportsTimeTracker.getActivities();
        assertEquals("Running", activities.get(0).name());
        assertEquals("Swimming", activities.get(1).name());
        assertEquals(2, activities.size());
    }

    @Test
    void testGetTotalTime() {
        LocalDateTime startTime1 = LocalDateTime.of(2025, 3, 1, 9, 30);
        LocalDateTime endTime1 = LocalDateTime.of(2025, 3, 1, 12, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2025, 3, 1, 13, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2025, 3, 1, 15, 0);

        sportsTimeTracker.addActivity(startTime1, endTime1, "Running");
        sportsTimeTracker.addActivity(startTime2, endTime2, "Swimming");
        assertEquals(4.5, sportsTimeTracker.getTotalTime(), 0.01);
    }
}
