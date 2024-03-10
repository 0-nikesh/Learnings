class FloydWarshall{
    final static int INF= 99999, V= 4;

    void FloydWarshall( int dist[][]){
        int i, j, k;
        for(k=0; k<V; k++){
            for(i=0; i<V; i++){
                for(j=0; j<V; j++){
                    // if(dist[i][j]> dist[i][k]+dist[k][j]){
                    //     dist[i][j] = dist[i][k]+dist[k][j];
                    // }
                    dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);

                }
            }
        }
        // printSolution(dist);
        for(int x=0;x<V;x++){
            for (int y=0;y<V;y++){
                System.out.print(dist[x][y]+" ");
            }
            System.out.println();
        }
    }

    void printSolution(int dist[][]){
        System.out.println("Ouptut");
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                if(dist[i][j]==INF){
                    System.out.print("INF ");
                }
                else{
                    System.out.print(dist[i][j] + " ");
                }
                
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        int graph[][] = {{ 0, 8, INF, 1 },
                        { INF, 0, 1, INF },
                        { 4, INF, 0, INF },
                        { INF, 2, 9, 0 }};
        FloydWarshall f= new FloydWarshall();
        f.FloydWarshall(graph);
    }

}
//time complexity = O(n^3)
//space complexity = O(2n^2)
