package org.example.gui;

import org.example.model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Enumeration;

public class WorkSpaceLayoutSelector extends JPanel {

    private final Model model;
    private final ButtonGroup buttonGroup;

    public WorkSpaceLayoutSelector(Model model) {
        this.model = model;
        setBackground(Color.WHITE);
        buttonGroup = new ButtonGroup();
        Arrays.stream(LayoutType.values())
                .map(WorkSpaceLayoutSelector::buildRadioButton)
                .peek(buttonGroup::add)
                .peek(button -> button.addActionListener(e -> setActiveLayoutType(getSelected(buttonGroup))))
                .forEach(this::add);
        setLayout(new GridLayout(buttonGroup.getButtonCount(), 1));
    }

    public synchronized void setActiveLayoutType(LayoutType layoutType) {
        buttonGroup.setSelected(getButton(layoutType), true);
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

    private ButtonModel getButton(LayoutType layoutType) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.getText().equals(layoutType.getValue())) {
                return button.getModel();
            }
        }
        throw new IllegalStateException();
    }

    private static JRadioButton buildRadioButton(LayoutType layout) {
        return new JRadioButton(layout.getValue(), layout.isSelected());
    }

}
