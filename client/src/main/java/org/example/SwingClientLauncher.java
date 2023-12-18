package org.example;

import org.example.gui.ClientApplication;
import org.example.gui.MenuWorkSpase;
import org.example.gui.TextWorkSpace;
import org.example.gui.VisualWorkSpase;
import org.example.gui.WorkSpaceLayoutSelector;
import org.example.gui.utils.CustomLayout;
import org.example.gui.utils.MouseAdapterFactory;
import org.example.gui.utils.Screen;
import org.example.model.Model;
import org.example.model.ViewFactory;
import org.example.utils.JsonMapper;

import java.awt.*;

public class SwingClientLauncher {
    public static void main(String[] args) {
        Context.init(Model.class);
        Context.init(CustomLayout.class);
        Context.init(JsonMapper.class);
        Context.initJComponent(WorkSpaceLayoutSelector.class, 150, 200);
        Context.init(MouseAdapterFactory.class);
        Context.init(ViewFactory.class);
        Context.initJComponent(VisualWorkSpase.class, 500, 700);
        Context.initJComponent(TextWorkSpace.class, 500, 300);
        Context.initJComponent(MenuWorkSpase.class, 500, 500);
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Context.register("screen", new Screen(graphicsEnvironment.getScreenDevices()[0]));

        Context.initFrame(ClientApplication.class, 1000, 800).run();
    }
}