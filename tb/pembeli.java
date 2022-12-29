package tb;
public class pembeli extends human{
    double totalHarga = 0;
    pembelian p = new pembelian();
    
    pembeli(){}
    pembeli(String nama){
        super(nama,"pembeli");
    }

    // method lihat stok

    void info(){
        System.out.println();
        System.out.println("Atas nama "+super.nama);
        System.out.println("--------------------------");
        System.out.println("Nama     : "+p.nama);
        System.out.println("Harga    : "+p.harga);
        System.out.println("Jumlah   : "+p.jumlah);
        System.out.println("Total    : "+this.totalHarga);
        System.out.println();
    }
    // menampilkan riwayat pembelian
}
