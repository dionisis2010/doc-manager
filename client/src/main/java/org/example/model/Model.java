package org.example.model;

import lombok.Getter;
import org.example.domian.StateElement;
import org.example.gui.LayoutType;
import org.example.gui.VisualWorkSpase;
import org.example.gui.WorkSpace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Model {

    private final Map<UUID, StateElement> state = new HashMap<>();
    private final Map<UUID, ViewSettings> viewSettings = new HashMap<>();
    private final List<WorkSpace> workSpaces = new ArrayList<>();
    @Getter
    private LayoutType activeLayoutType = LayoutType.getSelectedByDefault();

    public synchronized void setActiveLayoutType(LayoutType layoutType) {
        this.activeLayoutType = layoutType;
        getVisualWorkSpace().setLayout(layoutType.getLayout().get());
        update();
    }

    private VisualWorkSpase getVisualWorkSpace() {
        return workSpaces.stream()
                .filter(workSpace -> workSpace instanceof VisualWorkSpase)
                .map(VisualWorkSpase.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    public void addWorkSpace(WorkSpace workSpace) {
        workSpaces.add(workSpace);
    }

    public synchronized void upsert(UUID id, ViewSettings newViewSettings) {
        viewSettings.put(id, newViewSettings);
    }

    public Optional<ViewSettings> getViewSettings(UUID id) {
        return Optional.ofNullable(viewSettings.get(id));
    }

    public synchronized void update(List<? extends StateElement> stateElements) {
        state.clear();
        stateElements.forEach(element -> state.put(element.getId(), element));
        update();
    }

    public void update() {
        workSpaces.forEach(WorkSpace::render);
    }

    public Collection<StateElement> getAllElements() {
        return state.values();
    }

}
