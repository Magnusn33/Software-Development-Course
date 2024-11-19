import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Graph g=new EdgeGraph();
        Graph g = new AdjListGraph();
        //Graph g=new AdjMapGraph();
        //Graph g=new MatrixGraph();

        //   for(String s: loadStrings("src\\csvfile.txt")){
        for(String s: loadStrings("combi.txt")){
            String[] a= s.split(" , ");
            g.insertEdge(a[0],a[1],Integer.parseInt(a[2]));
            g.insertEdge(a[1],a[0],Integer.parseInt(a[2]));
        }
        g.printGraph();
        //g.visitBreadthFirst(g.vertex("a"));
        HashSet<Vertex> visited=new HashSet<Vertex>();
        g.visitDepthFirst(g.vertex("a"),visited);
        System.out.println(g.vertices());
        System.out.println(visited);
    }

    static ArrayList<String> loadStrings(String f){
        ArrayList<String> list=new ArrayList<>();
        try{
            BufferedReader in=new BufferedReader(new FileReader(f));
            while(true){
                String s=in.readLine();
                if(s==null)break;
                list.add(s);
            }
            in.close();
        }catch(IOException e){
            return null;
        }
        return list;
    }
}

//--------------------------------------------------------------------------------
//

class Edge{
    Vertex from,to;
    int weight;
    Edge(Vertex from,Vertex to,int w){this.from=from; this.to=to; weight=w;}
    public String toString(){return from.name+" - "+weight+" -> "+to.name; }
}




