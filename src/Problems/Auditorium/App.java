package Problems.Auditorium;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Calendar cOpenAt = new GregorianCalendar(2020, Calendar.JULY, 22, 10, 0);
        Date openAt = cOpenAt.getTime();

        Auditorium auditorium = new Auditorium(openAt, 12);
        Schedule schedule1 = new Schedule(openAt, 12);
        Schedule schedule2 = new Schedule(openAt, 12);
        auditorium.addSchedule(schedule1);
        auditorium.addSchedule(schedule2);

        Task taskToAdd1 = new Task(2020, Calendar.JULY, 22, 11, 2, 1);
        Task taskToAdd2 = new Task(2020, Calendar.JULY, 22, 20, 2, 1);
        Task taskToAdd3 = new Task(2020, Calendar.JULY, 21, 14, 2, 1); // Não passa pois o auditório está fechado
        Task taskToAdd4 = new Task(2020, Calendar.JULY, 22, 17, 2, 1);
        Task taskToAdd5 = new Task(2020, Calendar.JULY, 22, 19, 2, 1); // Não passa pois o horário conflita com a task 2

        schedule1.addTask(taskToAdd1);
        schedule1.addTask(taskToAdd2);
        schedule1.addTask(taskToAdd3);
        schedule1.addTask(taskToAdd4);
        schedule1.addTask(taskToAdd5);
        schedule2.addTask(taskToAdd1);
        schedule2.addTask(taskToAdd2);
        schedule2.addTask(taskToAdd3);
        schedule2.addTask(taskToAdd4);
        schedule2.addTask(taskToAdd5);

        auditorium.printScheduleList();
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Solved in: " + (end - start) + "ms");
    }
}
