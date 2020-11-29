package Problems.Backpack;

public class BruteForce {
    int[] p;
    int[] v;
    String[] names;
    int n;
    int P;

    int[][] V;
    boolean[][] K;

    public BruteForce(Backpack backpack, int P) {
        this.p = backpack.getWeightItems();
        this.v = backpack.getValueItems();
        this.names = backpack.getNameItems();
        this.P = P;
        this.n = p.length;
        V = new int[n][1 + P];
        K = new boolean[n][1 + P];
    }

    public void printSolution() {
        int i = n - 1;
        int j = P;
        System.out.println("Items:");
        while (i >= 0) {
            if (K[i][j]) {
                System.out.println(names[i] + " weight: " + p[i] + " value: " + v[i]);
                j -= p[i];
            }
            i = i - 1;
        }
    }

    public int solve() {
        int i, j;

        for (i = 0; i < n; ++i) {
            V[i][0] = 0;
            K[i][0] = false;
        }

        for (j = 0; j <= P; ++j) {
            if (j < p[0]) {
                V[0][j] = 0;
                K[0][j] = false;
            } else {
                V[0][j] = v[0];
                K[0][j] = true;
            }
        }

        for (i = 1; i < n; ++i) {
            for (j = 1; j <= P; ++j) {
                if ((j >= p[i]) && (V[i - 1][j - p[i]] + v[i] > V[i - 1][j])) {
                    V[i][j] = V[i - 1][j - p[i]] + v[i];
                    K[i][j] = true;
                } else {
                    V[i][j] = V[i - 1][j];
                    K[i][j] = false;
                }
            }
        }

        return V[n - 1][P];
    }
}
