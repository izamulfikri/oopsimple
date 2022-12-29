package tb;

import java.util.Scanner;
import java.util.ArrayList;

public class main {
    static String namaToko = "FIEL";
    static Scanner in = new Scanner(System.in); // scanner for number
    static Scanner sc = new Scanner(System.in); // scanner for string
    static double pendapatan = 0; // untuk menampung jumlah pendapatan
    static ArrayList<pembeli> p = new ArrayList<pembeli>(); // untuk menampung data pembeli
    // instansiasi for admin and stok
    // admin
    static admin fikri = new admin("fikri", "admin", "123");
    static admin elang = new admin("elang", "admin", "456");

    // etalase
    static roti r1 = new roti("Aoki", "Bakery", "Manggis", "Roti", 3000, 10);
    static kue k1 = new kue("Lapos", "Bakery", "Coklat", "Kue", 7000, 12);
    static pastry p1 = new pastry("Crosing", "Bakery", "Stroberi", "Pastry", 10000, 15);

    // info bakery

    static void infoBakery(ArrayList<bakery> baker) {
        if (baker instanceof roti) {
            r1.info();
        } else if (baker instanceof kue) {
            k1.info();
        } else if (baker instanceof pastry) {
            p1.info();
        }
    }

    // method welcome
    static void welcome(ArrayList<bakery> b) {
        System.out.println("======================================");
        System.out.printf("|  Selamat Datang di Toko Roti %s  |\n", namaToko);
        System.out.println("======================================");
        selectUser(b);
    }

