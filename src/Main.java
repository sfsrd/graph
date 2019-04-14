public class Main {
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
        g.stackDepthFirstSearch(0);
        long end = System.nanoTime();
        long extime = end-st;
        System.out.println();
        System.out.println("Execution time: " + extime + " nanos");

        System.out.println();
        st = System.nanoTime();
        g.depthFirstSearch(0);
        end = System.nanoTime();
        extime = end-st;
        System.out.println();
        System.out.println("Execution time: " + extime + " nanos");

    }
}
