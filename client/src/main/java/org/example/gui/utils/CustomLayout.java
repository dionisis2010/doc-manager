package org.example.gui.utils;

import lombok.RequiredArgsConstructor;
import org.example.gui.VisualComponent;
import org.example.model.Model;

import java.awt.*;

@RequiredArgsConstructor
public class CustomLayout implements LayoutManager {

    private final Model model;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getSize();
    }

    @Override
    public void layoutContainer(Container component) {
    }
}
