import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingManagementUI {
    private ParkingManagement parkingManagement;

    public ParkingManagementUI(ParkingManagement parkingManagement) {
        this.parkingManagement = parkingManagement;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Parking Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel vehicleLabel = new JLabel("Vehicle Number:");
        vehicleLabel.setBounds(10, 20, 120, 25);
        panel.add(vehicleLabel);

        JTextField vehicleNumberText = new JTextField(20);
        vehicleNumberText.setBounds(150, 20, 165, 25);
        panel.add(vehicleNumberText);

        JLabel ownerLabel = new JLabel("Owner Name:");
        ownerLabel.setBounds(10, 50, 120, 25);
        panel.add(ownerLabel);

        JTextField ownerNameText = new JTextField(20);
        ownerNameText.setBounds(150, 50, 165, 25);
        panel.add(ownerNameText);

        JButton registerButton = new JButton("Register Vehicle");
        registerButton.setBounds(10, 80, 150, 25);
        panel.add(registerButton);

        JButton entryButton = new JButton("Vehicle Entry");
        entryButton.setBounds(10, 110, 150, 25);
        panel.add(entryButton);

        JButton exitButton = new JButton("Vehicle Exit");
        exitButton.setBounds(10, 140, 150, 25);
        panel.add(exitButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 170, 350, 80);
        panel.add(resultArea);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vehicleNumber = vehicleNumberText.getText();
                String ownerName = ownerNameText.getText();
                parkingManagement.registerVehicle(vehicleNumber, ownerName);
                resultArea.setText("Vehicle registered: " + vehicleNumber);
            }
        });

        entryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vehicleNumber = vehicleNumberText.getText();
                parkingManagement.vehicleEntry(vehicleNumber);
                resultArea.setText("Vehicle entered: " + vehicleNumber);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vehicleNumber = vehicleNumberText.getText();
                parkingManagement.vehicleExit(vehicleNumber);
                resultArea.setText("Vehicle exited: " + vehicleNumber);
            }
        });
    }

    public static void main(String[] args) {
        ParkingManagement parkingManagement = new ParkingManagement();
        new ParkingManagementUI(parkingManagement);
    }
}
