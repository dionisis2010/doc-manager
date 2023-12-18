package org.example.gui;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.Context;
import org.example.gui.utils.CustomLayout;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Supplier;

@Getter
@RequiredArgsConstructor
public enum LayoutType {

    FLOW("flow",true, () -> new FlowLayout()),
    GRID("grid",false, () -> new BorderLayout()),
    BORDER("border",false, () -> new GridLayout()),
    CUSTOM("custom",false, () -> Context.get(CustomLayout.class));

    private final String value;
    private final boolean isSelected;
    private final Supplier<LayoutManager> layout;

    public static LayoutType getSelectedByDefault() {
        return Arrays.stream(values())
                .filter(LayoutType::isSelected)
                .findFirst()
                .orElseThrow();
    }

    public static LayoutType getByValue(String value) {
        return valueOf(value.toUpperCase());
    }
}
