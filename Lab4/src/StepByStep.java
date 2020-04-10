import java.awt.*;
import java.util.ArrayList;

public class StepByStep {
    public static ArrayList<Point> stepByStep(int x1, int y1, int x2, int y2){
        ArrayList<Point> points = new ArrayList<>();
        double k = ((double)y2 - (double)y1) / ((double)x2 - (double)x1);
        double b = y2 - k * x2;
        double dx = (double)Math.abs(x2 - x1) / ((double)Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)) * 2);
        dx = (x2 > x1 ? dx : -dx);
        for (double x = x1; (int)x != x2; x += dx){
            int y = (int) (k * x + b);
            points.add(new Point((int)x, y));
        }
        points.add(new Point(x2, y2));
        return points;
    }
}
