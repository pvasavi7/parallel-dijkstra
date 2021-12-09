import model.Graph;
import util.GraphUtils;
import util.IOUtils;
import validation.InvalidDataException;


import java.util.*;


public class Main {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        Graph graph;
        List<Integer> results = new ArrayList<>();
        try {
            //if run with arguments
            if (args.length > 0) {
                //Parallel Processing
                if (args[0].equals("-parallel") && args.length > 1) {
                    int threadCount;
                    if (args.length > 3) {
                        //Generate graph
                        graph = GraphUtils.generateGraph(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                        IOUtils.writeGraph(INPUT_FILE, graph);
                    } else {
                        //Read existing graph
                        graph = IOUtils.readGraph(INPUT_FILE);
                    }
                    threadCount = Integer.parseInt(args[1]);
                    //run and print execution time
                    results = parallelProcess(graph, threadCount);
                } //Sequential Processing
                else if (args[0].equals("-sequential")) {
                    //Generate Graph
                    if (args.length > 2) {
                        graph = GraphUtils.generateGraph(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                        IOUtils.writeGraph(INPUT_FILE, graph);
                    } else {
                        //Read existing graph
                        graph = IOUtils.readGraph(INPUT_FILE);
                    }
                    //run and print execution time
                    results = sequentialProcess(graph);
                } else {
                    System.out.println("Please specify the type of execution Sequential or Parallel");
                }
            } else {
                //no arguments, default to the parallel method with 4 threads
                graph = IOUtils.readGraph(INPUT_FILE);
                parallelProcess(graph, 4);
            }
            IOUtils.writeResults("output.txt", results);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid command format");
        }
    }

    private static List<Integer> parallelProcess(Graph graph, int threadCount){
        ParallelProcessing p = new ParallelProcessing();
        long startTime = System.currentTimeMillis();
        List<Integer> results = p.solve(graph, threadCount);
        long endTime = System.currentTimeMillis();
        System.out.println("Processing Technique : Parallel :: Start Time :: " + startTime + " End Time :: " + endTime + " Total Time Taken For Processing  :: " +  (endTime-startTime) + "ms");
        return results;
    }

    private static List<Integer> sequentialProcess(Graph graph){
        SequentialProcessing s = new SequentialProcessing();
        long startTime = System.currentTimeMillis();
        List<Integer> results = s.solve(graph);
        long endTime = System.currentTimeMillis();
        System.out.println("Processing Technique : Sequential :: Start Time :: " + startTime + " End Time :: " + endTime + " Total Time Taken For Processing :: " +  (endTime-startTime) + "ms");
        return results;
    }


}
