package search.part.two.greedy.bfs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBFS {

    public Node greedyBFS(Node start, Node goal) {

        // Membuat antrian node dengan prioritas berdasarkan nilai heuristik
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getHeuristic));
        queue.add(start);

        // Membuat set node yang telah dikunjungi
        Set<Node> explored = new HashSet<>();
        explored.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Mengeksplorasi: " + current.getNilai());
            if (current.equals(goal)) {
                System.out.println("Tujuan ditemukan: " + current.getNilai());
                return current;
            } else {
                for (Node node : current.getNightbor()) {
                    if (!explored.contains(node)) {
                        queue.add(node);
                        explored.add(node);
                    }
                }
            }
        }
        System.out.println("Tujuan tidak ditemukan");
        return null; // Jika tidak ada solusi
    }
}
