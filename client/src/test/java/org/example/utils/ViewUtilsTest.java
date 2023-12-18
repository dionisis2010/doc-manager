package org.example.utils;

import org.example.utils.ViewUtils.SideCenters;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewUtilsTest {

    @Test
    void name() {
        SideCenters sideCenters = new SideCenters(new Point(1, 1), new Dimension(2, 2));
        assertEquals(2, sideCenters.getUp().getX());
        assertEquals(1, sideCenters.getUp().getY());
        assertEquals(1, sideCenters.getLeft().getX());
        assertEquals(2, sideCenters.getLeft().getY());
        assertEquals(3, sideCenters.getRight().getX());
        assertEquals(2, sideCenters.getRight().getY());
        assertEquals(2, sideCenters.getDown().getX());
        assertEquals(3, sideCenters.getDown().getY());
    }
}