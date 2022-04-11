package com.nix.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrinderFormatterTest {

    private GrinderFormatter unit = new GrinderFormatter();

    @Test
    void format2x2Data() {
        //given
        boolean[][] input = {{true, false}, {false, true}};

        //when
        boolean[][] actual = unit.format(input);

        //then
        boolean[][] expected = new boolean[25][25];
        expected[12][12] = true;
        expected[13][13] = true;
        assertArrayEquals(expected, actual);
    }

    @Test
    void format2x3Data() {
        //given
        boolean[][] input = {{true, false, true}, {false, true, true}};

        //when
        boolean[][] actual = unit.format(input);

        //then
        boolean[][] expected = new boolean[25][25];
        expected[12][11] = true;
        expected[12][13] = true;
        expected[13][12] = true;
        expected[13][13] = true;
        assertArrayEquals(expected, actual);
    }

    @Test
    void format3x5Data() {
        //given
        boolean[][] input = {{true, false, true, true, true}, {false, true, true, true, true}, {true, false, false, true, true}};

        //when
        boolean[][] actual = unit.format(input);

        //then
        boolean[][] expected = new boolean[25][25];
        expected[11][10] = true;
        expected[11][12] = true;
        expected[11][13] = true;
        expected[11][14] = true;
        expected[12][11] = true;
        expected[12][12] = true;
        expected[12][13] = true;
        expected[12][14] = true;
        expected[13][10] = true;
        expected[13][13] = true;
        expected[13][14] = true;
        assertArrayEquals(expected, actual);
    }
}
