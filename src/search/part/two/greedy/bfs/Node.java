package search.part.two.greedy.bfs;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String nilai;
    private List<Node> nightbor;
    private int heuristic;

    public Node(String nilai) {
        nightbor = new ArrayList<>();
        this.nilai = nilai;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public List<Node> getNightbor() {
        return nightbor;
    }

    public void setNightbor(List<Node> nightbor) {
        this.nightbor = nightbor;
    }

    public void addNightbor(Node node) {
        nightbor.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        //jika objek sama dengan node
        if (obj instanceof Node) {
            Node node = (Node) obj;
            return this.nilai.equals(node.getNilai()); //maka nilai objek sama dengan nilai node
        }
        return false; //jika tidak maka nilai objek tidak sama dengan nilai node
    }
}

