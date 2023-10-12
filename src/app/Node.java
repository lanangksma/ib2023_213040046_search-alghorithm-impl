package app;

import java.util.ArrayList;
import java.util.List;

public class Node {

    //inisialisasi variabel
    private String nilai;
    private List<Node> nightbor;

    //membuat konstruktor Node dengan parameter nilai
    public Node(String nilai) {
        nightbor = new ArrayList<>(); //inisialisasi list tetangga
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
        this.nightbor = nightbor;
    }

    public List<Node> getNightbor() {
        return nightbor;
    }

    public void addNightbor(Node node) {
        nightbor.add(node);
    }

    //mengoverride method equals untuk membandingkan nilai node
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
