package org.example;

import org.example.gui.ClientApplication;
import org.example.gui.utils.Screen;

import java.awt.*;

public class SwingClientLauncher {
    public static void main(String[] args) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Screen secondScreen = new Screen(graphicsEnvironment.getScreenDevices()[1]);

        ClientApplication clientApplication = new ClientApplication(secondScreen);

        clientApplication.run();


    }
}