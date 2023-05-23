package Inheritance.Point2D_3D;

public class Run {
    public static void main(String[] args) {

        Point2D[] points = createPoints(3);

        showPoints(points);
    }

    public static Point2D[] createPoints(int size) {
        Point2D[] points = new Point2D[size];

        points[0] = new Point3D(1, 5, 8);
        points[1] = new Point2D(5, 7);
        points[2] = new Point2D(4, 6);
        return points;
    }

    public static void showPoints(Point2D[] points) {
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
        }
    }

}