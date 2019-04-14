import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    public int vertices;
    public static LinkedList<Integer> ll[];

    public Graph(int v){
        vertices=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;i++)
            ll[i]=new LinkedList<Integer>();
    }

    public void addEdge(int start,int end){
        ll[start].add(end);
    }


    public static void dfs(int pos) {
        boolean[] used = new boolean[ll.length];
        used[pos] = true;
        System.out.print(pos + " ");
        for (int next : ll[pos]){
            if (!used[next]){
                dfs(next);
            }
        }
    }

    public void stackdfs(int start){
        boolean[] visited=new boolean[vertices];
        visited[start]=true;
        Iterator<Integer>[] itr = (Iterator<Integer>[]) new Iterator[vertices];
        for(int i=0;i<vertices;i++){
            itr[i]=ll[i].listIterator();
        }
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(start);
        System.out.print(start +" ");
        while(!stack.isEmpty()){
            start=stack.peek();
            if(itr[start].hasNext()){
                int n=itr[start].next();
                if(!visited[n]){
                    visited[n]=true;
                    stack.push(n);
                    System.out.print(n +" ");
                }
            }
            else
                stack.pop();
        }//2013
    }

    public static void main(String[] args){
        Graph g=new Graph(30);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(0, 7);
        g.addEdge(0, 8);
        g.addEdge(0, 9);
        g.addEdge(0, 10);
        g.addEdge(0, 11);
        g.addEdge(0, 12);
        g.addEdge(0, 13);
        g.addEdge(0, 14);
        g.addEdge(0, 15);
        g.addEdge(0, 16);
        g.addEdge(0, 17);
        g.addEdge(0, 18);
        g.addEdge(0, 19);
        g.addEdge(0, 20);
        g.addEdge(0, 21);
        g.addEdge(0, 22);
        g.addEdge(0, 23);
        g.addEdge(0, 24);
        g.addEdge(0, 25);
        g.addEdge(0, 26);
        g.addEdge(0, 27);
        g.addEdge(0, 28);
        g.addEdge(0, 29);

        long st = System.nanoTime();
        g.stackdfs(0);
        long end = System.nanoTime();
        long extime = end-st;
        System.out.println();
        System.out.println("Execution time: " + extime + " nanos");

        System.out.println();
        st = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        extime = end-st;
        System.out.println();
        System.out.println("Execution time: " + extime + " nanos");

    }
}