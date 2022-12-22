package tb;

public class pastry extends bakery implements item {
    double harga, disc;
    int stok;

    public pastry(String nama, String dType, String rasa, String bType, double harga, int stok) {
        super(nama, dType, rasa, bType);
        this.harga = harga;
        this.stok = stok;
    }

    public pastry(String nama, String bType, double harga) {
        super(nama, bType);
        this.harga = harga;
    }

    @Override
    public String getItemName() {
        return super.nama;
    }

    @Override
    public void setHarga(double harga) {
        this.harga = harga;
        
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public double getHarga() {
        return this.harga;
    }

    public int getStok() {
        return stok;
    }

    public String getBType() {
        return super.bType;
    }

    @Override
    public void cekStokItem() {
        if(stok > 0) {
            System.out.println("Sisa stok       : " + stok);
        } else {
            System.out.println("Sisa stok       : Stok habis..");
        }
        
    }

    @Override
    public double diskon(double total) {
        if(total >= 30000) {
            disc = ((total / 100) * 15);
        } else if(total >= 15000 && total < 30000){
            disc = ((total / 100) * 10);
        } else {
            disc = 0;
        }
        return disc;
    }

    @Override
    public void totalHarga(double total) {
        System.out.println("Harga (pcs)     : " + this.harga );
        System.out.println("Diskon          : " + this.diskon(total));
        System.out.println("-----------------------------------------");
        System.out.println("Total Harga     : " + (total - diskon(total)));
    }

    public void cekHargaItem() {
        super.info();
        System.out.println("Harga (pcs)     : " + this.harga );
    }

    public void tambahStokItem(int tambahStok) {
        stok = stok + tambahStok;
        System.out.println("Nama            : " + getItemName());
        cekStokItem();
    }

    public void transaksi(int jmlBeli) {
        if(stok >= 0) {
            double total = harga * jmlBeli;
            cekStokItem();
            totalHarga(total);
        } else {
            System.out.println("Tidak dapat melakukan transaksi..");
        }
    }

    public void infoBeliItem(int jmlBeli) {
        super.info();
        System.out.println("Jumlah beli     : " + jmlBeli);
        transaksi(jmlBeli);
    }

    @Override
    public void beliItem(int jmlBeli) {
        int stok1 = stok - jmlBeli; // if stok < 0 when reduced by jmlBeli, then error (else) without changing the stok value
        if(stok1 >= 0) {
            stok = stok - jmlBeli;
            infoBeliItem(jmlBeli);
        } else {
            System.out.println("Stok kurang.. tidak dapat melakukan pembelian");
        }
    }
}
