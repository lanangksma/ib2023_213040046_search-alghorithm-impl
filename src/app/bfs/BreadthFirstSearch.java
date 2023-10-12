package app.bfs;

import app.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

    //method search dengan parameter start dan goal
    public void search(Node start, Node goal) {
        Queue<Solusi> queue = new LinkedBlockingQueue<>();
        Solusi solusiStart = new Solusi();
        solusiStart.setNode(start); //set node start
        queue.add(solusiStart); //menambahkan node start ke queue
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());

        //looping selama queue tidak kosong
        while (!queue.isEmpty()) {
            Solusi eval = queue.poll();//mengambil node dari queue
            System.out.println("Evaluasi " + eval.getNode().getNilai());//menampilkan node yang diambil dari queue

            //jika node yang diambil dari queue sama dengan goal
            if (eval.getNode().equals(goal)) {
                System.out.println("Solusi ditemukan");//maka solusi ditemukan

                //looping untuk menampilkan solusi
                for (Node node : eval.getNodes()) {
                    System.out.print(node.getNilai() + " => ");
                }
                System.out.println(eval.getNode().getNilai());//menampilkan node goal
                break; //menghentikan looping
            } else { //jika node yang diambil dari queue bukan goal
                System.out.println("Suksesor " + eval.getNode().getNilai());

                //looping untuk menampilkan node suksesor
                for (Node successor : eval.getNode().getNightbor()) {
                    System.out.print(successor.getNilai() + " ");//menampilkan node suksesor
                    Solusi solusiSuksesor = new Solusi();
                    solusiSuksesor.setNode(successor); //set node suksesor
                    solusiSuksesor.setNodes(eval.getNodes()); //menambahkan node ke solusi suksesor
                    solusiSuksesor.getNodes().add(eval.getNode()); //menambahkan node ke solusi suksesor

                    queue.offer(solusiSuksesor);//menambahkan node suksesor ke queue
                }
                System.out.println("\n=====================================\n");
            }
        }
    }
}