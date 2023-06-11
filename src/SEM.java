import java.util.LinkedList;

public class SEM {
    Matrix graph;
    int start;
    int end;
    LinkedList<VertexAux> SX = new LinkedList<VertexAux>();
    LinkedList<VertexAux> X = new LinkedList<VertexAux>();
    
    
    public SEM(Matrix graph, int start, int end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
        X.add(new VertexAux(start));
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

    public void getPossibleChilds(VertexAux v){
        //LinkedList<VertexAux> SX = new LinkedList<VertexAux>();
        // get neighs
        int[] vertesNeighs = graph.getNeighs(v.getAscVertex());
        for (int i = 0; i < vertesNeighs.length; i++) {
            if (vertesNeighs[i] != 0) {
                Matrix matTemp = getMatAsc();
                matTemp.deleteVertexsPath(v.getPath());
                if(matTemp.pathPossible(v.path.getLast() , i)){
                    SX.add(new VertexAux(i, v.addVertexPath(i)));
                }
            }
        }
    }

    public void getSX(){
        SX.clear();
        for (VertexAux vertex : X) {
            getPossibleChilds(vertex);
        }
    }

    public LinkedList<VertexAux> takeRandom(LinkedList<VertexAux> list){
        LinkedList<VertexAux> listTemp = new LinkedList<VertexAux>();
        //TODO: take random


        return listTemp;
    }

    public double costo(LinkedList<VertexAux> list){
        double cost = 0;
        for (VertexAux vertex : list) {
            cost = cost + costo(vertex.getAscVertex());
        }
        return cost;
        //TODO: review
    }

    public double estimation(){
        double D = 1;
        double C = costo(start);

        getSX();
        while(SX.size() > 0){
            D = (SX.size())/(X.size())*D*1.0;
            X = takeRandom(X);
            C = C + costo(X)/X.size()*D*1.0;

            getSX();
        }
        return C;
    }

}
