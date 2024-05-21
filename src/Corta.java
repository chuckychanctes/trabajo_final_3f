public class Corta extends Arma {
    private boolean esAutomatica;

    public Corta(int cantMuniciones, double alcance, String marca, int calibre, String estado, boolean esAutomatica) {
        super(cantMuniciones, alcance, marca, calibre, estado);
        this.esAutomatica = esAutomatica;
    }

    public boolean efectividadMts() {
        return alcance > 200;
    }

    @Override
    public boolean enCondicion() {
        return estado.equals("EN USO") && calibre >= 9;
    }
}
