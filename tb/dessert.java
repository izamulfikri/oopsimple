package tb;

public class dessert {
    String nama;
    String dType;

    public dessert(String nama, String dType) {
        this.nama = nama;
        this.dType = dType;
    }

    public dessert(String nama) {
        this.nama = nama;
    }

    public void info() {
        System.out.println("Nama            : " + this.nama);
        System.out.println("Jenis Dessert   : " + this.dType);
    }
}
