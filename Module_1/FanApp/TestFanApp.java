package Module_1.FanApp;

public class TestFanApp {
    public static void main(String[] args) {
        // Fan with default constructor
        Fan fan1 = new Fan();

        // Fan with argument constructor
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "blue");

        // Display both fans
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}

