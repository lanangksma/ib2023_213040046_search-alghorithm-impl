package app.dls;

import app.Node;

public class DepthLimitedSearch {

    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void search(Node start, Node goal) {
        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());
        Node eval = start;
        for (int i = 0; i < limit; i++) {
            System.out.println("Level "+i+" evaluasi: "+eval.getNilai());
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                break;
            }
            if (!eval.getNightbor().isEmpty()) {
                eval = eval.getNightbor().get(0);
            } else {
                break;
            }
        }
    }
}
