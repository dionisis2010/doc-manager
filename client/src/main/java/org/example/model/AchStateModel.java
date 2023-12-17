package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.domian.ArchState;
import org.example.model.label.DisplayedArchLabel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class AchStateModel implements ModelMultiView<ArchState, ModelView<ArchState, JPanel, ?, ?>> {

    @Builder.Default
    List<DisplayedArchLabel> labels = new ArrayList<>();

    @Override
    public ArchState getState() {
        return null;
    }

    @Override
    public List<? extends ModelView<ArchState, JPanel, ?, ?>> getViews() {
        return null;
    }

}
