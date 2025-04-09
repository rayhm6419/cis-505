package cis-505.Module_4;

public class Shoe extends Product {
    private double size = 0.0;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public shoe(){

    }

    @Override
    public String toString(){
        return code + "\n" + description + "\n" + size;
    }

}
