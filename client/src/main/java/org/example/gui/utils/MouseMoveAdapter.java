package org.example.gui.utils;

import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@RequiredArgsConstructor
public class MouseMoveAdapter extends MouseAdapter {

    private final Component component;
    private Point pressPosition = null;

    @Override
    public void mousePressed(MouseEvent e) {
        pressPosition = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point releasedPoint = e.getPoint();
        component.setLocation(
                component.getX() + releasedPoint.x - pressPosition.x,
                component.getY() + releasedPoint.y - pressPosition.y
        );
    }
}
