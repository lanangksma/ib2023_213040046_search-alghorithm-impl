package app;

import app.bfs.BreadthFirstSearch;
import app.dls.DepthLimitedSearch;
import app.ucs.NodeUCS;
import app.ucs.UniformCostSearch;

public class AppTest {
    public static void main(String[] args) {

        // Membuat Node dengan nama kota
        Node Jakarta = new Node("Jakarta");
        Node Bandung = new Node("Bandung");
        Node Cirebon = new Node("Cirebon");
        Node Malang = new Node("Malang");
        Node Semarang = new Node("Semarang");
        Node Surabaya = new Node("Surabaya");
        Node Surakarta = new Node("Surakarta");
        Node Yogyakarta = new Node("Yogyakarta");

        // Menambahkan tetangga dari setiap kota
        Jakarta.addNightbor(Cirebon);
        Jakarta.addNightbor(Bandung);

        Bandung.addNightbor(Jakarta);
        Bandung.addNightbor(Yogyakarta);
        Bandung.addNightbor(Cirebon);

        Cirebon.addNightbor(Jakarta);
        Cirebon.addNightbor(Bandung);
        Cirebon.addNightbor(Semarang);
        Cirebon.addNightbor(Semarang);

        Semarang.addNightbor(Cirebon);
        Semarang.addNightbor(Surakarta);
        Semarang.addNightbor(Yogyakarta);
        Semarang.addNightbor(Surabaya);

        Yogyakarta.addNightbor(Bandung);
        Yogyakarta.addNightbor(Semarang);
        Yogyakarta.addNightbor(Surakarta);
        Yogyakarta.addNightbor(Cirebon);

        Surakarta.addNightbor(Yogyakarta);
        Surakarta.addNightbor(Semarang);
        Surakarta.addNightbor(Malang);

        Surabaya.addNightbor(Semarang);
        Surabaya.addNightbor(Malang);

        Malang.addNightbor(Surabaya);
        Malang.addNightbor(Surakarta);

        // Mencari solusi dari Jakarta ke Malang dengan menggunakan BFS, DLS, dan UCS
        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(Malang, Jakarta);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(10);
        dls.search(Jakarta, Malang);
        System.out.println();

        // Membuat NodeUCS dengan nama kota dan cost
        NodeUCS JakartaUCS = new NodeUCS(Jakarta, 0);
        NodeUCS BandungUCS = new NodeUCS(Bandung, 270);
        NodeUCS CirebonUCS = new NodeUCS(Cirebon, 327);
        NodeUCS SemarangUCS = new NodeUCS(Semarang, 632);
        NodeUCS YogyakartaUCS = new NodeUCS(Yogyakarta, 643);
        NodeUCS SurakartaUCS = new NodeUCS(Surakarta, 703);
        NodeUCS SurabayaUCS = new NodeUCS(Surabaya, 1001);
        NodeUCS MalangUCS = new NodeUCS(Malang, 1073);

        // Menambahkan tetangga dari setiap kota
        JakartaUCS.addNightbor(CirebonUCS);
        JakartaUCS.addNightbor(BandungUCS);

        BandungUCS.addNightbor(JakartaUCS);
        BandungUCS.addNightbor(YogyakartaUCS);
        BandungUCS.addNightbor(CirebonUCS);

        CirebonUCS.addNightbor(JakartaUCS);
        CirebonUCS.addNightbor(BandungUCS);
        CirebonUCS.addNightbor(SemarangUCS);
        CirebonUCS.addNightbor(SemarangUCS);

        SemarangUCS.addNightbor(CirebonUCS);
        SemarangUCS.addNightbor(SurakartaUCS);
        SemarangUCS.addNightbor(YogyakartaUCS);
        SemarangUCS.addNightbor(SurabayaUCS);

        YogyakartaUCS.addNightbor(BandungUCS);
        YogyakartaUCS.addNightbor(SemarangUCS);
        YogyakartaUCS.addNightbor(SurakartaUCS);
        YogyakartaUCS.addNightbor(CirebonUCS);

        SurakartaUCS.addNightbor(YogyakartaUCS);
        SurakartaUCS.addNightbor(SemarangUCS);
        SurakartaUCS.addNightbor(MalangUCS);

        SurabayaUCS.addNightbor(SemarangUCS);
        SurabayaUCS.addNightbor(MalangUCS);

        MalangUCS.addNightbor(SurabayaUCS);
        MalangUCS.addNightbor(SurakartaUCS);

        // Mencari solusi dari Jakarta ke Malang dengan menggunakan UCS
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(MalangUCS, JakartaUCS);
    }
}
