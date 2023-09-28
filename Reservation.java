public class Reservation {
    private int groupId;
    private int hoursBooked;
    private Room room;

    public Reservation(int groupId, int hoursBooked, Room room) {
        this.groupId = groupId;
        this.hoursBooked = hoursBooked;
        this.room = room;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getHoursBooked() {
        return hoursBooked;
    }

    public Room getRoom() {
        return room;
    }
}
