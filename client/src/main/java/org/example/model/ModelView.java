package org.example.model;

import org.example.domian.StateElement;

import javax.swing.*;

public interface ModelView<S extends StateElement, V extends JComponent> {

    S getState();
    V getView();
}
