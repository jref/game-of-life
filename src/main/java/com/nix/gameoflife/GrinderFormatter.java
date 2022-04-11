package com.nix.gameoflife;

public class GrinderFormatter {

    public boolean[][] format(boolean[][] data) {
        boolean[][] formattedData = new boolean[25][25];
        int startI = formattedData.length / 2 - data.length / 2 - data.length % 2 + 1;
        int startJ = formattedData[startI].length / 2 - data[0].length / 2 - data[0].length % 2 + 1;
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, formattedData[startI + i], startJ, data[i].length);
        }
        return formattedData;
    }
}
