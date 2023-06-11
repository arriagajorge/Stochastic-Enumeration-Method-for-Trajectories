import java.util.LinkedList;

public class SEM {
    Matrix graph;
    int start;
    int end;

    
    public SEM(Matrix graph, int start, int end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
    }
    
    public Matrix getMatAsc() {
        return this.graph;
    }

    public int costo(int vertex){
        if (vertex == end){
            return 1;
        }
        return 0;
    }

    public LinkedList<VertexAux> getPossibleChilds(VertexAux v){
        LinkedList<VertexAux> childs = new LinkedList<VertexAux>();
        // get neighs
        int[] vertesNeighs = graph.getNeighs(v.getAscVertex());
        for (int i = 0; i < vertesNeighs.length; i++) {
            if (vertesNeighs[i] != 0) {
                Matrix matTemp = getMatAsc();
                matTemp.deleteVertexsPath(v.getPath());
                if(matTemp.pathPossible(v.path.getLast() , i)){
                    childs.add(new VertexAux(i, v.addVertexPath(i)));
                }
            }
        }
        return childs;
    }

    public int estimation(){
        int D = 1;
        LinkedList<VertexAux> X = new LinkedList<VertexAux>();
        int C = costo(start);

        
        return 0;
    }

}
