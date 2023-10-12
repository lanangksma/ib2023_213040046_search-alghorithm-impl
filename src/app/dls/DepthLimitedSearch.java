package app.dls;

import app.Node;

public class DepthLimitedSearch {

    //inisialisasi variabel
    private int limit;

    //getter dan setter limit
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    //membuat method search dengan parameter start dan goal
    public void search(Node start, Node goal) {
        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());
        Node eval = start;//inisialisasi node evaluasi dengan node start

        //looping selama limit kurang dari 0
        for (int i = 0; i < limit; i++) {
            System.out.println("Level "+i+" evaluasi: "+eval.getNilai());
            //jika node evaluasi sama dengan node goal
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan "); //maka solusi ditemukan
                break; //menghentikan looping
            }
            //jika node evaluasi tidak sama dengan node goal
            if (!eval.getNightbor().isEmpty()) {
                eval = eval.getNightbor().get(0); //node evaluasi sama dengan node tetangga pertama
            } else {
                break; //jika node evaluasi tidak memiliki tetangga maka menghentikan looping
            }
        }
    }
}
