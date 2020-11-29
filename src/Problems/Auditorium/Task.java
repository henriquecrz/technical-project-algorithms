package Problems.Auditorium;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task {
    private static int counter = 0;
    public int id;
    public Date start;
    public Date finish;
    public Date startAt;

    public Task(int year, int month, int day, int hour, int duration, int startAtHours) {
        Calendar startDate = new GregorianCalendar(year, month, day, hour, 0);
        Date start = startDate.getTime();
        this.start = start;
        this.finish = Utils.addHours(start, duration);
        this.startAt = Utils.addHours(start, startAtHours);
        this.id = counter;
        counter += 1;
    }

    public boolean isBetween(Date start, Date finish) {
        return start.compareTo(this.start) >= 0 && start.compareTo(this.finish) <= 0
                || finish.compareTo(this.start) >= 0 && finish.compareTo(this.finish) <= 0;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.start.toLocaleString() + " - " + this.finish.toLocaleString();
    }
}
