package challenge;

import java.util.Arrays;
import java.util.List;

public class CalendarTestDrive {
    public static void main(String[] args) {
        ZoneFactory zoneFactory = new ZoneFactory();
        Calendar calendar = new PacificCalendar(zoneFactory);
        List<String> appts = Arrays.asList("appt1", "Apptt2");
        calendar.CreateCalendar(appts);
        calendar.print();
    }
}
