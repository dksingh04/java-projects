import java.util.List;
import java.util.PriorityQueue;

public class ParkingFloor {
    private String name;
    private PriorityQueue<ParkingSpot> availableSpotList;
    private List<ParkingSpot> occupiedSpotList;

    public void addParkingSpot() {
        // initialize all available and occupied spot list.
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot){
        spot.assignVehicle(vehicle);
    }

    public void freeSpot(ParkingSpot spot){
        spot.removeVehicle();
    }


}
