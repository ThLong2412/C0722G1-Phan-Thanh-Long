package ss6_inheritance.exersice.ss3_point;

import java.lang.reflect.Array;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array = {xSpeed, ySpeed};
        return array;
//        return new float[]{xSpeed,ySpeed};
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + "), speed = (" + getXSpeed() + ", " + getYSpeed() + ")";
    }

    public MoveablePoint move() {
        super.setX(super.getX() +  xSpeed);
        super.setY(super.getY() + ySpeed);
        return this;
    }
}
