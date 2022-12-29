package tb;
import java.util.ArrayList;
public class admin extends human{
    ArrayList<pembeli> pembeli = new ArrayList<pembeli>(); // untuk menyimpan data pembeli

    String password;
    admin(String nama, String type, String password){
        super(nama,type);
        this.password = password;
    }

    String name(){
        return super.nama;
    }
}
