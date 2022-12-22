package tb;

public abstract class bakery extends dessert {
    String rasa;
    String bType;

    //constructor w dessert attributes
    public bakery(String nama, String dType, String rasa, String bType) {
        super(nama, dType);
        this.rasa = rasa;
        this.bType = bType;
    }

    public bakery(String nama, String bType){
        super(nama);
        this.bType = bType;
    }

    // setter methods
    public void setDType(String dType){
        super.dType = dType;
    }

    public void setRasa(String rasa){
        this.rasa = rasa;
    }

    public void setBType(String bType) {
        this.bType = bType;
    }

    // getter methods
    public String getDType() {
        return super.dType;
    }

    public String getRasa() {
        return this.rasa;
    }

    public String getBType() {
        return bType;
    }

    //abstract methods (update / diff from uml)
    public abstract void cekStokItem();
    public abstract double diskon(double harga);
    public abstract void totalHarga(double harga);
    public abstract void beliItem(int jmlBeli);
    
    // display info
    @Override
    public void info() {
        super.info();
        System.out.println("Rasa            : " + this.rasa);
        System.out.println("Jenis Bakery    : " + this.bType);
    }
}
