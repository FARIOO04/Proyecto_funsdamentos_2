import java.util.Scanner;
public class MiniJuego{
    public static void main (String [] args){
        Bichos [][] bichos = new Bichos [2][2]; 
        Scanner scan = new Scanner(System.in);

        System.out.println("----Bienvenido presione el numero 1 para comenzar el Juego.----");
        System.out.println("----Presione el numero 2 para disparar una bala.----");
        System.out.println("----Presione el numero 3 para activar bomba atomica.----");
        System.out.println("----Presione el numero 4 para activar bicho mutante.----");
        System.out.println("----Presione el numero 0 para salir.----");

        int num = scan.nextInt();

        while(true){

            if(num == 0){
                System.out.println("EL JUEGO HA TERMINADO.");
                break;

            }else if(num == 1){
                for(int i  = 0; i < 2; i++){
                    for(int j = 0; j < 2;j++){
                        bichos[i][j] = new Bichos("",0);
                    }
                }

                int cantidadBichos = (int )Math.floor(Math.random()*4+1);
                System.out.println("Se creara esta cantidad de bichos = " + cantidadBichos); 

                int limite = 0;

                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        int bichoaCrear = (int )Math.floor(Math.random()*2+1);
                        if(limite == cantidadBichos){
                            break;
                        }else if(bichoaCrear == 1){
                            Bichos b1 = new Bichos("BN",10);
                            limite++;
                            bichos[i][j] = b1;
                        }else if(bichoaCrear == 2){
                            Bichos b2 = new Bichos("BA",20);
                            limite++;
                            bichos[i][j] = b2;
                        }
                    }
                }

                Bichos.tablaBichos(bichos);
            }else if (num == 2){

                System.out.println("Ingrese el numero de la fila:");

                int fila = scan.nextInt();

                System.out.println("Ingrese el numero de la columna:");

                int columna = scan.nextInt();
                if (fila > 1){
                    break;
                }else if(columna > 1){
                    break;  
                }else{
                    bichos[fila][columna].atacar();
                }

                Bichos.tablaBichos(bichos); 
            }else if(num==3){
                int filaA = (int)Math.floor(Math.random()*2);
                int columnaA = (int)Math.floor(Math.random()*2);

                bichos[filaA][columnaA].bombaAtomica();
                Bichos.tablaBichos(bichos);
            }else if(num==4){
                int posMenor = 0;
                int posMenor1 = 0;
                int mayorBichos = bichos[0][0].getSalud();

                for(int i=0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        if(bichos[i][j].getSalud()!=0){ 
                            if(mayorBichos > bichos[i][j].getSalud()){
                                mayorBichos = bichos[i][j].getSalud();
                                posMenor = i;
                                posMenor1 = j;
                            }
                        }
                    }
                }
                bichos[posMenor][posMenor1].bichoMutante();
                Bichos.tablaBichos(bichos);
                
            }
            if(bichos[0][0].getSalud()==0){
                if(bichos[0][1].getSalud()==0){
                    if(bichos[1][0].getSalud()==0){
                        if(bichos[1][1].getSalud()==0){
                            break;
                        }
                    }
                }
            }

            num = scan.nextInt();            
        }

    }
}