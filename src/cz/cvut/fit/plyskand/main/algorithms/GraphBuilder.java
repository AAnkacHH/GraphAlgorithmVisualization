package cz.cvut.fit.plyskand.main.algorithms;

import cz.cvut.fit.plyskand.main.view.Area;
import cz.cvut.fit.plyskand.main.view.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphBuilder {
    private Area area;
    private Graph graph;
    private HashMap<String, Node> allNodes;


    public GraphBuilder(Area area) {
        this.area = area;
        this.allNodes = new HashMap<>();
        this.graph = new Graph();
    }

    public Graph build () {
        int width = area.getWidth();
        int height = area.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pos pos = new Pos(j, i);
                if (area.isFresh(pos)||area.isEnd(pos)||area.isStart(pos)) {
                    Node node = getNode(pos);
                    setNeighbors(node);
                    if (area.isStart(pos)) graph.start = node;
                    if (area.isEnd(pos)) graph.target = node;
                }
            }
        }

        return graph;
    }


    private Node createNewNode(String key, Pos pos){
        Node node = new Node(pos, area.getState(pos));
        this.allNodes.put(key, node);
        return node;
    }

    private void setNeighbors(Node node) {
        List<Node> neighbors = getOrCreateNeighbors(node);
        node.nodes.addAll(neighbors);
    }

    private List<Node> getOrCreateNeighbors(Node node) {
        List<Node> list = new ArrayList<Node>();
        Pos pos = node.getPos();
        List<Pos> positions = area.getNeighborsPositions(pos);
        for (Pos p: positions) {
            Node neighbor = getNode(p);
            list.add(neighbor);
        }
        return list;
    }

    private Node getNode(Pos pos) {
        String key = getNodeKey(pos);
        Node node;
        if (allNodes.containsKey(key)) {
            node = allNodes.get(key);
        } else {
            node = createNewNode(key, pos);
        }
        return node;
    }

    private String getNodeKey(Pos pos){
        return pos.x + Integer.toString(pos.y);
    }

}
