package org.example.model.label;

import org.example.domian.ArchLabel;

import java.util.List;

public class DisplayedArchLabel implements ModelMultiView<ArchLabel, ModelView<ArchLabel, ?>> {

    @Override
    public ArchLabel getState() {
        return null;
    }

    @Override
    public List<ModelView<ArchLabel, ?>> getViews() {
        return null;
    }
}
