package org.example.gui.utils;

import lombok.RequiredArgsConstructor;
import org.example.gui.WorkSpaceLayoutSelector;
import org.example.model.Model;

import javax.swing.*;

@RequiredArgsConstructor
public class MouseAdapterFactory {

    private final Model model;
    private final WorkSpaceLayoutSelector selector;

    public MouseMoveAdapter create(JComponent component) {
        return new MouseMoveAdapter(model, selector, component);
    }
}
