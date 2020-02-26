package model;

import java.util.*;

public class SugarHigh {
    private int[] candies;
    private int threshold;
    private Map<Integer, ArrayList<Integer>> initialCandiesIndices = new HashMap<>();

    public SugarHigh(int[] candies, int threshold) {
        this.candies = candies;
        this.threshold = threshold;
    }

    public int[] getIndicesOfCandiesToEat() {
        for (int i = 0; i < candies.length; i++) {
            if (!initialCandiesIndices.containsKey(candies[i])) {
                initialCandiesIndices.put(candies[i], new ArrayList<>());
            }

            initialCandiesIndices.get(candies[i]).add(i);
        }

        Arrays.sort(candies);
        return findMaxCandiesToEat();
    }

    private int[] findMaxCandiesToEat() {
        List<Integer> result = new ArrayList<>();
        int currentThreshold = 0;
        for (int currentCandy : candies) {
            if (currentThreshold + currentCandy < threshold) {
                currentThreshold += currentCandy;
                result.add(initialCandiesIndices.get(currentCandy).get(0));
                initialCandiesIndices.get(currentCandy).remove(0);
            } else {
                break;
            }
        }

        return result.stream().mapToInt(e -> e).sorted().toArray();
    }
}
