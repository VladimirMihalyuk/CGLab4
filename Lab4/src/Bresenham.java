import java.awt.*;
import java.util.ArrayList;

public class Bresenham {
    public static ArrayList<Point> bresenham(int x1, int y1, int x2, int y2) {
        ArrayList<Point> points = new ArrayList<>();

        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
        if (steep) {
            int temp = x1;
            x1 = y1;
            y1 = temp;
            temp = x2;
            y2 = temp;
        }

        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int error = dx / 2;
        int ystep = (y1 < y2) ? 1 : -1;
        int y = y1;
        for (int x = x1; x <= x2; x++) {
            points.add(new Point(steep ? y : x, steep ? x : y));
            error -= dy;
            if (error < 0) {
                y += ystep;
                error += dx;
            }
        }
        return points;
    }
}
