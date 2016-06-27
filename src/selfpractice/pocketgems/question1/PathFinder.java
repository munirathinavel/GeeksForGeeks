package selfpractice.pocketgems.question1;

import java.io.*;
import java.util.*;

public class PathFinder {
    private Stack<String> path  = new Stack<String>();   // the current path
    private Set<String> onPath  = new HashSet<String>();     // the set of vertices on the path
    private static List<String> answer = new LinkedList<String>();

    private static final String FILEPATH = "D:\\workspace\\SandeepSadanandKulkarni\\github-projects\\GeeksForGeeks\\src\\selfpractice\\pocketgems\\question1";

    static public String join(String conjunction, String [] list)
    {
       StringBuilder sb = new StringBuilder();
       boolean first = true;
       for (String item : list) {
          if (first)
             first = false;
          else
             sb.append(conjunction);
          sb.append(item);
       }
       return sb.toString();
    }
    
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = FILEPATH+"\\"+"input_1.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        
        parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
         */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines);        
    }
    
    static List<String> parseLines(List<String> lines) {
        String sCurrentLine=lines.get(0);
        lines.remove(0);
        String startNode=sCurrentLine.split(" ")[0].trim();
        String endNode=sCurrentLine.split(" ")[1].trim();

        Graph G=new Graph();
        
        for(String sCurrentLine1:lines){                //Loop through all lines and create graph network
            String[] names = sCurrentLine1.split(":");
            String startNode1=names[0].trim();
            String [] endNodes=names[1].split(" ");
            for (int i = 1; i < endNodes.length; i++) {
                G.addEdge(startNode1, endNodes[i].trim());
            }
        }

        //Find paths
        new PathFinder().enumerate(G,startNode,endNode);

        return answer;
    }

    public void enumerate(Graph G, String v, String t) {

        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t
        if (v.equals(t)) {
            String[] ans=path.toString().replace("]", "").replace("[", "").split(",");
            answer.add(join("",ans).replace(" ", ""));
        }
        // consider all neighbors that would continue path with repeating a node
        else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.remove(v);
    }
}


 class Graph {

    // symbol table: key = string vertex, value = set of neighboring vertices
    private TreeMap<String, HashSet<String>> st;

    // number of edges
    private int E;

   /**
     * Initializes an empty graph with no vertices or edges.
     */
    public Graph() {
        st = new TreeMap<String, HashSet<String>>();
    }


   /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return st.size();
    }

   /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }
   

   /**
     * Adds the edge v-w to this graph (if it is not already an edge).
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(String v, String w) {
        addVertex(v);
        addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
    }

   /**
     * Adds vertex v to this graph (if it is not already a vertex).
     *
     * @param  v the vertex
     */
    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new HashSet<String>());
    }


   /**
     * Returns the set of vertices adjacent to v in this graph.
     *
     * @param  v the vertex
     * @return the set of vertices adjacent to vertex <tt>v</tt> in this graph
     * @throws IllegalArgumentException if <tt>v</tt> is not a vertex in this graph
     */
    public Iterable<String> adjacentTo(String v) {
        return st.get(v);
    }

   /**
     * Returns true if v is a vertex in this graph.
     *
     * @param  v the vertex
     * @return <tt>true</tt> if <tt>v</tt> is a vertex in this graph,
     *         <tt>false</tt> otherwise
     */
    public boolean hasVertex(String v) {
        return st.containsKey(v);
    }

    public boolean hasEdge(String v, String w) {
        return st.get(v).contains(w);
    }

}