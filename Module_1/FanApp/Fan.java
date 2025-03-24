package Module_1.FanApp;

public class Fan {

    static int STOPPED = 0;
    static int SLOW = 1;
    static int MEDIUM = 2;
    static int FAST = 3;
    private int speed = STOPPED;
    private boolean Switch = false;
    private double radius = 6;
    private String color = "white";

    public Fan(){
        this.speed = STOPPED;
        this.Switch = false;
        this.radius = 6;
        this.color = "white";
    }

    public Fan(int speed, boolean Switch, double radius, String color){
        this.speed = speed;
        this.Switch = Switch;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean isSwitch() {
        return Switch;
    }
    public void setSwitch(boolean switch1) {
        Switch = switch1;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (Switch) {
            return "The fan speed is set of" + " "+ speed + " " + "with a color of" + " "+ color +" "+ "and a radius of" +" "+ radius;
        } else {
            return "The fan is " + color + " " + "with a radius" + " "+ radius + "and the fan is off";
        }
    }
}