package proyectofinalmetodos;
import java.util.ArrayList;

/**
 * MNM
 * Clase que contiene los procedimientos necesarios para resolver el método de Newton Multivariable
 * Fecha de creación: 2/10/16
 * Fecha de última modificación: 31/10/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "El método se paraba cuando las derivadas daban 0 y daba un resultado erróneo, por lo que se modificó" 
 * Clases que lo llaman: MNM_Panel
 * Clases que llama: Matrix, PolyEquation
 */

public class MNM {
    
    //Atributos
    public PolyEquation Equation1;
    public PolyEquation Equation2;
    public double Start_x;
    public double Start_y;
    
    /**
     * Constructor de la clase, inicia atributos
     * @param equation1 primera ecuación
     * @param equation2 segunda ecuación
     * @param start_x valor inicial de x
     * @param start_y valor inicial de y
     */
    public MNM(PolyEquation equation1, PolyEquation equation2, double start_x, double start_y) {
        Equation1 = equation1;
        Equation2 = equation2;
        Start_x = start_x;
        Start_y = start_y;
    }

    //boolean, String, double, double
    /**
     * Método que inicia el proceso para encontrar la intersección de dos ecuaciones (método de Newton Multivariable)
     * @return ArrayList con boolean (verdadero - se encontró un resultado, falso - no se encontró un resultado), String (conclusión de operación), double (resultado en x), double (resultado en y)
     */
    public ArrayList start() {
        String Conclusion = "";
        boolean madeit = true;
        ArrayList results = new ArrayList();
        double x1_bu = 0;
        double x2_bu = 0;
        double x1 = Start_x;
        double x2 = Start_y;
        double Error = 1;
        PolyEquation Derivative_1 = Equation1.derivate();
        PolyEquation Derivative_2 = Equation2.derivate();
        int counter = 0;
        while (Error > 0.0000000001) {//0.0000000001
            if (counter == 350) {
                madeit = false;
                Conclusion = "El método diverge con los valores dados.";
                break;
            }

            Matrix J = new Matrix(2, 2);
            J.Values[0][1] = -1;
            J.Values[1][1] = -1;
            Matrix Fs = new Matrix(2, 1);

            double derivative1_value = Derivative_1.getFin(x1);
            double derivative2_value = Derivative_2.getFin(x1);
            J.Values[0][0] = derivative1_value;
            J.Values[1][0] = derivative2_value;
            Fs.Values[0][0] = Equation1.getFin(x1) - x2;
            Fs.Values[1][0] = Equation2.getFin(x1) - x2;
            Matrix diff = J.inverse().productWith(Fs);

            x1_bu = x1;
            x2_bu = x2;
            x1 = x1 - diff.Values[0][0];
            x2 = x2 - diff.Values[1][0];

            Error = Math.sqrt(Math.pow(diff.Values[0][0], 2) + Math.pow(diff.Values[1][0], 2));
            counter++;
        }
        results.add(madeit);
        results.add(Conclusion);
        results.add(x1_bu);
        results.add(x2_bu);
        return results;
    }
}