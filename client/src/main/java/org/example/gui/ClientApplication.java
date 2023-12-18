package org.example.gui;

import org.example.domian.ArchState;
import org.example.gui.utils.Screen;
import org.example.gui.utils.StyleCustomizer;
import org.example.model.Model;

import javax.swing.*;
import java.awt.*;

public class ClientApplication extends JFrame {

    private final Model model;
    private final TextWorkSpace textWorkSpace;
    private final VisualWorkSpase visualWorkSpase;
    private final MenuWorkSpase menuWorkSpase;
    private final WorkSpaceLayoutSelector workSpaceLayoutSelector;

    public ClientApplication(Screen secondScreen,
                             Model model,
                             VisualWorkSpase visualWorkSpase,
                             TextWorkSpace textWorkSpace,
                             MenuWorkSpase menuWorkSpase,
                             WorkSpaceLayoutSelector workSpaceLayoutSelector) {
        super(secondScreen.getConfiguration());
        this.model = model;
        this.visualWorkSpase = visualWorkSpase;
        this.textWorkSpace = textWorkSpace;
        this.menuWorkSpase = menuWorkSpase;
        this.workSpaceLayoutSelector = workSpaceLayoutSelector;

        setSize(1500, 1100);
        setLocation(getX() + 100, getY() + 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout());
        panel.setBackground(Color.DARK_GRAY);
        getContentPane().add(panel);

        JPanel confPanel = new JPanel();
        StyleCustomizer.setBorder(confPanel);
        confPanel.setLayout(new BoxLayout(confPanel, BoxLayout.Y_AXIS));

        JButton refreshButton = new JButton("обновить");
        refreshButton.setPreferredSize(new Dimension(150, 30));
        refreshButton.addActionListener(e -> model.update());

        panel.add(visualWorkSpase);
        panel.add(confPanel);

        confPanel.add(workSpaceLayoutSelector);
        confPanel.add(refreshButton);
        confPanel.add(textWorkSpace);

        model.addWorkSpace(textWorkSpace);
        model.addWorkSpace(visualWorkSpase);
        model.addWorkSpace(menuWorkSpase);


        model.update(ArchState.def().getLabels());
    }

    public void run() {
        setVisible(true);
    }
}
