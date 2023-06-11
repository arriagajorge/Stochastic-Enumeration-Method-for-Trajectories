public class App {


    public static void main(String[] args) {
        // Adjacency matrix
        int[][] matAdj = {
            {0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}
        };
        // Start and end vertex
        int start = 0;
        int end = 5;
        
        // Create graph
        Matrix graph = new Matrix(matAdj);

        SEM sem = new SEM(graph, start, end);
        sem.estimation();
    }
}
