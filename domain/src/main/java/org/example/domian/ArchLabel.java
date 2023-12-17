package org.example.domian;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ArchLabel implements StateElement {

    String value;

}
