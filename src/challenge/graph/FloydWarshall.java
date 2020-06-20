package challenge.graph;

public class FloydWarshall {
    final int MAX_V = 1000, MAX_E = 1000;
    int d[][] = new int[MAX_V][MAX_V];
    int V;
    //复杂度O(|V|^3)
    void warshallFloyd() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
    }
}
