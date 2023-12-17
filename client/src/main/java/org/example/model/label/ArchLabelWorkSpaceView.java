package org.example.model.label;

import lombok.Getter;
import org.example.domian.ArchLabel;
import org.example.gui.utils.MouseMoveAdapter;
import org.example.gui.utils.StyleCustomizer;
import org.example.model.ModelView;

import javax.swing.*;


@Getter
public class ArchLabelWorkSpaceView extends JLabel implements ModelView<ArchLabel, JLabel> {

    private final ArchLabel state;

    public ArchLabelWorkSpaceView(ArchLabel state) {
        this.state = state;
        setName(state.getId().toString());
        StyleCustomizer.setBorder(this);
        setText(state.getValue());
        addMouseListener(new MouseMoveAdapter(this));
    }

    @Override
    public JLabel getView() {
        return this;
    }
}
