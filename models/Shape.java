package models;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    private List<Point> points;

    public Shape() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point cur = points.get(i);
            Point next = points.get((i + 1) % points.size());
            perimeter += cur.distance(next);
        }
        return perimeter;
    }

    public double getAverageSide() {
        return calculatePerimeter() / points.size();
    }

    public double getLongestSide() {
        double max = 0;
        for (int i = 0; i < points.size(); i++) {
            Point cur = points.get(i);
            Point next = points.get((i + 1) % points.size());
            double d = cur.distance(next);
            if (d > max) max = d;
        }
        return max;
    }
}