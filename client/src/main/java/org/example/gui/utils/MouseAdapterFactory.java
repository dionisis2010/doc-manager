package org.example.gui.utils;

import lombok.RequiredArgsConstructor;

import javax.swing.*;

@RequiredArgsConstructor
public class MouseAdapterFactory {

    public MouseMoveAdapter create(JComponent component) {
        return new MouseMoveAdapter(component);
    }
}
