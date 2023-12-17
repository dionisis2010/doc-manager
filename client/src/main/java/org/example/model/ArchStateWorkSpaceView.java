package org.example.model;

import org.example.domian.ArchState;

import javax.swing.*;


public class ArchStateWorkSpaceView implements ModelView<ArchState, JComponent> {

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public ArchState getState() {
        return null;
    }

    @Override
    public void update(ArchState newState) {

    }
}
