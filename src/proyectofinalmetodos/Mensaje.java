package proyectofinalmetodos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Mensaje
 * Clase que muestra mensajes en la interfaz en diferentes formatos
 * Fecha de creación: 3/5/15
 * Fecha de última modificación: 8/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales
 * Descripción de última modificación:
 * "Se agregó un nuevo formato de mensaje, el método obtenerInput(String mensaje), y se cambió el código para que las imágenes se desplegaran correctamente en el archivo JAR."
 * Clases que lo llaman: MTH_Panel, MNR_Panel, MNM_Panel, MCMPR_Panel, OPM_1_Panel, OPM_2_Panel, MGJ_Panel, MNM_Panel
 * Clases que llama: Ninguna
 */

public class Mensaje {
    
    //Atributos
    public ImageIcon errorImagen = new ImageIcon(getClass().getResource("/Imagenes/error.png"));
    public ImageIcon advertenciaImagen = new ImageIcon(getClass().getResource("/Imagenes/Warning.gif"));
    public ImageIcon alarmaImagen = new ImageIcon(getClass().getResource("/Imagenes/alarm.png"));
    public ImageIcon successImagen = new ImageIcon(getClass().getResource("/Imagenes/success.png"));
    public ImageIcon felizImagen = new ImageIcon(getClass().getResource("/Imagenes/caritafeliz.png"));
    public ImageIcon preguntaImagen = new ImageIcon(getClass().getResource("/Imagenes/pregunta.png"));
    
    /**
     * Método que muestra un mensaje de error
     * @param errorTexto texto a desplegar
     */
    public void mostarError(String errorTexto){
        JOptionPane.showMessageDialog(null, errorTexto, "Error", JOptionPane.ERROR_MESSAGE, errorImagen);
    }
    
    /**
     * Método que muestra una advertencia
     * @param advertenciaTexto texto a desplegar
     * @return int (opción escogida)
     */
    public int mostarAdver(String advertenciaTexto){
        String[] options = {"OK"};
        int a = JOptionPane.showOptionDialog(null, advertenciaTexto, "Advertencia", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE, advertenciaImagen, options, options[0]);
        return a;
    }
    
    /**
     * Método que muestra una alarma
     * @param alarmaTexto texto a desplegar
     */
    public void mostarAlarma(String alarmaTexto){
        JOptionPane.showMessageDialog(null, alarmaTexto, "Alarma", JOptionPane.ERROR_MESSAGE, alarmaImagen);
    }
    
    /**
     * Método que muestra acción exitosa
     * @param successTexto texto a desplegar
     */
    public void mostarSuccess(String successTexto){
        JOptionPane.showMessageDialog(null, successTexto, "Éxito", JOptionPane.ERROR_MESSAGE, successImagen);
    }
    
    /**
     * Método que muestra los créditos de la aplicación 
     */
    public void mostrarCreditos(){
        JOptionPane.showMessageDialog(null, "Este programa fue hecho por: \nJosué Morales \nEdwin Limas \nGustavo Moriel \nRodrigo Baca", "Los Inges", JOptionPane.ERROR_MESSAGE, felizImagen);
    }
    
    /**
     * Método que obtiene una entrada en una ventana emergente
     * @param mensaje texto a desplegar
     * @return String (entrada de usuario)
     */
    public String obtenerInput(String mensaje){
        return (String) JOptionPane.showInputDialog(null, mensaje, "Pregunta", JOptionPane.QUESTION_MESSAGE, preguntaImagen, null, null);
    }
    
}
