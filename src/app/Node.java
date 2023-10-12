package app;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String nilai;
    private List<Node> nightbor;

    public Node(String nilai) {
        nightbor = new ArrayList<>();
        this.nilai = nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNightbor(List<Node> nightbor) {
        this.nightbor = nightbor;
    }

    public List<Node> getNightbor() {
        return nightbor;
    }

    public void addNightbor(Node node) {
        nightbor.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node node = (Node) obj;
            return this.nilai.equals(node.getNilai());
        }
        return false;
    }
}
