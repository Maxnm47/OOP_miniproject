public class Room {
    private static int roomCount = 0;
    private int roomId;
    private Reservation[] availableHours;  // An array to hold reservations for each hour
    private boolean[] schedule;  // Each index represents one hour, true means reserved, false means available


    public Room(int roomId) {
        this.roomId = roomCount++;
        this.availableHours = new Reservation[10];  // 10 slots from 08:00 to 17:00
        initializeHours();
    }

    private void initializeHours() {
        for (int i = 0; i < 10; i++) {
            availableHours[i] = null;  // Initially, no reservations
        }
    }

    public int getRoomId() {
        return roomId;
    }

    public Reservation[] getAvailableHours() {
        return availableHours;
    }

    public boolean reserveRoom(int hourIndex, Reservation reservation) {
    if (hourIndex >= 0 && hourIndex < 10) {
        if (availableHours[hourIndex] == null) {
            availableHours[hourIndex] = reservation;
            return true;
        } else {
            System.out.println("Invalid time slot: Already reserved.");
        }
    }
    return false;
}

    
    public boolean[] getSchedule() {
    schedule = new boolean[availableHours.length];
    for (int i = 0; i < availableHours.length; i++) {
        schedule[i] = (availableHours[i] != null);
    }
    return schedule;
}

    public boolean isTimeSlotReserved(int hourIndex) {
        if (hourIndex >= 0 && hourIndex < availableHours.length) {
            return availableHours[hourIndex] != null;
        }
        return false;
    }
}
