package org.example.gui.utils;

import lombok.RequiredArgsConstructor;

import java.awt.*;

@RequiredArgsConstructor
public class Screen {

    private final GraphicsDevice device;


    public GraphicsConfiguration getConfiguration () {
        return device.getDefaultConfiguration();
    }

    public Point resolveLocation() {
        return null;
    }
}
