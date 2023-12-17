package org.example.gui;

import org.example.domian.ArchLabel;
import org.example.model.label.ArchLabelWorkSpaceView;

public class JComponentFactory {

    public static ArchLabelWorkSpaceView build(ArchLabel archLabel) {
        return new ArchLabelWorkSpaceView(archLabel);
    }
}
