package search;

import java.util.ArrayList;
import java.util.List;

public class Node {

    //inisialisasi variabel
    private String nilai;
    private List<Node> neighbors;

    //membuat konstruktor Node dengan parameter nilai
    public Node(String nilai) {
        neighbors = new ArrayList<>(); //inisialisasi list tetangga
        this.nilai = nilai;
    }

    //getter dan setter nilai dan tetangga, serta menambahkan node tetangga
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNightbor(List<Node> nightbor) {
        this.neighbors = nightbor;
    }

    public List<Node> getNightbor() {
        return neighbors;
    }

    public void addNightbor(Node node) {
        neighbors.add(node);
    }

    //mengoverride method equals untuk membandingkan nilai node
    @Override
    public boolean equals(Object obj) {
        //jika objek sama dengan node
        if (obj instanceof Node node) {
            node = (Node) obj;
            return this.nilai.equals(node.getNilai()); //maka nilai objek sama dengan nilai node
        }
        return false; //jika tidak maka nilai objek tidak sama dengan nilai node
    }
}
