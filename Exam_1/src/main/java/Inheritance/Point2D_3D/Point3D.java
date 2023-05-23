package Inheritance.Point2D_3D;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
//        float[] array2 = new float[3];
//        array2[0] = getX();
//        array2[1] = getY();
//        array2[3] = z;
//        return array2;
        return new float[]{getX(), getY(), this.z};
    }

    @Override
    public String toString() {
        return String.format("Point3D (%s,%s,%s)",getX(),getY(),getZ());
    }
}
