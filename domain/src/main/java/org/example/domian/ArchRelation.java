package org.example.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class ArchRelation implements StateElement {

    @Builder.Default
    UUID id = UUID.randomUUID();
    @NonNull
    ArchRelationDirection direction;
    @NonNull
    ArchRelationType type;
    @NonNull
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    ArchComponent holder;
    @NonNull
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    ArchComponent dependency;

}
