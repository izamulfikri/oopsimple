package tb;

public class human {
    String nama;
    String type;

    human(){}
    human(String nama, String type){
        this.nama = nama;
        this.type = type;
    }

    String getName(){
        return this.nama;
    }
}
