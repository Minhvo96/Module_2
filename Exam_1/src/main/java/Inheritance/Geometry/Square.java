//package Inheritance.Geometry;
//
//public class Square extends Retangle {
//    public Square() {
//    }
//
//    public Square(double side) {
//        super(side, side);
//    }
//
//    public Square(double side, String color, Boolean filled) {
//        super(side, side, color, filled);
//    }
//
//    public double getSide() {
//        return getWidth();
//    }
//
//    public double setSide(double side) {
//        setWidth(side);
//        setLength(side);
//    }
//
//    @Override
//    public void setSide (double side) {
//        setSide(width);
//    }
//
//    @Override
//    public void setLength (double length) {
//        setSide(length);
//    }
//
//    @Override
//    public String toString() {
//        return ("A Square with side = " + getSide() + ", which is a subclass of " + super.toString());
//    }
//}
