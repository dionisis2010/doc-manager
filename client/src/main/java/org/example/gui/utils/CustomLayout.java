package org.example.gui.utils;

import lombok.RequiredArgsConstructor;
import org.example.gui.VisualComponent;
import org.example.model.Model;

import java.awt.*;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class CustomLayout implements LayoutManager {

    private final Model model;

    @Override
    public void addLayoutComponent(String name, Component component) {
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
    public void layoutContainer(Container container) {
        Arrays.stream(container.getComponents())
                .forEach(component -> ifCustomisingSupported(component,
                                id -> model.getViewSettings(getId(component))
                                        .ifPresent(settings -> {
                                            component.setSize(settings.getCustomSize());
                                            component.setLocation(settings.getCustomLocation());
                                        })
                        )
                );
    }

    private void ifCustomisingSupported(Component component, Consumer<UUID> customer) {
        try {
            UUID id = getId(component);
            customer.accept(id);
        } catch (IllegalArgumentException e) {
            System.err.println(component.getName());
        }
    }

    private static UUID getId(Component component) {
        return UUID.fromString(component.getName());
    }
}
