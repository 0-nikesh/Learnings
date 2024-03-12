// pseudo code i have written like this
// parent=[] to store parent node, 
// key = [] to store minimum weight
// MST=[] storing boolean value

// for each vertex V in graph 
// key[v]= interger_max
// mst[v]= F

// key[0]= 0
// mst[0]= -1


// for each vertex v in graph 
// {
// k= min key[v] && MST[v]=F
// MST[k]=t

// for each vertex v in graph 
// {
// if(graph[k][v] && MST[V]=f && graph[k][v]<key[v])
// key[v]=graph[k][v]
// parent[v]=k

import java.util.*;

class PrimAlgorithm {
    static class Graph {
        int vertices;
        int[][] adjacencyMatrix;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyMatrix = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination, int weight) {
            adjacencyMatrix[source][destination] = weight;
            adjacencyMatrix[destination][source] = weight; // Uncomment for undirected graph
        }

        public List<Edge> prim() {
            int[] parent = new int[vertices];
            int[] key = new int[vertices];
            boolean[] mst = new boolean[vertices];

            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(mst, false);
            key[0] = 0;
            parent[0] = -1;

            for (int count = 0; count < vertices - 1; count++) {
                int u = minKey(key, mst);
                mst[u] = true;

                for (int v = 0; v < vertices; v++) {
                    if (adjacencyMatrix[u][v] != 0 && !mst[v] && adjacencyMatrix[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = adjacencyMatrix[u][v];
                    }
                }
            }

            List<Edge> minimumSpanningTree = new ArrayList<>();
            for (int i = 1; i < vertices; i++) {
                minimumSpanningTree.add(new Edge(parent[i], i, adjacencyMatrix[i][parent[i]]));
            }

            return minimumSpanningTree;
        }

        private int minKey(int[] key, boolean[] mst) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int v = 0; v < vertices; v++) {
                if (!mst[v] && key[v] < min) {
                    min = key[v];
                    minIndex = v;
                }
            }

            return minIndex;
        }
    }

    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.addEdge(1, 2, 6); // Commenting this line to make the graph directed

        List<Edge> minimumSpanningTree = graph.prim();
        int totalCost = 0;
        System.out.println("Minimum Cost Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " | Weight: " + edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("Total Cost: " + totalCost);

    }
}

