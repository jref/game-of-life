package com.nix.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EraGeneratorTest {

    private EraGenerator unit = new EraGenerator();

    @Test
    void generateNewEraWithoutChanges() {
        //given
        boolean[][] currentEra = {{false, false, false, false, false},
                {false, true, true, false, false},
                {false, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

        //when
        boolean[][] actual = unit.generateNewEra(currentEra);

        //then
        boolean[][] expected = {{false, false, false, false, false},
                {false, true, true, false, false},
                {false, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    void generateNewEraWithNewLifeCell() {
        //given
        boolean[][] currentEra = {{false, false, false, false, false},
                {false, false, true, false, false},
                {false, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

        //when
        boolean[][] actual = unit.generateNewEra(currentEra);

        //then
        boolean[][] expected = {{false, false, false, false, false},
                {false, true, true, false, false},
                {false, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    void generateNewEraWithDeadCellByUnderpopulation() {
        //given
        boolean[][] currentEra = {{false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

        //when
        boolean[][] actual = unit.generateNewEra(currentEra);

        //then
        boolean[][] expected = new boolean[5][5];
        assertArrayEquals(expected, actual);
    }

    @Test
    void generateNewEraWithDeadCellByOvercrowd1() {
        //given
        boolean[][] currentEra = {{false, false, false, false, false},
                {false, true, true, true, false},
                {false, true, true, true, false},
                {false, true, true, true, false},
                {false, false, false, false, false}};

        //when
        boolean[][] actual = unit.generateNewEra(currentEra);

        //then
        boolean[][] expected = {{false, false, false, false, false},
                {false, true, false, true, false},
                {false, false, false, false, false},
                {false, true, false, true, false},
                {false, false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    void generateNewEraWithAllCases() {
        //given
        boolean[][] currentEra = {{false, false, false, false, false, false},
                {false, false, false, true, false, false},
                {false, true, true, true, true, true},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};

        //when
        boolean[][] actual = unit.generateNewEra(currentEra);

        //then
        boolean[][] expected = {{false, false, false, false, false, false},
                {false, false, false, true, false, false},
                {false, true, false, false, false, false},
                {false, true, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};
        assertArrayEquals(expected, actual);
    }
}
