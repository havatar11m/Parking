package Vehiculo;

public class Autobus extends Vehiculo{
    private  int plaza;
    private String compania;

    public Autobus(int matricula, String modelo, String marca, String compania) {
        super(matricula, modelo, marca);
        this.compania = compania;
        cargarPlaza();
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    private void cargarPlaza(){

    }

}
