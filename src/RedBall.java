import bagel.Image;
import bagel.util.Point;

public class RedBall extends Ball {

    public RedBall(Point position, Point direction, double speed) {
        super(position, direction, speed);
        image = new Image("res/red.png");

    }

}
