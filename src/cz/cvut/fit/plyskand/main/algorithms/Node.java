package cz.cvut.fit.plyskand.main.algorithms;

import cz.cvut.fit.plyskand.main.view.Pos;

import java.util.HashSet;
import java.util.Set;

public class Node {

   public Set<Node> nodes;
   public char state;
   public boolean isVisited = false;
   private Node parent;

   private Pos pos;


   public Node(Pos pos, char state) {
       this.pos = pos;
       this.state = state;
       nodes = new HashSet<>();
   }

    public Pos getPos() {
        return pos;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
