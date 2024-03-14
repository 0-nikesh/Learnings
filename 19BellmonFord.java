// BellmanFord(G, V, E, S)
// step 1
//     For each vertex V belongs to G 
//     do 
//     dist[V]=infinity
//     dist[source]=0
// Step 2 
//     for i=1 to |V|-1
//         for each edge (u,v) belongs to Graph 
//         Relax(u,v,w)

// Step 3 
//     for each edge(u,v) belongs to graph
//         if(dost[u] + w(u,v) <dist[v]){
//             return "Graph contains negative weight cycle"
//         }
//     return distance


import java.util.*;

class Edge{
    int source, destination, weight;
    public Edge(int source, int destination, int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
}

class BellmanFord{
    int V, E;
    Edge [] edges;

    public BellmanFord(int V, int E){
        this.V= V;
        this.E=E;
        edges= new Edge[E];
    }
    
    void addEdge(int source, int destination, int weight){
        edges[E++]=new Edge(source, destination, weight);
    }

    void bellmanford(int source){
        int[] distance= new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source]=0;

        //relaxing the edge
        for(int i=0; i<V-1; i++){
            for(int j=0; j<E; j++){
                int u= edges[j].source;
                int v= edges[j].destination;
                int weight= edges[j].weight;

                if(distance[u]<Integer.MAX_VALUE && distance[u] + weight <distance[v]){
                     distance[v]= distance[u]+weight;
                }
            }
        }

        for(int i=0; i<E; i++){
            int u=edges[i].source;
            int v= edges[i].destination;
            int weight=edges[i].weight;

            if(distance[u]<Integer.MAX_VALUE && distance[u] + weight< distance[v]){
                System.out.println("contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex distance from source");
        for(int i=0; i<V; i++){
            System.out.println(i + "\t\t" + distance[i]);
        }

    }
    public static void main(String[] args) {
        int V = 5;
        int E = 8;
        BellmanFord graph = new BellmanFord(V, E);

        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.bellmanford(0);
    }


}

