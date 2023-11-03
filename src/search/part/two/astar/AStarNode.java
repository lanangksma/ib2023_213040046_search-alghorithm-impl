package search.part.two.astar;

import java.util.ArrayList;
import java.util.List;

public class AStarNode {

    private String value;
    private List<AStarNode> neighbors;
    private boolean visited;
    private AStarNode parent;
    private double f, g, h;
    private int x, y;

    public AStarNode(String value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        neighbors = new ArrayList<>();
        visited = false;
        f = g = h = 0;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<AStarNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<AStarNode> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public AStarNode getParent() {
        return parent;
    }

    public void setParent(AStarNode parent) {
        this.parent = parent;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addNeighbor(AStarNode AStarNode) {
        neighbors.add(AStarNode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AStarNode) {
            AStarNode AStarNode = (AStarNode) obj;
            return this.value.equals(AStarNode.getValue());
        }

        return false;
    }
}
