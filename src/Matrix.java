import java.util.LinkedList;
import java.util.Queue;

// class to represent a matrix
public class Matrix {
    // instance variables
    int[][] mat;

    // constructor
    public Matrix(int[][] mat) {
        this.mat = mat;
    }

    // get adjacent vertexs
    int[] getNeighs(int vertex) {
        // init neighs
        int[] neighs = new int[mat.length];
        // var to keep track of neighs
        int count = 0;
        // for each vertex
        for (int i = 0; i < mat.length; i++) {
            // if edge exists
            if (mat[vertex][i] == 1) {
                // add to neighs
                neighs[count] = i;
                count++;
            }
        }
        return neighs;
    }

    // check if path possible
    public boolean pathPossible(int start, int end) {
        // init queue
        Queue<Integer> queue = new LinkedList<>();
        // add start to queue
        queue.add(start);
        // while queue is not empty
        while (!queue.isEmpty()) {
            // dequeue
            int current = queue.remove();
            if (current == end) {
                //System.out.println("Path possible");
                return true;
            }
            // print
            System.out.println(current);
            // get neighs
            int[] neighs = getNeighs(current);
            // for each neigh
            for (int i = 0; i < neighs.length; i++) {
                // if not visited
                if (neighs[i] != 0) {
                    // add to queue
                    queue.add(neighs[i]);
                }
            }
        }
        return false;
    }
    
    // delete vertex
    public void deleteVertex(int vertex){
        // delete all edges to and from vertex
        for(int i = 0; i < mat.length; i++){
            mat[i][vertex] = 0;
        }
        for(int i = 0; i < mat.length; i++){
            mat[vertex][i] = 0;
        }
    }

    // delete multiple vertexs
    public void deleteVertexs(int[] vertexs){
        for(int i = 0; i < vertexs.length; i++){
            deleteVertex(vertexs[i]);
        }
    }

    // delete multiple vertexs
    public void deleteVertexs(LinkedList<Integer> vertexs){
        for(int i = 0; i < vertexs.size(); i++){
            deleteVertex(vertexs.get(i));
        }
    }

    public void deleteVertexsPath(LinkedList<Integer> path){
        for(int i = 0; i < path.size() - 1; i++){
            deleteVertex(path.get(i));
        }
    }

}
