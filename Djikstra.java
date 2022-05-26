public class Djikstra {
    public int[] djikstra(int[][] a, int x, int y) {
        int start = x - 1;
        int end = y - 1;

        int n  = a.length;

        int[] L = new int[n];
        int[] trace = new int[n];

        for (int i = 0; i < n; i++) {
            L[i] = 99999;
            trace[i] = -1;
        }

        L[start] = 0;

        boolean next = true;

        while(next) {
            next = false;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && a[j][i] > 0 && L[i] > L[j] + a[j][i]) {
                        L[i] = L[j] + a[i][j];
                        trace[i] = j;
                        next = true;
                    }
                }
            }
        } 

        int t = end;

        int count = 0;
        while (t != -1 && count < n) {
            //System.out.println(t);
            t = trace[t];
            count++;
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(i + ":<-" + trace[i]);
        // }

        int[] result = new int[count];

        t = end;

        while (t != -1 && count > 0) {
            //System.out.println(t);

            result[count - 1] = t + 1;
            t = trace[t];
            count--;
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}