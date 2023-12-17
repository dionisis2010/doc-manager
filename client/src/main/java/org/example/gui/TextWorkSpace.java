package org.example.gui;

import org.example.gui.utils.StyleCustomizer;

import javax.swing.*;
import java.awt.*;

public class TextWorkSpace extends JTextArea {

    public TextWorkSpace(Dimension dimension) {
        StyleCustomizer.setBorder(this);
        setPreferredSize(dimension);
    }
}