    // method select user
    static void selectUser(ArrayList<bakery> b) {
        int opsi = 0;
        do {
            System.out.println("Kamu adalah...");
            System.out.println("1. Admin");
            System.out.println("2. Pembeli");
            System.out.print("> ");
            opsi = in.nextInt();

            switch (opsi) {
                case 1:
                    cekAdmin(fikri, elang, b);
                    break;
                case 2:
                    buyerMenus(b);
                    break;
                case 3:
                    System.out.println("\nSampai jumpa lagi...");
                    break;
                default:
                    System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        } while (opsi != 3);
    }

    // method show stok
    static void etalase(ArrayList<bakery> b) {
        System.out.println();
        if (b.get(0) instanceof roti) {
            System.out.println("-- Etalase Roti --");
            r1.info();
        }
        if (b.get(1) instanceof kue) {
            System.out.println("\n-- Etalase Kue --");
            k1.info();
        }
        if (b.get(2) instanceof pastry) {
            System.out.println("\n-- Etalase Pastri --");
            p1.info();
        }
        System.out.println();
    }

    // method admin

    // method update
    static void updateEtalase() {
        int opsi = 0;
        System.out.println("Pilih data yang mau di edit");
        System.out.println("1. Edit Roti");
        System.out.println("2. Edit Kue");
        System.out.println("3. Edit Pastry");
        System.out.print("> ");
        opsi = in.nextInt();

        System.out.println("-- Data Awal --");
        switch (opsi) {
            case 1:
                r1.infoTmp();
                editEtalase(opsi);
                break;
            case 2:
                k1.infoTmp();
                editEtalase(opsi);
                break;
            case 3:
                p1.infoTmp();
                editEtalase(opsi);
                break;
        }
    }

    // method edit data
    static void editEtalase(int opsi) {
        String nama;
        String rasa;
        double harga;
        int stok;

        System.out.println("-- Masukkan data baru --");
        System.out.print("nama  : ");
        nama = sc.nextLine();
        System.out.print("Rasa  : ");
        rasa = sc.nextLine();
        System.out.print("Harga : ");
        harga = in.nextDouble();
        System.out.print("Stok  : ");
        stok = in.nextInt();

        switch (opsi) {
            case 1:
                r1.changeData(nama, rasa, harga, stok);
                System.out.println("-- Data setelah di update --");
                r1.infoTmp();
                break;
            case 2:
                k1.changeData(nama, rasa, harga, stok);
                System.out.println("-- Data setelah di update --");
                k1.infoTmp();
                break;
            case 3:
                p1.changeData(nama, rasa, harga, stok);
                System.out.println("-- Data setelah di update --");
                p1.infoTmp();
                break;
        }
    }

    // validating login admin
    static void cekAdmin(admin a, admin b, ArrayList<bakery> ba) {
        int count = 0; // when false three times input will jump back to home section
        boolean cek = false;
        ArrayList<admin> c = new ArrayList<admin>();
        c.add(a);
        c.add(b);
        String n, p;
        do {
            System.out.print("Masukkan nama     : ");
            n = sc.nextLine();
            System.out.print("Masukkan password : ");
            p = sc.nextLine();

            // do loop for checking available admin
            for (int i = 0; i < c.size(); i++) {
                // if true jump to adminMenus
                if (n.equals(c.get(i).name()) && p.equals(c.get(i).password)) {
                    adminMenus(ba);
                }
            }

            if (count == 3) { // when false three times input will jump back to home section
                cek = true;
                welcome();
            }
            count++;
            System.out.println("\nnama atau password tidak sesuai (sisa percobaan " + (3 - count) + ")\n");
        } while (cek == false);
    }

    // menus for admin
    static void adminMenus(ArrayList<bakery> b) {
        int opsi = 0;
        System.out.println("\n Selamat datang admin");
        do {
            System.out.println("Pilih Menu");
            System.out.println("1. Update etalase");
            System.out.println("2. Lihat etalase"); // sudah
            System.out.println("3. Penghasilan total");
            System.out.println("4. Menu awal");
            System.out.print(">");
            opsi = in.nextInt();

            switch (opsi) {
                case 1:
                    updateEtalase();
                    break;

                case 2:
                    etalase(b);
                    break;

                case 3:
                    // method income
                    totalPendapatan();
                    System.out.println("Total pendaptan : " + pendapatan);
                    break;

                case 4:
                    System.out.println("\nKembali ke menu awal...\n");
                    welcome();
                    break;

                default:
                    System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        } while (opsi != 4);
    }

    // method hitung pendapatan total sejauh ini
    static void totalPendapatan() {
        pendapatan = 0;
        for (int i = 0; i < p.size(); i++) {
            pendapatan += p.get(i).totalHarga;
        }
    }

    // method buyer
    static void buyerMenus(ArrayList<bakery> b) {
        int opsi = 0;
        System.out.println("\n Selamat datang di etalase");
        System.out.print("Masukkan namamu : ");
        String nama = sc.nextLine();
        do {
            System.out.println("Pilih Menu");
            System.out.println("1. Beli Kue");
            System.out.println("2. Menu awal");
            System.out.print("> ");
            opsi = in.nextInt();

            switch (opsi) {
                case 1:
                    etalase(b);
                    beli(nama);
                    break;

                case 2:
                    System.out.println("\nTerimakasih sudah melakukan transaksi...");
                    System.out.println("Kembali ke menu awal...\n");
                    break;

                default:
                    System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        } while (opsi != 2);
    }

    // method beli
    static void beli(String nama) {
        pembeli pem = new pembeli(nama);
        int opsi = 0;
        System.out.println("-- silahkan pilih --");
        System.out.println("1. Roti");
        System.out.println("2. Kue");
        System.out.println("3. Pastry");
        System.out.print("> ");
        opsi = in.nextInt();
        System.out.print("Masukkan jumlah pembelian : ");
        int jumlah = in.nextInt();

        // to checking opsi has been input
        switch (opsi) {
            case 1:
                r1.beliItem(jumlah);
                pem.totalHarga = r1.getHargaTotal(r1.getTotalKotor(jumlah));
                break;
            case 2:
                k1.beliItem(jumlah);
                pem.totalHarga = k1.getHargaTotal(k1.getTotalKotor(jumlah));
                break;
            case 3:
                p1.beliItem(jumlah);
                pem.totalHarga = p1.getHargaTotal(p1.getTotalKotor(jumlah));
                break;
        }
        p.add(pem);
        System.out.println("terimakasih " + nama + " sudah bertransaksi...\n");
    }


    // method main
    public static void main(String[] args) {
        ArrayList<bakery> b = new ArrayList<bakery>();
        b.add(r1);
        b.add(k1);
        b.add(p1);
        welcome(b);
    }
}
