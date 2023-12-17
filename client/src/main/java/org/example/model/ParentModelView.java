package org.example.model;

import org.example.domian.StateElement;

import javax.swing.*;
import java.util.List;

public interface ParentModelView<S extends StateElement, V extends JComponent>
        extends ModelView<S, V> {

    List<NestedModelView<?, ?, ParentModelView<S, V>>> getNestedViews();
}
