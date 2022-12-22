package tb;
import java.util.Scanner;

public class main {
    static String namaToko = "FIEL";
    static Scanner in = new Scanner(System.in); // scanner for number
    static Scanner sc = new Scanner(System.in); // scanner for string

    // method welcome
    static void welcome(){
        System.out.println("======================================");
        System.out.printf("|  Selamat Datang di Toko Roti %s  |\n",namaToko);
        System.out.println("======================================");
        selectUser();
    }

    // method select user
    static void selectUser(){
        int opsi=0;
        do{
            System.out.println("Kamu adalah...");
            System.out.println("1. Admin");
            System.out.println("2. Pembeli");
            System.out.print(">");opsi = in.nextInt();

            switch(opsi){
                case 1:
                
                break;
                case 2:

                break;
                
                case 3:
                System.out.println("\nSampai jumpa lagi...");
                break;

                default:
                System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        }while(opsi != 3);
    }

    // method admin

    // validating login admin
    static void cekAdmin(){
        int count = 0;  // when false three times input will jump back to home section
        boolean cek = false;
        String n,p;
        do{
            System.out.print("Masukkan nama     : ");n = sc.nextLine();
            System.out.print("Masukkan password : ");p = sc.nextLine();

            // do loop for checking available admin
            // if true jump to adminMenus
            
            if(count==3){ // when false three times input will jump back to home section
                cek=true;
                welcome();
            }
        }while(cek==false);
    }

    // menus for admin
    static void adminMenus(){
        int opsi = 0;
        System.out.println("\n Selamat datang admin");
        do{
            System.out.println("Pilih Menu");
            System.out.println("1. Update etalase");
            System.out.println("2. Lihat etalase");
            System.out.println("3. Penghasilan total");
            System.out.println("4. Menu awal");
            System.out.print(">");opsi = in.nextInt();

            switch(opsi){
                case 1:
                // method update
                break; 

                case 2:
                // method display
                break;

                case 3:
                // method income
                break;

                case 4:
                System.out.println("\nKembali ke menu awal...\n");
                break;

                default:
                System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        }while(opsi!=4);
    }

    // method buyer
    static void buyerMenus(){
        int opsi = 0;
        System.out.println("\n Selamat datang di etalase");
        System.out.println("Masukkan namamu : ");
        String nama = sc.nextLine();
        do{
            System.out.println("Pilih Menu");
            System.out.println("1. Beli Kue");
            System.out.println("2. Lihat Riwayat Beli");
            System.out.println("3. Menu awal");
            System.out.print(">");opsi = in.nextInt();

            switch(opsi){
                case 1:
                // method buy
                break; 

                case 2:
                // method history
                break;

                case 3:
                System.out.println("\nTerimakasih sudah melakukan transaksi...");
                System.out.println("Kembali ke menu awal...\n");
                break;

                default:
                System.out.println("\nPilihan yang dimasukkan tidak valid...\n");
            }
        }while(opsi!=3);
    }


    // method main
    public static void main(String[] args) {
        // instansiasi for admin and stok
        // admin
        admin fikri = new admin("fikri","admin","123");
        admin elang = new admin("elang","admin","456");

        // etalase
        roti r1 = new roti("Aoki", "Bakery", "Manggis", "Roti", 3000, 10);
        kue k1 = new kue("Lapos", "Bakery", "Coklat", "Kue", 7000, 12);
        pastry p1 = new pastry("Crosing", "Bakery", "Stroberi", "Pastry", 10000, 15);

        welcome();
    }
}
