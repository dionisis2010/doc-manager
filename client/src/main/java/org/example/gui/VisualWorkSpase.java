package org.example.gui;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.domian.ArchRelation;
import org.example.model.Model;
import org.example.model.ViewFactory;
import org.example.utils.ViewUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class VisualWorkSpase extends JPanel implements WorkSpace {

    private final Model model;
    private final ViewFactory viewFactory;

    private final Map<UUID, RelationView> relationViews = new HashMap<>();
    private final Map<UUID, JComponent> components = new HashMap<>();

    public synchronized void clear() {
        removeAll();
        relationViews.clear();
        components.clear();
    }

    public synchronized void render() {
        clear();
        model.getAllElements()
                .forEach(element -> components.put(element.getId(), viewFactory.createAuto(element)));
        model.getAllElements().stream()
                .flatMap(element -> element.getRelations().stream())
                .distinct()
                .map(this::createRelationView)
                .forEach(relationView -> relationViews.put(relationView.getId(), relationView));
        components.values().forEach(this::add);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        relationViews.values().stream()
                .map(RelationView::resolveLine)
                .forEach(g2::draw);
    }

    private RelationView createRelationView(ArchRelation relation) {
        return RelationView.of(relation.getId(), components.get(relation.getHolder().getId()), components.get(relation.getDependency().getId()));
    }

    @Value(staticConstructor = "of")
    public static class RelationView {
        @NonNull
        UUID id;
        @NonNull
        JComponent first;
        @NonNull
        JComponent second;

        public Line2D resolveLine() {
            return ViewUtils.resolveLine(first.getLocation(), first.getSize(), second.getLocation(), second.getSize());
        }
    }

}
