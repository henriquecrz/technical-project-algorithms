package Problems.Auditorium;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {
    private static int counter = 0;
    public List<Task> schedule;
    public Date open;
    public Date close;
    public int id;

    public Schedule(Date open, int hoursOpened) {
        this.schedule = new ArrayList<Task>();
        this.open = open;
        this.close = Utils.addHours(open, hoursOpened);
        this.id = counter;
        counter += 1;
    }

    public void printSchedule() {
        System.out.println("Horarios da lista de agendamentos: " + this.id);
        for (Task task : this.schedule) {
            System.out.println(task);
        }
    }

    private boolean isOpened(Date start, Date finish) {
        return start.compareTo(this.open) >= 0 && start.compareTo(this.close) <= 0 && finish.compareTo(this.open) >= 0
                && finish.compareTo(this.close) <= 0;
    }

    public void addTask(Task newTask) {
        if (!isOpened(newTask.start, newTask.finish))
            return;

        for (Task task : schedule) {
            if (task.isBetween(newTask.start, newTask.finish))
                return;
        }

        schedule.add(newTask);
    }
}
