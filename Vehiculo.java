import java.util.ArrayList;
public class Vehiculo {

    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual= 1;

    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo(){
        id = idActual;
        Vehiculo.vehiculos.add(this);
        idActual++;
    }

    public Vehiculo(int modelo, String marca, double valorComercial){
        this(modelo,marca,valorComercial,"verde");

    }

    public Vehiculo(int modelo, String marca, double valorComercial, String color){
        this.modelo= modelo;
        this.marca= marca;
        this.valorComercial= valorComercial;
        this.color= color;       

        Vehiculo.vehiculos.add(this);
    }

    @Override
    public String toString(){
        return 
        "ID = "+ this.id + "\n" +
        "MODELO = "+ this.modelo + "\n" +
        "MARCA =" + this.marca + "\n" +
        "VALOR COMERCIAL= " + this.valorComercial  + "\n" +
        "COLOR = "+ this.color + "\n" +
        " " + "\n";
    }

    public ArrayList<Sensor> getSensores(){

        return this.sensores;
    }

    public int getId(){
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public double getValorComercial() {
        return valorComercial;
    }

    public void setColor(String co) {
        this.color = co;
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }

    public void setModelo(int mo) {
        this.modelo = mo;
    }

    public void setValorComercial(double va) {
        this.valorComercial = va;
    }

    public void setId(int id){
        this.id= id;
    }

    public void setSensores(ArrayList<Sensor>sensores){
        this.sensores= sensores;
    }

    public static String toStringVehiculos(){
        String info = " ";
        if(Vehiculo.vehiculos.size() > 0){
            for(int i= 0; i < Vehiculo.vehiculos.size(); i++ ){
                info =  Vehiculo.vehiculos.get(i).toString() + info;
            }
        }
        return info;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public static String vehiculosVerdes() {
        String info = " ";
        boolean contador= false;        
        for (int i = 0; i < Vehiculo.vehiculos.size(); i++) {
            if (Vehiculo.vehiculos.get(i).getColor().equals("verde")) {
                System.out.println(Vehiculo.vehiculos.get(i).toString() + info);
                contador= true;
            }
        }
        return info;
    }

    public static Vehiculo obtenerVehiculoPorId(int id){
        for (int i = 0; i < Vehiculo.vehiculos.size(); i++) {
            if(Vehiculo.vehiculos.get(i).getId() == id){
                return Vehiculo.vehiculos.get(i);
            }
        }
        return null;
    }

    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }

    public String toStringSensores(){
        String info = "";
        if(this.sensores.size()>0){
            for(int i= 0; i < this.sensores.size(); i++ ){
                info = info.concat(this.sensores.get(i).toString());
            }
        }
        return info;
    }

    public static ArrayList<Sensor> ordenarSensor() {
        ArrayList<Sensor> posMayor = new ArrayList<Sensor>();
        for(Vehiculo vehiculo : vehiculos){
            ArrayList<Sensor> temp = vehiculo.getSensores();
            for(Sensor sensor : temp){
                if (sensor.getTipo().toUpperCase().equals("TEMPERATURA")){
                    posMayor.add(sensor);
                }
            }
        }
        
        int menor;
        double contador;
        for(int i =0; i < posMayor.size()-1;i++){
            menor = i;
            for(int j = 0; j < posMayor.size(); j++){
                if(posMayor.get(j).getValor() < posMayor.get(menor).getValor()){
                    menor = j;
                }
            }
            contador = posMayor.get(i).getValor();
            posMayor.get(i).setValor(posMayor.get(menor).getValor());
            posMayor.get(menor).setValor(contador);
        }
        return posMayor;
    }
    public static String sensoresTemperatura() {
        String info = " ";
        for(Vehiculo vehiculo : vehiculos){
            info = info.concat("");
            if(vehiculo.cantidadSensores()>0){
                for(int i = 0; i < vehiculo.cantidadSensores();i++){
                    if(vehiculo.getSensores().get(i).getTipo().toUpperCase().equals("TEMPERATURA")){
                        info = info.concat(vehiculo.getSensores().get(i).toString());
                    }
                }
            }
        }
        return info;
     }
}

