package main;

import model.SugarHigh;

public class Main {

    public static void main(String[] args) {
        SugarHigh sugarHigh = new SugarHigh(new int[]{33, 20, 12, 19, 29}, 33);

        int[] candiesIndices = sugarHigh.getIndicesOfCandiesToEat();
        for (int candiesIndex : candiesIndices) {
            System.out.print(candiesIndex + " ");
        }
    }
}
