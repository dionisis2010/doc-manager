package org.example.utils;

import lombok.Value;
import org.example.gui.VisualWorkSpase;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Comparator;
import java.util.stream.Stream;

public class ViewUtils {

    public static Line2D.Double resolveLine(Point location1, Dimension size1, Point location2, Dimension size2) {
        SideCenters first = new SideCenters(location1, size1);
        SideCenters second = new SideCenters(location2, size2);
        return resolveMinLine(first, second);
    }

    private static Line2D.Double resolveMinLine(SideCenters first, SideCenters second) {
        return first.getAll()
                .flatMap(p -> second.getAll()
                        .map(p1 -> new Line2D.Double(p, p1)))
                .min(Comparator.comparingDouble(line -> line.getP1().distance(line.getP2())))
                .orElseThrow();
    }

    @Value
    public static class SideCenters {
        Point2D.Double up;
        Point2D.Double left;
        Point2D.Double right;
        Point2D.Double down;

        public Stream<Point2D.Double> getAll() {
            return Stream.of(up, left, right, down);
        }

        public SideCenters(Point location, Dimension size) {
            double leftX = location.getX();
            double rightX = leftX + size.getWidth();
            double upY = location.getY();
            double downY = upY + size.getHeight();
            double centerX = leftX + size.getWidth() / 2;
            double centerY = upY + size.getHeight() / 2;
            this.up = new Point2D.Double(centerX, upY);
            this.left = new Point2D.Double(leftX, centerY);
            this.right = new Point2D.Double(rightX, centerY);
            this.down = new Point2D.Double(centerX, downY);
        }
    }


}
