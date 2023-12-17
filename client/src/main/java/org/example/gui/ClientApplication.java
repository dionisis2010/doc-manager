package org.example.gui;

import org.example.gui.utils.Screen;
import org.example.gui.utils.SimpleLayout;
import org.example.domian.ArchState;
import org.example.utils.JsonMapper;

import javax.swing.*;
import java.awt.*;

//@RequiredArgsConstructor
public class ClientApplication {

    private final JFrame mainFrame;
    private final Screen secondScreen;
    private final WorkSpase workSpase;
    private final JsonMapper jsonMapper = new JsonMapper();
    private final ArchState state = ArchState.def();


    public ClientApplication(Screen secondScreen) {
        mainFrame = new JFrame(secondScreen.getConfiguration());
        this.secondScreen = secondScreen;
        mainFrame.setSize(1500, 1100);
        mainFrame.setLocation(mainFrame.getX() + 100, mainFrame.getY() + 100);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        mainFrame.getContentPane().add(panel);
        panel.setLayout(new SimpleLayout());

        WorkSpase workSpase = new WorkSpase();
        workSpase.setSize(1000, 1000);
        workSpase.setLocation(10, 10);
        workSpase.setBackground(Color.WHITE);
        workSpase.setLayout(new SimpleLayout());
        panel.add(workSpase);
        this.workSpase = workSpase;

        JTextArea textField = new JTextArea();
        textField.setSize(500, 900);
        textField.setLocation(workSpase.getSize().getSize().width + 50, 50);
        textField.setText(jsonMapper.toJson(state));
        panel.add(textField);

        JButton refreshButton = new JButton("обновить");
        refreshButton.setSize(150, 30);
        refreshButton.setLocation(workSpase.getSize().getSize().width + 50, 10);
        refreshButton.addActionListener(e -> {
            workSpase.render(jsonMapper.readState(textField.getText()));
        });
        panel.add(refreshButton);
    }

    public void run() {
        mainFrame.setVisible(true);
    }
}
