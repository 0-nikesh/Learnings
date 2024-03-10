class FloydWarshall{
    final static int INF= 9999, V= 4;

    void FloydWarshall( int dist[][]){
        int i, j, k;
        for(k=0; k<V; k++){
            for(i=0; i<V; i++){
                for(j=0; j<V; j++){
                    dist[i][j]= Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for(i=0; i<V; i++){
            for(j=0; j<V; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int graph[][] = {{ 0, 2, INF, 4 },
                        { INF, 0, 6, INF },
                        { 4, INF, 0, INF },
                        { INF, 7, 1, 0 }};
        FloydWarshall f= new FloydWarshall();

        f.FloydWarshall(graph);
    }

}

//time complexity = O(n^3)
//space complexity = O(2n^2)
