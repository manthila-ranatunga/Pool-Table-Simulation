import bagel.util.Point;

import java.util.ArrayList;
import java.util.Random;

public class BallFactory {

    private static final Random random = new Random();


    public ArrayList<Ball> StandardSet() {
        ArrayList<Ball> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            double x = 0;
            double y = 0;
            double a;

            while (!(x >= 40) || !(x <= 760)) {
                x = random.nextDouble() * 800;
            }
            while (!(y >= 60) || !(y <= 378)) {
                y = random.nextDouble() * 438;
            }

            list.add(new RedBall(new Point(x, y), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));
        }

        for (int i = 0; i < 7; i++) {
            double x = 0;
            double y = 0;
            double a;

            while (!(x >= 40) || !(x <= 760)) {
                x = random.nextDouble() * 800;
            }
            while (!(y >= 60) || !(y <= 378)) {
                y = random.nextDouble() * 438;
            }

            list.add(new YellowBall(new Point(x, y), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));
        }

        list.add(new WhiteBall(new Point(680, 219), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));
        list.add(new BlackBall(new Point(180, 219), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));

        return list;
    }

    public ArrayList<Ball> Pair() {
        ArrayList<Ball> list = new ArrayList<>();

        list.add(new RedBall(new Point(680, 219), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));
        list.add(new YellowBall(new Point(180, 219), new Point(random.nextDouble(), random.nextDouble()), random.nextDouble()));

        return list;
    }


    public static double getRandom() {
        return random.nextDouble();
    }
}
