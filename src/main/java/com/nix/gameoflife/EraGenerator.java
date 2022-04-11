package com.nix.gameoflife;

import java.util.concurrent.ThreadLocalRandom;

public class EraGenerator {

    public boolean[][] generateStartingEra() {
        boolean[][] data = new boolean[25][25];
        for (int i = 9; i < 16; i++) {
            for (int j = 9; j < 16; j++) {
                data[i][j] = ThreadLocalRandom.current().nextBoolean();
            }
        }
        return data;
    }

    public boolean[][] generateNewEra(boolean[][] currentEra) {
        boolean[][] newEra = new boolean[currentEra.length][currentEra[0].length];
        for (int i = 1; i < currentEra.length - 1; i++) {
            for (int j = 1; j < currentEra[i].length - 1; j++) {
                int numberOfLifeCells = calculateLifeCells(currentEra, i, j);
                if ((currentEra[i][j] && numberOfLifeCells > 1 && numberOfLifeCells < 4) || (!currentEra[i][j] && numberOfLifeCells == 3)) {
                    newEra[i][j] = true;
                }
            }
        }
        return newEra;
    }


    private int calculateLifeCells(boolean[][] data, int pointI, int pointJ) {
        int counter = 0;
        for (int i = pointJ - 1; i <= pointJ + 1; i++) {
            if (data[pointI - 1][i]) {
                counter++;
            }
            if (data[pointI + 1][i]) {
                counter++;
            }
        }
        if (data[pointI][pointJ + 1]) {
            counter++;
        }
        if (data[pointI][pointJ - 1]) {
            counter++;
        }
        return counter;
    }
}
