import java.util.LinkedList;

public class VertexAux {
    //String name;
    int ascVertex;
    LinkedList<Integer> path;
    //int[] path = ;

    // Init constructor
    public VertexAux(int ascVertex) {
        this.ascVertex = ascVertex; 
        this.path = new LinkedList<Integer>();
        this.path.add(ascVertex);
    }

    public VertexAux(int ascVertex, LinkedList<Integer> path) {
        this.ascVertex = ascVertex; 
        this.path = path;
    }

    // add vertex to path
    public LinkedList<Integer> addVertexPath(int vertex) {
        this.path.add(vertex);
        return path;
    }

    // get vertex associated with this VertexAux
    public int getAscVertex() {
        return this.ascVertex;
    }

    // get path
    public LinkedList<Integer> getPath() {
        return this.path;
    }

    public LinkedList<Integer> getPathModf() {
        LinkedList<Integer> pathMod = new LinkedList<Integer>();
        for (int i = 0; i < this.path.size()-1; i++) {
            pathMod.add(this.path.get(i));
        }
        return pathMod;
    }
}
