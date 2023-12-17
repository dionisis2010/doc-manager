package org.example.domian;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class ArchState implements StateElement{

    @Builder.Default
    List<ArchLabel> blocks = List.of();


    public static ArchState empty() {
        return ArchState.builder()
                .build();
    }

    public static ArchState def() {
        return ArchState.builder()
                .blocks(List.of(
                        new ArchLabel("first"),
                        new ArchLabel("second")
                ))
                .build();
    }
}
