package tb;

public abstract class snack extends dessert implements item {
    int stok;

    public snack(String nama, String dType) {
        super(nama, dType);
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void unavail() {
        setStok(0);
        if(stok == 0) {
            info();
            System.out.println("-----------------------------------------");
            System.out.println("Maaf stok sedang kosong, coba lain hari..");
        } else {
            info();
            System.out.println("-----------------------------------------");
            System.out.println("Bisa bang");
        }
    }
    
    @Override
    public void info() {
        super.info();
        System.out.println("Stok            : " + getStok());
    }
}
