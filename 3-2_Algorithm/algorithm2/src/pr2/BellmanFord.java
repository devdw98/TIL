package pr2;

public class BellmanFord extends SSSP{
    AdjacencyMatrix matrix;
    public BellmanFord(String[] v, AdjacencyMatrix matrix) {
        super(v);
        this.matrix = matrix;
    }

    @Override
    public void algorithm(String[] g, int w, int s) { //G: 그래프 vertex w: weight S: start point
        int i, j, k;
        super.initlaizeSingleSource(g, s); //g 추후에 바꾸기
        for(i = 1; i < g.length-1; i++){
            for(j = 0; j < super.V.length; j++){
                for(k = 0; k < super.V.length; k++){
                    if(matrix == )
                }
            }
        }
    }
}
