package search.part.one.bfs;

import search.Node;

import java.util.ArrayList;
import java.util.List;

public class Solusi {

    //inisialisasi variabel
    private List<Node> nodes;
    private Node node;

    public Solusi() {
        nodes = new ArrayList<>();
    } //membuat konstruktor Solusi

    public void setNode(Node node) {
        this.node = node;
    } //setter node

    public Node getNode() {
        return node;
    } //getter node

    public List<Node> getNodes() {
        return nodes;
    } //getter nodes

    //setter nodes
    public void setNodes (List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }
}
