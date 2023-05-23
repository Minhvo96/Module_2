package Inheritance.PointMovablePoint;

public class MovablePoint extends Point {
    float xSpeed;
    float ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    @Override
    public String toString() {
        return String.format("MovablePoint has x = %s, y = %s, xSpeed = %s and ySpeed = %s", getX(), getY(), getxSpeed(), getySpeed());
    }

    public MovablePoint move() {
        float x = getX();
        float y = getY();
        x += getxSpeed();
        y += getySpeed();
        setXY(x,y);
        return this;
    }


}
