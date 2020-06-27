package cz.cvut.fit.plyskand.main.algorithms;

import cz.cvut.fit.plyskand.main.signs.ConsoleSigns;
import cz.cvut.fit.plyskand.main.view.View;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm extends Algorithm {

    Queue<Node> queue;

    public BFSAlgorithm(Graph graph, View view) {
        super(graph, view);
        this.queue = new LinkedList<Node>();
    }

    @Override
    public void run() throws InterruptedException {
        queue.add(graph.start);
        view.print();
        Thread.sleep(1000);
        graph.start.isVisited = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.equals(graph.target)) {
                view.setSignOnPosition(node.getPos(), ConsoleSigns.END);
                break;
            }
            for (Node n: node.nodes) {
                if (n.getParent() == null) {
                    n.setParent(node);
                }
                if (!n.isVisited) {
                    queue.add(n);
                    view.setSignOnPosition(n.getPos(), ConsoleSigns.OPENED_NODE);
                    n.isVisited = true;
                }

            }
            // System.out.println(node.getPos());
            view.print();
        }
        showWay();
    }

    public void showWay() throws InterruptedException {
        Node node = graph.target;
        while (node != graph.start) {
            Node parent = node.getParent();
            if(!node.equals(graph.start)) {
                view.setSignOnPosition(parent.getPos(), ConsoleSigns.PATH);
            }
            node = parent;
            view.print();
        }
    }
}
