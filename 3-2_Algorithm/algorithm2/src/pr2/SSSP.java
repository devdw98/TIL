package pr2;

public abstract class SSSP {
    String[] V; //vertexs
    Integer[] d; //shortest-path weight estimate
    String[] p; // predecessor of v on a shortest path from s


    public SSSP(String[] v) {
        V = v;
    }

    public void initlaizeSingleSource(String[] V, int s){ //s : start point
        int end = V.length;
        d = new Integer[end];
        p = new String[end];
        for(int i = 0; i < end; i++){
            d[i] = Integer.MAX_VALUE;
            p[i] = null;
        }
        d[s] = 0;
    }
    public void relaxing(String u, String v, int w){
        int i, m = 0,n = 0;
        for(i = 0; i < V.length; i++){
            if(V[i].equals(u)){
                m = i;
                continue;
            }else if(V[i].equals(v)){
                n = i;
                continue;
            }
        }
        if(d[n] > d[m] + w){
            d[n] = d[m] + w;
            p[n] = v;
        }
    }

    public abstract void algorithm(String[] g, int w, int s);

}
