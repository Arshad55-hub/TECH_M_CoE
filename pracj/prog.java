import java.util.*;

enum RoomFeature {
    PROJECTOR,
    VIDEO_CONFERENCING,
    WHITEBOARD,
    CONFERENCE_PHONE,
    AIR_CONDITIONING
}

class MeetingRoom {
    String id;
    String name;
    int capacity;
    EnumSet<RoomFeature> features;

    MeetingRoom(String id, String name, int capacity, EnumSet<RoomFeature> features) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.features = features;
    }
}

class RoomScheduler {
    HashMap<String, MeetingRoom> rooms = new HashMap<>();

    void addRoom(MeetingRoom room) {
        rooms.put(room.id, room);
        System.out.println("Room added: " + room.name + ", ID: " + room.id);
    }

    void bookRoom(String id, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = rooms.get(id);

        if (room == null) {
            System.out.println("Room not found.");
        } else if (room.features.containsAll(requiredFeatures)) {
            System.out.println("Room " + id + " booked successfully.");
        } else {
            System.out.println("Room " + id + " does not have all required features.");
        }
    }

    void showAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        ArrayList<String> available = new ArrayList<>();

        for (MeetingRoom room : rooms.values()) {
            if (room.features.containsAll(requiredFeatures)) {
                available.add(room.name);
            }
        }

        if (available.isEmpty()) {
            System.out.println("No rooms available with features: " + requiredFeatures);
        } else {
            System.out.println("Available rooms with features " + requiredFeatures + ": " + available);
        }
    }
}

public class prog {
    public static void main(String[] args) {
        RoomScheduler scheduler = new RoomScheduler();

        scheduler.addRoom(new MeetingRoom(
                "001",
                "Boardroom",
                20,
                EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE, RoomFeature.AIR_CONDITIONING)
        ));

        scheduler.addRoom(new MeetingRoom(
                "002",
                "Strategy Room",
                10,
                EnumSet.of(RoomFeature.WHITEBOARD, RoomFeature.AIR_CONDITIONING)
        ));

        scheduler.bookRoom("001", EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE));
        scheduler.showAvailableRooms(EnumSet.of(RoomFeature.AIR_CONDITIONING));
    }
}
