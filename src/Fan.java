/*
 * Author: Alex Gabriel <alex@alexgabriel.ca>
 * Date created: 25/10/2023
 * Description: The class implements a basic ceiling fan. The fan has 2 cords, each of which change speed or direction.
 * When the speed is on high, pulling the speed cord will stop the fan.  When the direction cord is pulled, the fan
 * starts in the forward direction. Pulling the direction cord again reverses the direction of the fan will keeping
 * the speed consistent.
 */

public class Fan {
    private static String fanDirection = "";
    private static int fanSpeed = 0;

    private static void setDirection(String direction) {
        try {
            fanDirection = direction;

        } catch (Exception e) {
            System.out.println("There was an error");
        }
    }

    private static String getDirection() {
        return fanDirection;
    }

    private static void setSpeed(int speed) {
        try {
            switch (speed) {
                case 0, 1, 2, 3 -> fanSpeed = speed;
                default -> fanSpeed = 0;
            }

        } catch (Exception e) {
            System.out.println("There was an error");
        }
    }

    private static String getSpeed() {
        return switch (fanSpeed) {
            case 0 -> "Fan speed is off";
            case 1 -> "Fan speed is low";
            case 2 -> "Fan speed is medium";
            case 3 -> "Fan speed is high";
            default -> "";
        };
    }

    private static void switchDirection() {
        if (fanDirection.equals("forward")) {
            setDirection("reverse");
        } else if (fanDirection.equals("reverse")) {
            setDirection("forward");
        }
    }

    private static void pullCordDirection() {
        if (fanDirection.isEmpty()) {
            setDirection("forward");
        } else if (fanDirection.equals("forward")) {
            switchDirection();
        } else if (fanDirection.equals("reverse")) {
            switchDirection();
        }
    }

    private static void pullCordSpeed() {
        if (fanSpeed == 0) {
            setSpeed(1);
        } else if (fanSpeed == 1) {
            setSpeed(2);
        } else if (fanSpeed == 2) {
            setSpeed(3);
        } else if (fanSpeed == 3) {
            setSpeed(0);
        }
    }

    public static void main(String[] args) {
        pullCordDirection();
        System.out.println(getDirection());
        pullCordSpeed();
        System.out.println(getSpeed());
    }
}