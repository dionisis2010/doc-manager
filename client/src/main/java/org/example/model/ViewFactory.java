package org.example.model;

import lombok.RequiredArgsConstructor;
import org.example.domian.ArchComponent;
import org.example.domian.ArchRelation;
import org.example.domian.StateElement;
import org.example.gui.utils.MouseAdapterFactory;
import org.example.gui.utils.StyleCustomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

@RequiredArgsConstructor
public class ViewFactory {

    private final MouseAdapterFactory mouseAdapterFactory;

    public JComponent createAuto(StateElement stateElement) {
        if (stateElement instanceof ArchComponent) {
            return create((ArchComponent) stateElement);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public JLabel create(ArchComponent archLabel) {
        JLabel jLabel = new JLabel();
        jLabel.setName(archLabel.getId().toString());
        jLabel.setPreferredSize(new Dimension(100, 100));
        jLabel.setText(archLabel.getName());
        StyleCustomizer.setBorder(jLabel);
        jLabel.addMouseListener(mouseAdapterFactory.create(jLabel));
        return jLabel;
    }
}
