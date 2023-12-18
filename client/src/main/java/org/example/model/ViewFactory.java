package org.example.model;

import lombok.RequiredArgsConstructor;
import org.example.Context;
import org.example.domian.ArchLabel;
import org.example.domian.StateElement;
import org.example.gui.utils.MouseAdapterFactory;
import org.example.gui.utils.MouseMoveAdapter;
import org.example.gui.utils.StyleCustomizer;

import javax.swing.*;
import java.awt.*;

@RequiredArgsConstructor
public class ViewFactory {

    private final MouseAdapterFactory mouseAdapterFactory;

    public JComponent createAuto(StateElement stateElement) {
        if (stateElement instanceof ArchLabel) {
            return create((ArchLabel) stateElement);
        } else {
            throw new UnsupportedOperationException();
        }
    }
    public JLabel create(ArchLabel archLabel) {
        JLabel jLabel = new JLabel();
        jLabel.setName(archLabel.getId().toString());
        jLabel.setPreferredSize(new Dimension(100, 100));
        jLabel.setText(archLabel.getValue());
        StyleCustomizer.setBorder(jLabel);
        jLabel.addMouseListener(mouseAdapterFactory.create(jLabel));
        return jLabel;
    }
}
