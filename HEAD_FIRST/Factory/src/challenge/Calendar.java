package challenge;

import java.util.List;

public abstract class Calendar {
    Zone zone;
    public void print(){
        System.out.println("+++++" + zone.getDisplayName() + " Calendar+++++");
        System.out.println("Offset from GMT: " + zone.getOffset());
    }
    public abstract void CreateCalendar(List<String> appointments);
}
