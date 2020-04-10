import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private int numCellsX = 20;
    private int numCellsY;
    private int cellSize = 10;
    private ArrayList<Point> points = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCoordinates(g);
        drawCoordinateRectangles(numCellsX, g);
        for (Point point : points) {
            fillCell(point.x, point.y, cellSize, g);
        }
    }

    private void drawCoordinates(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Rectangle bounds = getBounds();
        Line2D yLine = new Line2D.Double((int)(bounds.width / 2), 0, (int)(bounds.width / 2), bounds.height);
        Line2D xLine = new Line2D.Double(0, (int)(bounds.height / 2), bounds.width, (int)(bounds.height / 2));
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(3));
        g2.draw(xLine);
        g2.draw(yLine);
    }

    private void drawCoordinateRectangles(int n, Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Rectangle bounds = getBounds();
        cellSize = (Math.min(bounds.width, bounds.height)) / n;
        int nX = bounds.width / cellSize;
        int nY = bounds.height / cellSize;
        numCellsY = nY * 2;
        g2.setStroke(new BasicStroke(1));
        for (int i = -nX / 2; i < nX / 2; i++){
            Line2D line = new Line2D.Double((int)(bounds.width / 2) + cellSize * i,0,
                    (int)(bounds.width / 2) + cellSize * i,bounds.height);
            g2.draw(line);
        }
        for (int i = -nY / 2; i < nY / 2; i++){
            Line2D line = new Line2D.Double(0,(int)(bounds.height / 2) + cellSize * i,bounds.width,
                    (int)(bounds.height / 2) +cellSize * i);
            g2.draw(line);
        }

    }

    private void fillCell(int x, int y, int cellSize, Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Rectangle bounds = getBounds();
        g2.fillRect((bounds.width / 2) + cellSize * (x - 1),
                (bounds.height / 2) - cellSize * (y ), cellSize, cellSize);
    }


    public void drawPoints(ArrayList<Point> points){
        this.points = points;
        Pair<Integer, Integer> deltas = getMaxDxDy(points);
        if (numCellsX / 2 < deltas.getKey() || numCellsX / 2 + 6 > deltas.getKey())
            numCellsX = deltas.getKey() * 2 + 6;
        if (numCellsY / 2 < deltas.getValue())
            numCellsX = deltas.getValue() * 2 + 2;
        repaint();
    }

    private Pair<Integer, Integer> getMaxDxDy(ArrayList<Point> points){
        int dx = 0;
        int dy = 0;
        for (Point point : points){
            if (Math.abs(point.x) > dx)
                dx = Math.abs(point.x);
            if (Math.abs(point.y) > dy)
                dy = Math.abs(point.y);
        }
        return new Pair<Integer, Integer>(dx, dy);
    }
}
