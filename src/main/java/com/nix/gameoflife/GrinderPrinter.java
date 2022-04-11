package com.nix.gameoflife;

public class GrinderPrinter {

    public void print(boolean[][] data, int eraNumber) {
        System.out.println("ERA # "+ eraNumber);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
