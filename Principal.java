import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
    public static void main (String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in); 

        System.out.println("----Ingrese una opcion----");
        System.out.println("----Ingrese 1 para añadir vehiculo.----");
        System.out.println("----Ingrese 2 para mostar informacion de todos los vehiculos.----");
        System.out.println("----Ingrese 3 para mostrar la cantidad de vehiculos almacenados.----");
        System.out.println("----Ingrese 4 para mostrar los vehiculos de color verde.----");
        System.out.println("----Ingrese 5 para buscar un carro por ID.----");
        System.out.println("----Ingrese 6 para agregar un sensor a un vehiculo con ID----");
        System.out.println("----Ingrese 7 para mostrar los vehiculos con ID que contienen sensores.----");
        System.out.println("----Ingrese 8 para mostrar la informacion de todos los sensores de temperatura----");
        System.out.println("----Ingrese 666 para mostrar todos los sensores de temperatura ordenados por valor----");

        while(true){

            int num = scan.nextInt();
            switch(num){

                case 0:
                System.out.println("GRACIAS POR SU VISITA");
                break;

                case 1:

                Vehiculo v1 = new Vehiculo();

                System.out.println("INGRESE EL MODELO= ");
                int modelo = scan.nextInt();
                v1.setModelo(modelo);

                System.out.println("INGRESE LA MARCA= ");
                String marca = scan.next();
                v1.setMarca(marca);

                System.out.println("INGRESE EL VALOR COMERCIAL= ");
                int valorComercial = scan.nextInt();
                v1.setValorComercial(valorComercial);

                System.out.println("INGRESE EL COLOR= ");
                String color  = scan.next();
                v1.setColor(color);

                continue;

                case 2:
                System.out.println(Vehiculo.toStringVehiculos());
                continue;

                case 3:
                System.out.println("LA CANTIDAD DE VEHICULOS ALMACENADOS ES = " + Vehiculo.cantidadVehiculos());
                continue;

                case 4:
                System.out.println("LA CANTIDAD DE VEHICULOS VERDES ALMACENADOS ES = "+ Vehiculo.vehiculosVerdes());
                continue;

                case 5:
                System.out.println("INGRESE UN ID = ");
                int id = scan.nextInt();
                boolean encontrado = false;
                for(int i = 0; i < Vehiculo.vehiculos.size(); i++ ){
                    if(Vehiculo.vehiculos.get(i).getId() == id){
                        System.out.println(Vehiculo.vehiculos.get(i).toString());
                        encontrado = true;
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("NO SE ENCONTRO UN VEHICULO CON ESTE ID.");
                }
                continue;

                case 6:
                System.out.println("INGRESE UN ID = ");
                id = scan.nextInt();
                Vehiculo v2 = Vehiculo.obtenerVehiculoPorId(id);
                if(v2 == null){
                    System.out.println("NO SE ENCONTRO UN VEHICULO CON ESTE ID.");
                }else{
                    Sensor s1 = new Sensor();
                    System.out.println("INGRESE EL TIPO= ");
                    String tipo = scan.next();
                    s1.setTipo(tipo);
                    System.out.println("INGRESE EL VALOR= ");
                    int valor = scan.nextInt();

                    s1.setValor(valor);

                    v2.anadirSensor(s1);
                    for(int i = 0; i < Vehiculo.vehiculos.size(); i++){
                        if(Vehiculo.vehiculos.get(i).getId() == v2.getId()){
                            Vehiculo.vehiculos.set(i,v2);
                            break;
                        }
                    }
                }
                continue;

                case 7:
                System.out.println("INGRESE UN ID = ");
                id = scan.nextInt();

                if(Vehiculo.obtenerVehiculoPorId(id)==null){
                    System.out.println("NO SE ENCONTRO UN VEHICULO CON ESTE ID.");
                }else{
                    Vehiculo vehiculo=Vehiculo.obtenerVehiculoPorId(id);
                    System.out.println(vehiculo.toStringSensores());
                }

                continue;

                case 8:
                System.out.println(Vehiculo.sensoresTemperatura());
                continue;
                /*
                case 9:

                case10:
                 */
                case 666:
                System.out.println(Vehiculo.ordenarSensor());
                continue;
            }
            break;
        }
        
    }
}
