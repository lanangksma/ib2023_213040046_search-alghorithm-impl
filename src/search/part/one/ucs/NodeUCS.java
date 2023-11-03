package search.part.one.ucs;

import search.Node;

import java.util.ArrayList;
import java.util.List;

public class NodeUCS {
    //inisialisasi variabel
    private String nilai;
    private int cost;
    private List<NodeUCS> tetangga;

    //membuat konstruktor NodeUCS dengan parameter node dan cost
    public NodeUCS(Node node, int cost) {
        this.nilai = node.getNilai();
        this.cost = cost;
        tetangga = new ArrayList<>();
    }

    //getter dan setter nilai, cost, dan tetangga
    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setNightbor(List<NodeUCS> tetangga) {
        this.tetangga = tetangga;
    }

    public List<NodeUCS> getNightbor() {
        return tetangga;
    }


    public void addNightbor(NodeUCS node) {
        tetangga.add(node);
    } //menambahkan node tetangga

    //mengoverride method equals
    @Override
    public boolean equals(Object obj) {
        //jika objek sama dengan node
        if (obj instanceof NodeUCS) {
            return ((NodeUCS) obj).nilai.equals(this.nilai);//maka nilai objek sama dengan nilai node
        }
        return false;//jika tidak maka nilai objek tidak sama dengan nilai node
    }
}
