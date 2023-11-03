package search.part.two.astar;

import java.util.*;

public class AStarSearch {

    private PriorityQueue<AStarNode> openList;
    private boolean finished;
    private AStarNode startAStarNode;
    private AStarNode endAStarNode;

    public AStarSearch(AStarNode start, AStarNode end) {
        openList = new PriorityQueue<>(Comparator.comparingDouble(AStarNode::getF));
        startAStarNode = start;
        endAStarNode = end;
        openList.add(startAStarNode);
        finished = false;
    }

    public void search() {
        while (!openList.isEmpty() && !finished) {
            AStarNode current = openList.poll();
            current.setVisited(true);

            if (current.equals(endAStarNode)) {
                finished = true;
            }

            for (AStarNode neighbor : current.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    neighbor.setParent(current);
                    neighbor.setG(current.getG() + 1);
                    neighbor.setH(Math.sqrt(Math.pow((neighbor.getX() - endAStarNode.getX()), 2) + Math.pow((neighbor.getY() - endAStarNode.getY()), 2)));
                    neighbor.setF(neighbor.getG() + neighbor.getH());

                    if (openList.contains(neighbor)) {
                        openList.remove(neighbor);
                    }

                    openList.add(neighbor);
                }
            }
        }
    }

    public List<AStarNode> getPath() {
        List<AStarNode> path = new ArrayList<>();
        AStarNode current = endAStarNode;

        while (current.getParent() != null) {
            path.add(current);
            current = current.getParent();
        }

        Collections.reverse(path);

        return path;
    }

    public boolean isFinished() {
        return finished;
    }
}

