import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Graph {



    private int vertices;

    private LinkedList<LinkedList<Integer>> listOfEdges;
                                            /*
                                            from -> to, to, to
                                            from -> to, to
                                            from ->
                                            from -> to
                                            from -> to, to
                                            */

    public Graph(int v) {
        vertices = v;

        listOfEdges = new LinkedList<>();
        for (int i = 0; i < v; i++)
            listOfEdges.push(new LinkedList<Integer>());
    }

    public int getVerticesCount() {
        return vertices;
    }

    public void addEdge(int from, int to) throws EdgeAlreadyExistException{
        if (listOfEdges.get(from).contains(to)) throw new EdgeAlreadyExistException(from, to);

        listOfEdges.get(from).add(to);
    }

    public void removeEdge(int from, int to) throws EdgeNotFoundException {
        ListIterator<Integer> iterator = listOfEdges.get(from).listIterator();

        while(iterator.hasNext()){
            if(iterator.next() == to) {
                iterator.remove();
                return;
            }
        }

        //else
        throw new EdgeNotFoundException(from, to);
    }

    public void pushVertex(){
        vertices++;
        listOfEdges.push(new LinkedList<Integer>());
    }

    public void popVertex(){
        listOfEdges.pop();
    }

    public void removeVertex(int index){
        listOfEdges.remove(index);
    }

    public void depthFirstSearch(int pos) {
        boolean[] used = new boolean[listOfEdges.size()];
        used[pos] = true;

        System.out.print(pos + " ");

        for (int next : listOfEdges.get(pos)) {
            if (!used[next]) {
                depthFirstSearch(next);
            }
        }
    }

    public void stackDepthFirstSearch(int start) {
        boolean[] visited = new boolean[vertices];
        visited[start] = true;

        Iterator<Integer>[] itr;
        itr = (Iterator<Integer>[]) new Iterator[vertices];
        for (int i = 0; i < vertices; i++) {
            itr[i] = listOfEdges.get(i).listIterator();
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);

        System.out.print(start + " ");

        while (!stack.isEmpty()) {
            start = stack.peek();

            if (itr[start].hasNext()) {
                int n = itr[start].next();

                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                    System.out.print(n + " ");
                }
            } else
                stack.pop();
        }
    }

}

class EdgeNotFoundException extends Exception {
    EdgeNotFoundException(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private int from;
    private int to;
}

class EdgeAlreadyExistException extends Exception {
    EdgeAlreadyExistException(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private int from;
    private int to;
}

