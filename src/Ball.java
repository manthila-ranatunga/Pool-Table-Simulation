import bagel.*;
import bagel.util.Point;

import java.util.Random;

public abstract class Ball {
    private static final int STEP_SIZE = 10;
    private static final int RADIUS = 10;

    protected Point position;
    protected Point direction;
    protected Image image;
    private Boundary bounds;
    private double speed;

    private static final Random random = new Random();


    public Ball(Point position, Point direction, double speed) {
        this.position = position;
        this.direction = direction;
        this.speed = speed * STEP_SIZE;
    }

    public void move() {
        double x = position.x;
        double y = position.y;


        x += direction.x * speed;
        y += direction.y * speed;

        this.position = new Point(x, y);
        this.bounds = new Boundary(position.x - size().x / 2, position.x + size().x / 2,
                position.y + size().y / 2, position.y - size().y / 2);
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    public void setOppositeDirection(Point direction) {
        this.direction = new Point(-direction.x * -1, direction.y * -1);
    }


    public void update() {
        image.draw(position.x, position.y);
    }


    public boolean equals(Ball ball) {
        return position == ball.position && direction == ball.direction;
    }


    public Boundary bounds() {
        return bounds;
    }

    public Point getDirection() {
        return direction;
    }

    public Point size() {
        return new Point(image.getWidth(), image.getHeight());
    }

    public static int getRADIUS() {
        return RADIUS;
    }

    public double getSpeed() {
        return speed;
    }
}
