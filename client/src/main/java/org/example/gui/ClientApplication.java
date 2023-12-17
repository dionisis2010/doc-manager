package org.example.gui;

import org.example.domian.ArchState;
import org.example.gui.utils.Screen;
import org.example.gui.utils.StyleCustomizer;
import org.example.utils.JsonMapper;

import javax.swing.*;
import java.awt.*;

//@RequiredArgsConstructor
public class ClientApplication extends JFrame {

    private final JsonMapper jsonMapper = new JsonMapper();
    private final ArchState state = ArchState.def();


    public ClientApplication(Screen secondScreen) {
        super(secondScreen.getConfiguration());
        setSize(1500, 1100);
        setLocation(getX() + 100, getY() + 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout());
        panel.setBackground(Color.DARK_GRAY);
        getContentPane().add(panel);

        VisualWorkSpase visualWorkSpase = new VisualWorkSpase(new Dimension(1000, 1000));

        JPanel confPanel = new JPanel();
        StyleCustomizer.setBorder(confPanel);
        confPanel.setLayout(new BoxLayout(confPanel, BoxLayout.Y_AXIS));

        TextWorkSpace textWorkSpace = new TextWorkSpace(new Dimension(500, 900));
        textWorkSpace.setText(jsonMapper.toJson(state));

        JButton refreshButton = new JButton("обновить");
        refreshButton.setPreferredSize(new Dimension(150, 30));
        refreshButton.addActionListener(e -> {
            visualWorkSpase.render(jsonMapper.readState(textWorkSpace.getText()));
        });

        WorkSpaceLayoutSelector workSpaceLayoutSelector = new WorkSpaceLayoutSelector(visualWorkSpase, new Dimension(150, 200));

        panel.add(visualWorkSpase);
        panel.add(confPanel);

        confPanel.add(workSpaceLayoutSelector);
        confPanel.add(refreshButton);
        confPanel.add(textWorkSpace);

    }

    public void run() {
        setVisible(true);
    }
}
