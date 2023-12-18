package org.example.domian;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class ArchState {

    @Builder.Default
    List<ArchComponent> components = List.of();


    public static ArchState empty() {
        return ArchState.builder()
                .build();
    }

    public static ArchState def() {
        ArchComponent first = ArchComponent.builder().name("first").build();
        ArchComponent second = ArchComponent.builder().name("second").build();
        first.bind(second, ArchRelationType.SIMPLE, ArchRelationDirection.NONE);
        return ArchState.builder()
                .components(List.of(
                        first,
                        second
                ))
                .build();
    }
}
