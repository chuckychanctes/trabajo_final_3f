public class Larga extends Arma implements Comparable<Larga> {
    private String justifUso;
    private int nivelArma;
    private boolean tieneSello;

    public Larga(int cantMuniciones, double alcance, String marca, int calibre, String estado, String justifUso, int nivelArma, boolean tieneSello) {
        super(cantMuniciones, alcance, marca, calibre, estado);
        this.justifUso = justifUso;
        this.nivelArma = nivelArma;
        this.tieneSello = tieneSello;
    }

    @Override
    public int compareTo(Larga otraArma) {
        return Integer.compare(this.nivelArma, otraArma.nivelArma);
    }

    @Override
    public String toString() {
        return super.toString() + ", Justificación de Uso: " + justifUso + ", Nivel del Arma: " + nivelArma;
    }

    @Override
    public boolean enCondicion() {
        return estado.equals("EN USO") && calibre >= 9;
    }
}
