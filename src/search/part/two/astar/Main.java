package search.part.two.astar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Membuat grid 6x6
        AStarNode[][] grid = new AStarNode[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = new AStarNode("Unvisited", i, j);
            }
        }

        // Menentukan titik start dan finish
        AStarNode start = grid[1][0];
        AStarNode end = grid[5][5];

        // Menambahkan tetangga untuk setiap node
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i > 0) grid[i][j].addNeighbor(grid[i - 1][j]);
                if (j > 0) grid[i][j].addNeighbor(grid[i][j - 1]);
                if (i < 5) grid[i][j].addNeighbor(grid[i + 1][j]);
                if (j < 5) grid[i][j].addNeighbor(grid[i][j + 1]);
            }
        }

        // Melakukan pencarian A*
        AStarSearch search = new AStarSearch(start, end);
        search.search();

        // Mencetak rute jika pencarian selesai
        if (search.isFinished()) {
            System.out.println("Rute dari start ke finish:");
            List<AStarNode> path = search.getPath();
            for (AStarNode node : path) {
                System.out.println("Node at position (" + node.getX() + ", " + node.getY() + ")");
            }
        } else {
            System.out.println("Tidak ada rute yang ditemukan.");
        }

    }
}
