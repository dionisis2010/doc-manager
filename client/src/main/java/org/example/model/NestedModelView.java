package org.example.model;

import org.example.domian.StateElement;

import javax.swing.*;

public interface NestedModelView<S extends StateElement, V extends JComponent, PV extends ParentModelView<?, ?>>
        extends ModelView<S, V> {

    PV getParent();
}
