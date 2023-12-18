package org.example.gui.utils;

import lombok.RequiredArgsConstructor;
import org.example.gui.LayoutType;
import org.example.gui.WorkSpaceLayoutSelector;
import org.example.model.Model;
import org.example.model.ViewSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

@RequiredArgsConstructor
public class MouseMoveAdapter extends MouseAdapter {

    private final Model model;
    private final WorkSpaceLayoutSelector selector;
    private final JComponent component;
    private Point pressPosition = null;

    @Override
    public void mousePressed(MouseEvent e) {
        pressPosition = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point releasedPoint = e.getPoint();
        Point newPoint = new Point(component.getX() + releasedPoint.x - pressPosition.x,
                component.getY() + releasedPoint.y - pressPosition.y);
        component.setLocation(newPoint);

        model.upsert(UUID.fromString(component.getName()), ViewSettings.of(component));
        selector.setActiveLayoutType(LayoutType.CUSTOM);
    }
}
