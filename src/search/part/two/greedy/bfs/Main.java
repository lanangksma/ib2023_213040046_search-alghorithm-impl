package search.part.two.greedy.bfs;

public class Main {

    public static void main(String[] args) {
        // Membuat grid 6x6
        Node[][] grid = new Node[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = new Node("Node_" + i + "_" + j);
            }
        }

        // Menetapkan tetangga untuk setiap node
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i > 0) grid[i][j].addNightbor(grid[i-1][j]); // atas
                if (j > 0) grid[i][j].addNightbor(grid[i][j-1]); // kiri
                if (i < 5) grid[i][j].addNightbor(grid[i+1][j]); // bawah
                if (j < 5) grid[i][j].addNightbor(grid[i][j+1]); // kanan
            }
        }

        // Mencari rute dari pojok kiri atas ke pojok kanan bawah
        GreedyBFS gBFS = new GreedyBFS();
        Node result = gBFS.greedyBFS(grid[0][0], grid[5][5]);

        // Mencetak hasil
        if (result != null) {
            System.out.println("Rute ditemukan ke " + result.getNilai());
        } else {
            System.out.println("Rute tidak ditemukan");
        }
    }
}