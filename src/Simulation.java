/*
Stuff to add:

- Kinetic energy
    - Equation
    - transfer
    - Losses
- Momentum
    - Mass
    - Transfer
- Balls falling into holes
    - Going into ball rack - use arraylist for 'slots'?
- More starting patterns
    - classic triangle
- Make ball rack dark gray
    - Use java.util.Colour or something

 */


/***********************************************************************************************************************

                                                Pool table Simulation
                                                By Manthila Ranatunga
                                                manthila.ranatunga@gmail.com
                                                Started 23/05/2021

 **********************************************************************************************************************/


import bagel.*;
import bagel.util.Point;

import java.util.ArrayList;

public class Simulation extends AbstractGame {

    private final Table table;
    private final BallFactory FACTORY = new BallFactory();
    private final ArrayList<Ball> balls;

    private int coolDownCounter = 0;

    public Simulation() {
        super(800, 468);
        Window.setClearColour(0, 0, 0);

        table = new Table();



        balls = FACTORY.StandardSet();
//        balls = FACTORY.Pair();

    }

    private static double distanceBetween(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
    }

    private static Point directionTo(Point point1, Point point2) {
        double x;
        double y;
        x = (point2.x - point1.x) / distanceBetween(point1, point2);
        y = (point2.y - point1.y) / distanceBetween(point1, point2);
        return new Point(x, y);
    }


    @Override
    protected void update(Input input) {

        table.update();

        for (Ball ball : balls) {
            ball.update();
            ball.move();

            // Check collision with walls
            if (ball.bounds().left < table.bounds().left || ball.bounds().right > table.bounds().right) {
                ball.setDirection(new Point(ball.direction.x * -1, ball.direction.y));
            }
            if (ball.bounds().bottom > table.bounds().bottom || ball.bounds().top < table.bounds().top) {
                ball.setDirection(new Point(ball.direction.x, ball.direction.y * -1));
            }
        }

        // Check collision with other balls
        for (Ball ball : balls) {
            for (Ball otherBall : balls) {
                if (!ball.equals(otherBall)) {
                    if (distanceBetween(ball.position, otherBall.position) < 2 * Ball.getRADIUS()) {
                        ball.setOppositeDirection(directionTo(ball.position, otherBall.position));
                        otherBall.setOppositeDirection(directionTo(otherBall.position, ball.position));
                    }
                }
            }
        }


    }

    private boolean cooldown() {
        if (coolDownCounter == 1) {
            coolDownCounter = 0;
            return true;
        }
        coolDownCounter++;
        return false;
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.run();
    }
}
