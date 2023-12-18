package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.awt.*;

@Data
@Builder
public class ViewSettings {

    private Point customLocation;
    private Dimension customSize;

    public static ViewSettings of(Component component){
        return ViewSettings.builder()
                .customLocation(component.getLocation())
                .customSize(component.getSize())
                .build();
    }
}
