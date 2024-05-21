public abstract class Arma {
    protected int cantMuniciones;
    protected double alcance;
    protected String marca;
    protected int calibre;
    protected String estado;

    public Arma(int cantMuniciones, double alcance, String marca, int calibre, String estado) {
        this.cantMuniciones = cantMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }

    public abstract boolean enCondicion();

    @Override
    public String toString() {
        return "Marca: " + marca + ", Calibre: " + calibre;
    }
}
