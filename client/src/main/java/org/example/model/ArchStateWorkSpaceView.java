package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.model.label.ArchLabelWorkSpaceView;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ArchStateWorkSpaceView {

    @Builder.Default
    List<ArchLabelWorkSpaceView> labels = new ArrayList<>();
}
