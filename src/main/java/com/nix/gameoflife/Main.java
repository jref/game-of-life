package com.nix.gameoflife;

public class Main {

    public static void main(String[] args) {
        EraGenerator eraGenerator = new EraGenerator();
        GrinderPrinter grinderPrinter = new GrinderPrinter();
        boolean[][] era = eraGenerator.generateStartingEra();
        for (int i = 0; i < 100; i++) {
            grinderPrinter.print(era, i);
            era = eraGenerator.generateNewEra(era);
        }
    }
}
