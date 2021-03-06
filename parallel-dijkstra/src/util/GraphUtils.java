package util;

import model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphUtils {

    private static Random random = new Random();

    private GraphUtils() {
    }

    public static Graph generateGraph(int numberOfNodes, int density) {
        List<List<Integer>> edges = new ArrayList<>(numberOfNodes);
        for (int i = 0; i < numberOfNodes; i++) {
            List<Integer> row = new ArrayList<>(numberOfNodes);
            for (int j = 0; j < numberOfNodes; j++) {
                int r = random.nextInt(99) + 1;
                if (i == j) {
                    row.add(j, 0);
                } else if (r <= density) {
                    int val = random.nextInt(1000);
                    row.add(j, val);
                } else {
                    row.add(j, -1);
                }
            }
            edges.add(i, row);
        }
        return new Graph(0, edges);
    }

}
