package org.example.gui;

import org.example.gui.utils.MouseMoveAdapter;
import org.example.domian.ArchState;
import org.example.model.AchStateModel;

import javax.swing.*;
import java.awt.*;

public class WorkSpase extends JPanel {

    public WorkSpase(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public synchronized void clear() {
        removeAll();
        repaint();
    }

    public synchronized void render(AchStateModel state) {
        clear();
        state.getLabels().stream()
                .map(label -> {
                    JLabel jLabel = new JLabel();
                    jLabel.setSize(jLabel.getWidth(), jLabel.getHeight());
                    jLabel.setText(label.getValue());
                    jLabel.setLocation(jLabel.getX(), jLabel.getY());
                    jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    jLabel.addMouseListener(createMouseMoveAdapter(jLabel));
                    return jLabel;
                })
                .forEach(this::add);
        revalidate();
    }

    private MouseMoveAdapter createMouseMoveAdapter(Component component) {
        return new MouseMoveAdapter(component);
    }
}
