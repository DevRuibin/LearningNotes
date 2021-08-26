package challenge;

public class Zone {
    String displayName;
    int offset;

    public String getDisplayName() {
        return displayName;
    }

    public int getOffset() {
        return offset;
    }
}

class ZoneCentral extends Zone{
    public ZoneCentral() {
        displayName = "US/Central";
        offset = -6;
    }
}

class ZoneEastern extends Zone {
    public ZoneEastern() {
        displayName = "US/Eastern";
        offset = -5;
    }
}

class ZoneMountain extends Zone {
    public ZoneMountain() {
        displayName = "US/Mountain";
        offset = -7;
    }
}

class ZonePacific extends Zone {
    public ZonePacific() {
        displayName = "US/Pacific";
        offset = -8;
    }
}


