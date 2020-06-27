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

    /**
     * The method is responsible for building a graph.
     * */
    public Graph build () {
        int width = area.getWidth();
        int height = area.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pos pos = new Pos(j, i);
                if (area.isAccessible(pos)) {
                    Node node = getNode(pos);
                    setNeighbors(node);
                    if (area.isStart(pos)) graph.start = node;
                    if (area.isEnd(pos)) graph.target = node;
                }
            }
        }
        return graph;
    }

    /**
     * The method create a new node if it doesn't exist.
     * @param key - Key of a node
     * @param pos - node position
     *  */
    private Node createNewNode(String key, Pos pos){
        Node node = new Node(pos, area.getState(pos));
        this.allNodes.put(key, node);
        return node;
    }

    /**
     * This method just adds neighbors to current node
     * @param node - current node
     * */
    private void setNeighbors(Node node) {
        List<Node> neighbors = getOrCreateNeighbors(node);
        node.nodes.addAll(neighbors);
    }

    /**
     * This method creates or gets from the set neighbors of current node.
     * @param node current node
     * */
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

    /**
     * Creates or get node with position in parameter.
     * @param pos - position of node
     * */
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

    /** Creates node key from its position. */
    private String getNodeKey(Pos pos) {
        return pos.x + Integer.toString(pos.y);
    }
}
