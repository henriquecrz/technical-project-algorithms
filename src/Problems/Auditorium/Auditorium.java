package Problems.Auditorium;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auditorium {
    public List<Schedule> schedule;
    public Date open;
    public Date close;

    public Auditorium(Date open, int hoursOpened) {
        this.schedule = new ArrayList<Schedule>();
        this.open = open;
        this.close = Utils.addHours(open, hoursOpened);
    }

    public void printScheduleList() {
        for (Schedule schedule : this.schedule) {
            schedule.printSchedule();
        }
    }

    public void addSchedule(Schedule schedule) {
        this.schedule.add(schedule);
    }
}
