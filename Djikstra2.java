import java.util.*;

public class Djikstra2{
    //
    public int[] findNeighbors(int[][] a, int v) {
        int[] result;
        int n = 0;
        
        for (int i = 0; i < a[v].length; i++) {
            if (a[v][i] != 0) 
                n++;
        }
        
        result = new int[n];
        int index = 0;
        
        for (int i = 0; i < a[v].length; i++) {
            if (a[v][i] != 0) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }
    
    //
    public int findMinDistInQueue(int[] dist, List<Integer> queue) {
        int min = dist[0];
        int indexMin = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (dist[queue.get(i)] < min) {
                min = dist[queue.get(i)];
                indexMin = queue.get(i);
            }
        }
        return indexMin;
    }
    
    
    //
    public int[] djikstra(int[][] a, int x, int y)
    {
        x -= 1;
        y -= 1;
        List<Integer> queue = new ArrayList<>();
        int[] dist = new int[a.length];
        int[] prev = new int[a.length];
        
        for (int i = 0; i < a.length; i++) {
            dist[i] = 999999;
            prev[i] = -1;
            queue.add(i);
        } 
        
        dist[x] = 0;
        
        while (queue.size() != 0) {
            int u =  findMinDistInQueue(dist, queue);
            queue.remove(u);
            
            int[] neighbors = findNeighbors(a, u);
            for (int i = 0; i < neighbors.length; i++) {
                int d = dist[u] + a[u][neighbors[i]];
                if (d < dist[neighbors[i]]) {
                    dist[neighbors[i]] = d;
                    prev[neighbors[i]] = u;
                }
            }
        }

        
        //
        List<Integer> path = new ArrayList<>();
        
        int temp = y;
        while (temp != x) {
            path.add(temp);
            temp = prev[temp];
        }
        path.add(x);
        
        int[] result = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(path.size() - i - 1);
        }
        
        return result;
    }
    
    
}