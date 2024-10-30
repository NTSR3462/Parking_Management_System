import java.util.List;

public class ParkingManagement {
    private FileHandler fileHandler;

    public ParkingManagement() {
        this.fileHandler = new FileHandler();
    }

    // Register a new vehicle
    public void registerVehicle(String vehicleNumber, String ownerName) {
        fileHandler.saveVehicle(vehicleNumber, ownerName, "parked");
    }

    // Mark vehicle as entered
    public void vehicleEntry(String vehicleNumber) {
        fileHandler.updateVehicleStatus(vehicleNumber, "parked");
    }

    // Mark vehicle as exited
    public void vehicleExit(String vehicleNumber) {
        fileHandler.updateVehicleStatus(vehicleNumber, "left");
    }

    // Find and return vehicle details
    public String findVehicle(String vehicleNumber) {
        List<String> vehicles = fileHandler.loadVehicles();
        for (String vehicle : vehicles) {
            String[] data = vehicle.split(",");
            if (data[0].equals(vehicleNumber)) {
                return "Vehicle Number: " + data[0] + ", Owner Name: " + data[1] + ", Status: " + data[2];
            }
        }
        return "Vehicle not found.";
    }
}
