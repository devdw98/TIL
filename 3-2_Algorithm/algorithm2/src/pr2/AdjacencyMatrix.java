package pr2;

public class AdjacencyMatrix {
    private boolean[][] matrix;
    private int vertex;

    public AdjacencyMatrix(int vertex) {
        matrix = new boolean[vertex][vertex];
    }
    void addDirectionalEdge(int i, int j){
        matrix[i][j] = true;
    }
    void removeDirectionalEdge(int i, int j){
        matrix[i][j] = false;
    }
}
