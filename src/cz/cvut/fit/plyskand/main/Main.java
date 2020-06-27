package cz.cvut.fit.plyskand.main;

import cz.cvut.fit.plyskand.main.algorithms.Algorithm;
import cz.cvut.fit.plyskand.main.algorithms.BFSAlgorithm;
import cz.cvut.fit.plyskand.main.algorithms.Graph;
import cz.cvut.fit.plyskand.main.algorithms.GraphBuilder;
import cz.cvut.fit.plyskand.main.reader.InputReader;
import cz.cvut.fit.plyskand.main.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /* Reader initialization */
        InputReader reader = new InputReader("./Resources/26.txt");
        List<String> list = reader.read();
        /* Area initialization */
        AreaBuilder areaBuilder = new AreaBuilder(list);
        Area area = areaBuilder.build();
        /* Graph initialization */
        GraphBuilder graphBuilder = new GraphBuilder(area);
        Graph graph = graphBuilder.build();
        /* View initialization */
        MyConsole console = new MyConsole();
        console.setVisible(true);
        View view = new ConsoleView(area, console);
        /* Algorithm initialization */
        Algorithm bfs = new BFSAlgorithm(graph, view);
        bfs.run();
    }
}
