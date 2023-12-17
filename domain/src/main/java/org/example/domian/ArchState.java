package org.example.domian;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Jacksonized
public class ArchState implements StateElement{

    @Builder.Default
    UUID id = UUID.randomUUID();
    @Builder.Default
    List<ArchLabel> labels = List.of();


    public static ArchState empty() {
        return ArchState.builder()
                .build();
    }

    public static ArchState def() {
        return ArchState.builder()
                .labels(List.of(
                        ArchLabel.builder().value("first").build(),
                        ArchLabel.builder().value("second").build()
                ))
                .build();
    }
}
