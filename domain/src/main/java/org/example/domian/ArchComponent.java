package org.example.domian;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class ArchComponent implements StateElement {

    @Builder.Default
    UUID id = UUID.randomUUID();
    String name;
    @Builder.Default
    List<ArchRelation> relations = new ArrayList<>();
    @Builder.Default
    List<ArchComponent> components = new ArrayList<>();

    public void bind(ArchComponent component, ArchRelationType type, ArchRelationDirection direction) {
        ArchRelation relation = ArchRelation.builder()
                .holder(this)
                .dependency(component)
                .type(type)
                .direction(direction)
                .build();
        relations.add(relation);
        component.getRelations().add(relation);
    }

}
