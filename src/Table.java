import bagel.DrawOptions;
import bagel.Image;
import bagel.util.Point;

public class Table {
    private final Point position = new Point(0,0);
    private final Image image = new Image("res/pool-table.png");
    private final Point size = new Point(image.getWidth(), image.getHeight());
    private final Boundary bounds = new Boundary(40, 760, 60, 378);

    private final DrawOptions drawOptions = new DrawOptions();


    public Table() {

    }

    public void update() {
        image.drawFromTopLeft(position.x, position.y);
    }

    public Point size() {
        return size;
    }

    public Boundary bounds() {
        return bounds;
    }



}
