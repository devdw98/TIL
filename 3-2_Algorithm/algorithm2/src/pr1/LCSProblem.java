package pr1;

public class LCSProblem {
    String[] x;
    String[] y;
    int [][] c;
    String [][] b;

//    int i;
//    int j;

    public LCSProblem(String[] x, String[] y) {
        this.x = x;
        this.y = y;
    }

    public void exec(){
        int m = x.length;
        int n = y.length;
        c = new int[m+1][n+1];
        b = new String[m+1][n+1];
        int i, j;
        b[0][0]=" ";
        for(i = 1; i <= m; i++){
            c[i][0] = 0;
            b[i][0] = x[i-1];
        }
        for(j = 1; j <= n; j++){
            c[0][j] = 0;
            b[0][j] = y[j-1];
        }
        for(i = 1; i <= m; i++){
            for(j = 1; j <= n; j++){
                if(x[i-1].equals(y[j-1])){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = "↖";
                }else if(c[i - 1][ j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = "↑";
                }else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = "←";
                }
            }
        }
        for(i = 0; i<=m; i++){
            for(j = 0; j <= n; j++){
                System.out.print(c[i][j]);
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printLCS(int i, int j){

        if(i == 0 || j == 0)
            return;
        if(b[i][j] == "↖"){
            printLCS(i-1, j-1);
            System.out.print(x[i-1]);
        }else if(b[i][j] == "↑"){
            printLCS(i-1, j);
        }else{
            printLCS(i, j-1);
        }
    }
}
