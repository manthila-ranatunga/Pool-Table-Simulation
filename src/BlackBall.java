import bagel.Image;
import bagel.util.Point;

public class BlackBall extends Ball {

    public BlackBall(Point position, Point direction, double speed) {
        super(position, direction, speed);
        image = new Image("res/black.png");

    }

}
