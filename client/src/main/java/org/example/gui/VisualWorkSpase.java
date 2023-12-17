package org.example.gui;

import org.example.domian.ArchState;
import org.example.gui.utils.StyleCustomizer;
import org.example.model.ArchStateWorkSpaceView;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class VisualWorkSpase extends JPanel {

    public VisualWorkSpase(Dimension dimension) {
        setBackground(Color.WHITE);
        StyleCustomizer.setBorder(this);
    }

    public synchronized void clear() {
        removeAll();
        repaint();
    }

    public synchronized void render(ArchState model) {
        clear();
        ArchStateWorkSpaceView view = ArchStateWorkSpaceView.builder()
                .labels(model.getLabels().stream()
                        .map(label -> JComponentFactory.build(label))
                        .collect(Collectors.toList()))
                .build();
        view.getLabels().forEach(label -> add(label.getView()));
        revalidate();
    }
}
