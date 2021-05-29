import java.util.ArrayList;
public class Sensor extends Vehiculo {

    private String tipo;
    private double valor;

    public Sensor() {
        super.getSensores().add(this);
    }

    public Sensor(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        super.getSensores().add(this);
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public void setValor(double v) {
        this.valor = v;
    }

    public double getValor() {
        return this.valor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String toString() {
        return "TIPO: " + this.tipo + "\n"
        + "VALOR: " + this.valor + "\n" +
        " " + "\n";
    }


}