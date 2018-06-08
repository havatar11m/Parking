package Vehiculo;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(int matricula, String modelo, String marca, int cilindrada) {
        super(matricula, modelo, marca);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
