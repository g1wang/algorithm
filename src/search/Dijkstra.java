package search;

import java.util.*;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/26 22:36
 */
public class Dijkstra {

    public static void main(String[] args) {
        List<Integer> node = new ArrayList<>();
        int[][] weights = new int[][]{{0, 0, 10, 0, 30, 100},
                {0, 0, 5, 0, 0, 0},
                {0, 0, 0, 50, 0, 0},
                {0, 0, 0, 0, 0, 10},
                {0, 0, 0, 20, 0, 60},
                {0, 0, 0, 0, 0, 0}};
        int start = 0;
        int[] dist = dijkstra(weights, 0);
        for (int i = 0; i < dist.length; i++) {

            System.out.println(dist[i]);
        }
    }


    /*
     *
     * AP1：使用open close，
     * AP2: 只用close，比较的时候直接用dist数组,根据close做终止判断
     * @param null
     * @author CodeX
     * @date 2021/4/27
     * @return
     */


    private static int[] dijkstra(int[][] weights, int start) {
        HashSet<Integer> close = new HashSet();
        Map<Integer, Integer> open = new HashMap<>();

        int[] dist = new int[weights.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = i == start ? 0 : Integer.MAX_VALUE;
        }
        open.put(start, 0);

        int closest = start;
        while (!open.isEmpty()) {
            //find closest
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : open.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value < min) {
                    min = entry.getValue();
                    closest = key;
                }
            }
            open.remove(closest);
            close.add(closest);
            for (int i = 0; i < weights[closest].length; i++) {
                int weight = weights[closest][i];
                if (weight != 0) {
                    if (weight + dist[closest] < dist[i]) {
                        dist[i] = weight + dist[closest];
                    }
                    if (!close.contains(i)) open.put(i, dist[i]);
                }
            }

        }
        return dist;
    }
}



