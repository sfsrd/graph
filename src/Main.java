public class Main {
    public static void main(String[] args){
        Graph g=new Graph(30);


        for(int i = 1; i < 30; i++) {
            try {
                g.addEdge(0, i);
            } catch (EdgeAlreadyExistException e) {
                System.out.printf("Edge duplicate created: from %d to %d", e.getFrom(), e.getTo());
                e.printStackTrace();
            }
        }


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
