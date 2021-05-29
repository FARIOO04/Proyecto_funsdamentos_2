public class Bichos{
    private int salud;
    private String nombre;

    public static void tablaBichos(Bichos[][]bichos){
        System.out.println("-------------");
        for(int i = 0; i < 2; i++){
            System.out.print("|");
            for(int j = 0; j<2;j++){
                if(bichos[i][j].getNombre().equals("")){
                    System.out.print("     "+"|");
                }else{
                    System.out.print(bichos[i][j].toString()+"|");
                }
            }
            System.out.println();
            System.out.println("-------------");
        } 
    }

    public Bichos(String nombre,int salud){
        this.salud = salud;
        this.nombre = nombre;
    }    

    public String toString(){
        return this.nombre+ "-" +this.salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getSalud(){
        return salud;  
    }

    public String getNombre(){
        return nombre;  
    }

    public void atacar() {
        this.setSalud(this.getSalud()-5);
    }

    public void bombaAtomica() {
        this.setSalud(this.getSalud()-this.getSalud());
    }

    public void bichoMutante(){
        this.setSalud(this.getSalud()*2);
    }
}
