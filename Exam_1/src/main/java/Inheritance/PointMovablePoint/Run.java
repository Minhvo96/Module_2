package Inheritance.PointMovablePoint;

public class Run {
    public static void main(String[] args) {

        Point point = new Point();
        System.out.println(point);

        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        point = new Point (5, 10);
        System.out.println(point);

        movablePoint = new MovablePoint(20, 8, 14, 6);
        System.out.println(movablePoint);



    }
}
