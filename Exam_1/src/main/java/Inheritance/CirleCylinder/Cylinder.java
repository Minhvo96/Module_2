package Inheritance.CirleCylinder;

public class Cylinder extends Circle{

    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super (radius, color);
        this.height = height;
    }

    public double volumeCylinder() {
        return height * super.getRadius() * super.getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return ("A Cylinder has a radius = " + super.getRadius() + " with height is " + getHeight() + " and its volume = " + volumeCylinder()
                + ", which is subclass of " + super.toString());
    }

}
