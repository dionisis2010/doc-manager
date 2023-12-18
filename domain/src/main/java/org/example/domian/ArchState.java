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
