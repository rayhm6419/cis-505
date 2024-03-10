package Module_1.FanApp;

public class testFanApp {
    public static void main(String[] args) {
        Fan defaultFan = new Fan();
        Fan Custom = new Fan(Fan.MEDIUM, true, 8.0, "Blue" );

        System.out.println(defaultFan.toString());
        System.out.println(Custom.toString());


    }
}
