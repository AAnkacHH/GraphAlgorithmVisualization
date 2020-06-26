package cz.cvut.fit.plyskand.main.algorithms;

import cz.cvut.fit.plyskand.main.view.View;

public abstract class Algorithm {

    protected Graph graph;

    protected View view;

    public Algorithm(Graph graph, View view) {
        this.graph = graph;
        this.view = view;
    }

    public abstract void run() throws InterruptedException;
}
