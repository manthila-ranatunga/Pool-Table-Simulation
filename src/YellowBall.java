import bagel.Image;
import bagel.util.Point;

public class YellowBall extends Ball {

    public YellowBall(Point position, Point direction, double speed) {
        super(position, direction, speed);
        image = new Image("res/yellow.png");

    }


}
