package Inheritance.CirleCylinder;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(5, "green");
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(10,"blue",20);
        System.out.println(cylinder);

        Circle shape = new Cylinder();
        System.out.println(shape);
    }



}
