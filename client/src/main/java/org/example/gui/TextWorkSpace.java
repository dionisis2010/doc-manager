package org.example.gui;

import lombok.RequiredArgsConstructor;
import org.example.model.Model;
import org.example.utils.JsonMapper;

import javax.swing.*;

@RequiredArgsConstructor
public class TextWorkSpace extends JTextArea implements WorkSpace {


    private final Model model;
    private final JsonMapper jsonMapper;

    @Override
    public void render() {
        setText(jsonMapper.toJson(model.getAllElements()));
    }
}
