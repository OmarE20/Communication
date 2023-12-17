// This code is part 3 of our project code
// This part is responsible for the communication between the computer on the vehicle and the computer on the charging station
public class Communication {
    
    /* 'enum' is a special class used to store constants/unchangeable variables.
    We use this class to store our 3 states of power: Off, on and charging. */
    enum PowerState {
        OFF, ON, CHARGING
    }

    // This line creates private
    private PowerState currentState;

    // This class is used to set the current state of power for the AIV to 'off' 
    public Communication() {
        this.currentState = PowerState.OFF;
    }


    // 
    public void receiveCommand(String command) {
        switch (command.toLowerCase()) {
            case "start":
                startVehicle();
                break;
            case "stop":
                stopVehicle();
                break;
            case "charge":
                startCharging();
                break;
            case "poweroff":
                powerOff();
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private void startVehicle() {
        if (currentState == PowerState.OFF) {
            currentState = PowerState.ON;
            System.out.println("Vehicle started.");
        } else {
            System.out.println("Vehicle is already on or charging.");
        }
    }

    private void stopVehicle() {
        if (currentState == PowerState.ON) {
            currentState = PowerState.OFF;
            System.out.println("Vehicle stopped.");
        } else {
            System.out.println("Vehicle is not running.");
        }
    }

    private void startCharging() {
        if (currentState != PowerState.CHARGING) {
            currentState = PowerState.CHARGING;
            System.out.println("Vehicle is charging.");
        } else {
            System.out.println("Vehicle is already charging.");
        }
    }

    private void powerOff() {
        if (currentState != PowerState.OFF) {
            currentState = PowerState.OFF;
            System.out.println("Vehicle is powered off.");
        } else {
            System.out.println("Vehicle is already off.");
        }
    }

    // Add methods for network communication here

    public static void main(String[] args) {
        Communication vehicle = new Communication();
        vehicle.receiveCommand("start");
        vehicle.receiveCommand("charge");
        vehicle.receiveCommand("stop");
        vehicle.receiveCommand("poweroff");
    }
}
