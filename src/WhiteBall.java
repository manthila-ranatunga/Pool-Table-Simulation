import bagel.Image;
import bagel.util.Point;

public class WhiteBall extends Ball {

    public WhiteBall(Point position, Point direction, double speed) {
        super(position, direction, speed);
        image = new Image("res/white.png");

    }

}

