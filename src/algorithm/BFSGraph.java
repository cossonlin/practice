package algorithm;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s

import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class BFSGraph {
    int v;
    LinkedList<Integer> list[];
    BFSGraph(int v){
        this.v = v;
        list = new LinkedList[v];
        for (int i=0;i<v;i++){
            list[i] = new LinkedList();
        }
    }

    void addEdge(int s, int e){
        list[s].add(e);
    }

    void BFS(int s){
        LinkedList<Integer> queue = new LinkedList();
        boolean visited[] = new boolean[v];
        queue.add(s);
        visited[s]=true;
        while (queue.size()>0){
            s = queue.poll();
            System.out.print(s + ", ");

            list[s].forEach(
                    n -> {
                        if(!visited[n]) {
                            queue.add(n);
                            visited[n] = true;
                        }
                    }
            );
        }
    }

    // Driver method to
    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
    }
}