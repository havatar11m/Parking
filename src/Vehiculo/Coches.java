package Vehiculo;

public class Coches extends Vehiculo{

    private int dni;
    private boolean electrico;

    public Coches(int matricula, String modelo, String marca, int dni, boolean electrico) {
        super(matricula, modelo, marca);
        this.dni = dni;
        this.electrico = electrico;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }
}
