package org.example.gui;

import org.example.gui.utils.CustomLayout;
import org.example.gui.utils.StyleCustomizer;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class WorkSpaceLayoutSelector extends JPanel {

    public WorkSpaceLayoutSelector(VisualWorkSpase visualWorkSpase, Dimension dimension) {
        setBackground(Color.WHITE);
        StyleCustomizer.setBorder(this);
        setPreferredSize(dimension);
        ButtonGroup buttonGroup = new ButtonGroup();
        Stream.of(
                        buildRadioButton(visualWorkSpase, "flow", true, new FlowLayout()),
                        buildRadioButton(visualWorkSpase, "border", false, new BorderLayout()),
                        buildRadioButton(visualWorkSpase, "grid", false, new GridLayout()),
                        buildRadioButton(visualWorkSpase, "custom", false, new CustomLayout())
                )
                .peek(buttonGroup::add)
                .forEach(this::add);
        setLayout(new GridLayout(buttonGroup.getButtonCount(), 1));
    }

    private static JRadioButton buildRadioButton(VisualWorkSpase visualWorkSpase, String name, boolean selected, LayoutManager layout) {
        JRadioButton flow = new JRadioButton(name, selected);
        flow.addActionListener(e -> {
                    visualWorkSpase.setLayout(layout);
                    visualWorkSpase.repaint();
                }
        );
        return flow;
    }
}
