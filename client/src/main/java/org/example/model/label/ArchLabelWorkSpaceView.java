package org.example.model.label;

import org.example.domian.ArchLabel;
import org.example.domian.ArchState;

import javax.swing.*;


public class ArchLabelWorkSpaceView extends JLabel
        implements ModelView<ArchLabel, JLabel, ArchState,> {

    @Override
    public ArchLabel getState() {
        return null;
    }

    @Override
    public void update(ArchLabel newState) {

    }
}
