package org.example.gui;

import lombok.RequiredArgsConstructor;
import org.example.domian.StateElement;
import org.example.model.Model;
import org.example.model.ViewFactory;
import org.example.model.ViewSettings;

import javax.swing.*;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VisualWorkSpase extends JPanel implements WorkSpace {

    private final Model model;
    private final ViewFactory viewFactory;

    public synchronized void clear() {
        removeAll();
        repaint();
    }

    public synchronized void render() {
        clear();
        Map<UUID, JComponent> components = model.getAllElements().stream()
                .collect(Collectors.toMap(StateElement::getId, viewFactory::createAuto));
        components.values().forEach(this::add);
        revalidate();
        repaint();
        components.forEach((uuid, component) -> model.upsert(uuid, ViewSettings.of(component)));
    }
}
