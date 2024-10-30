import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "vehicles.txt";

    // Save vehicle details to file
    public void saveVehicle(String vehicleNumber, String ownerName, String status) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(vehicleNumber + "," + ownerName + "," + status + "\n");
        } catch (IOException e) {
            System.out.println("Error saving vehicle: " + e.getMessage());
        }
    }

    // Load all vehicles from file
    public List<String> loadVehicles() {
        List<String> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                vehicles.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading vehicles: " + e.getMessage());
        }
        return vehicles;
    }

    // Update the status of a vehicle
    public void updateVehicleStatus(String vehicleNumber, String newStatus) {
        List<String> vehicles = loadVehicles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String vehicle : vehicles) {
                String[] data = vehicle.split(",");
                if (data[0].equals(vehicleNumber)) {
                    writer.write(vehicleNumber + "," + data[1] + "," + newStatus + "\n");
                } else {
                    writer.write(vehicle + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating vehicle status: " + e.getMessage());
        }
    }
}
