// Floyd Marshall using DP
// - Floyd Marshall is used to find the shortest path for all vertex to travel the all vertex in a connected graph.
// Time Complexity- O(n^3) due to the 3 times nested for loop.

public class DPFloydMarshal{
    static int infinity=999;
    int v;
    void flyodM(int dist[][]){
        v=dist.length;
        for(int k=0;k<v;k++){
            for (int i=0; i<v; i++){
                for (int j=0; j<v; j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        for (int x=0;x<v;x++){
            for(int y=0;y<v;y++){
                System.out.print(dist[x][y] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        DPFloydMarshal  dm = new DPFloydMarshal();
        int graph[][] = {{ 0, 8, infinity, 1 },
                        { infinity, 0, 1, infinity },
                        { 4, infinity, 0, infinity },
                        { infinity, 2, 9, 0 }};
        dm.flyodM(graph);
    }

}