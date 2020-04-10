import java.awt.*;
import java.util.ArrayList;

public class CDA {
    public static ArrayList<Point> cda(int x1, int y1, int x2, int y2){
        ArrayList<Point> points = new ArrayList<>();
        int L = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        double dX = (x2 - x1) * 1.0 / L;
        double dY = (y2 - y1) * 1.0 / L;
        points.add(new Point(x1, y1));
        double prevX = x1;
        double prevY = y1;
        int i = 1;
        while (i < L) {
            prevX = prevX + dX;
            prevY = prevY + dY;
            points.add(new Point((int)Math.round(prevX), (int)Math.round(prevY)));
            i++;
        }
        return points;
    }
}
