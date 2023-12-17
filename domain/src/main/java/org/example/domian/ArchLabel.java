package org.example.domian;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class ArchLabel implements StateElement {

    @Builder.Default
    UUID id = UUID.randomUUID();
    String value;

}
