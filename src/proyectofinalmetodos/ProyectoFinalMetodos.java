
package proyectofinalmetodos;

public class ProyectoFinalMetodos {

    public ProyectoFinalMetodos(){
        Window ventana = new Window();
        ventana.setVisible(true);
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            ventana.setSize(ventana.getWidth(), ventana.getHeight()-10);
        }
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mensaje M = new Mensaje();
        try{
            ProyectoFinalMetodos programa = new ProyectoFinalMetodos();
        }
        catch(Exception e){
            M.mostarError("ERROR FATAL: "+e.toString()+"\nCERRANDO PROGRAMA.");
            System.exit(0);
        }
    }
    
}
