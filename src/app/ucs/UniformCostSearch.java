package app.ucs;

import java.util.ArrayList;
import java.util.List;

public class UniformCostSearch {

    //membuat method search dengan parameter start dan goal
    public void search(NodeUCS start, NodeUCS goal) {

        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());

        NodeUCS eval = start; //inisialisasi node evaluasi dengan node start
        boolean done = false; //inisialisasi variabel done dengan nilai false

        List<NodeUCS> solusi = new ArrayList<>(); //membuat list solusi

        //looping selama variabel done bernilai false
        while (!done) {
            System.out.println("\nEvaluasi: "+eval.getNilai()+" dengan cost "+eval.getCost()); //menampilkan node evaluasi

            solusi.add(eval); //menambahkan node evaluasi ke list solusi

            //jika node evaluasi sama dengan node goal
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                done = true; //maka variabel done bernilai true
            }

            //jika node evaluasi tidak sama dengan node goal
            if (!eval.getNightbor().isEmpty()) {
                NodeUCS best = null; //inisialisasi node best dengan nilai null
                int min = Integer.MAX_VALUE; //inisialisasi variabel min dengan nilai maksimal integer

                //looping untuk menampilkan node tetangga
                for (NodeUCS node: eval.getNightbor()) {
                    System.out.print(node.getNilai() + " ("+ node.getCost() + "), ");

                    //jika nilai node tetangga lebih kecil dari nilai min
                    if (min > node.getCost()) {
                        min = node.getCost();
                        best = node;
                    }
                }
                System.out.println("\nNode terpilih: "+best.getNilai()+" ("+min+")"); //menampilkan node terpilih
                eval = best; //node evaluasi sama dengan node terpilih
            } else {
                done = true; //jika node evaluasi tidak memiliki tetangga maka variabel done bernilai true
            }
        }
        System.out.println("\nSolusi ditemukan: ");

        //looping untuk menampilkan node solusi
        for (NodeUCS node: solusi) {
            System.out.println(node.getNilai()+" ("+node.getCost()+")"); //menampilkan node solusi
        }
    }
}
