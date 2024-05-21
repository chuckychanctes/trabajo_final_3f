public class Policia {
    private String nombre;
    private String apellido;
    private int legajo;
    private Arma arma;

    public Policia(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    // Métodos getter y setter para el atributo 'arma'
    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Legajo: " + legajo;
    }
}
