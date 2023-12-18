package org.example.gui;

import org.example.Context;
import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Enumeration;

public class WorkSpaceLayoutSelector extends JPanel {

    private final Model model;

    public WorkSpaceLayoutSelector(Model model) {
        this.model = model;
        setBackground(Color.WHITE);
        ButtonGroup buttonGroup = new ButtonGroup();
        Arrays.stream(LayoutType.values())
                .map(layoutType -> buildRadioButton(layoutType))
                .peek(buttonGroup::add)
                .peek(button -> button.addActionListener(e -> setActiveLayoutType(getSelected(buttonGroup))))
                .forEach(this::add);
        setLayout(new GridLayout(buttonGroup.getButtonCount(), 1));
        setActiveLayoutType(getSelected(buttonGroup));
    }

    public synchronized void setActiveLayoutType(LayoutType layoutType) {
        model.setActiveLayoutType(layoutType);
    }

    private synchronized LayoutType getSelected(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return LayoutType.getByValue(button.getText());
            }
        }
        throw new IllegalStateException();
    }

    private static JRadioButton buildRadioButton(LayoutType layout) {
        return buildRadioButton(layout.getValue(), layout.isSelected(), layout.getLayout().get());
    }

    private static JRadioButton buildRadioButton(String name, boolean selected, LayoutManager layout) {
        JRadioButton flow = new JRadioButton(name, selected);
        flow.addActionListener(e -> {
                    VisualWorkSpase visualWorkSpase = Context.get(VisualWorkSpase.class);
                    visualWorkSpase.setLayout(layout);
                    visualWorkSpase.repaint();
                }
        );
        return flow;
    }
}
