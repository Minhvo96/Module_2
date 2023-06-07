package CleanCode_Refactoring.Cylinder;

public class Cylinder {

//    public static double getVolume(int radius, int height) {
//        double baseArea = Math.PI * radius * radius;
//        double perimeter = 2 * Math.PI * radius;
//        double volume = perimeter * height + 2 * baseArea;
//        return volume;
//    }

    public static double getVolume(int radius, int height) {
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    public static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        System.out.println(getVolume(1,2));
    }
}

