package challenge;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PacificCalendar extends Calendar {
    public PacificCalendar(@NotNull ZoneFactory zoneFactory) {
        zone = zoneFactory.createZone("US/Pacific");
    }

    @Override
    public void CreateCalendar(List<String> appointments) {
        System.out.println("making the calendar");
        System.out.println(appointments.toString());
    }
}
