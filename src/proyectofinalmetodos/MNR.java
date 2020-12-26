package proyectofinalmetodos;
import java.util.ArrayList;

/**
 * MNR
 * Clase que contiene los procedimientos necesarios para resolver el método de Newton-Raphson
 * Fecha de creación: 30/10/16
 * Fecha de última modificación: 14/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "Se agregó que detectara raices múltiples y redondeo a los valores finales."
 * Clases que lo llaman: MNR_Panel
 * Clases que llama: PolyEquation
 */

public class MNR {

    //Atributos
    public PolyEquation Equation;
    public PolyEquation E_Derivative;
    public double Start;

    /**
     * Constructor de la clase, inicia atributos
     * @param equation ecuación a evaluar
     * @param start valor de inicio
     */
    public MNR(PolyEquation equation, double start){
        Equation = equation;
        Start = start;
        E_Derivative = equation.derivate();
    }

    //llego, res, message
    /**
     * Método que inicia el proceso para encontrar el valor de x cuando se cruce este mismo eje (método de Newton-Raphson) y luego evalua el resultado
     * @return ArrayList con boolean (verdadero - encontró un resultado, falso - no encontro un resultado válido), double (valor de resultado), String (conclusión de resultado)
     */
    public ArrayList start(){
        ArrayList Results = new ArrayList();
        String message = "";
        boolean madeit = true;
        boolean here = false;
        double x = Start;
        double next_x = 0;
        double error = 1;
        double iterations = 0;
        while(error>0.0000000001){
            if(iterations >= 1000){
                message = "Se hicieron 1000 iteraciones y no sé encontró un resultado (indefinido).";
                madeit = false;
                break;
            }
            double f = Equation.getFin(x);
            double f_der = E_Derivative.getFin(x);
            if(f_der==0){
                message = "El valor o la ecuación dados hacen que el método no converja.";
                madeit = false;
                if(f == 0){
                    message = message + "Se encontró raíz múltiple en x = "+x+"\n";
                    here = true;
                    madeit = true;
                }
                break;
            }
            next_x = x - (f/f_der);
            error = Math.abs((next_x-x)/next_x);
            x = next_x;
            iterations++;
        }
        x = (x<0.000001&&x>0)||(x>-0.000001&&x<0)?0:x;
        if(!here&&madeit){
            message = "Se encontró raíz en x = "+x+"\n";
        }
        if(madeit){            
            double x_inF = Equation.getFin(x);
            x_inF = (x_inF<0.000001&&x_inF>0)||(x_inF>-0.000001&&x_inF<0)?0:x_inF;
            double x_inF1 = E_Derivative.getFin(x);
            x_inF1 = (x_inF1<0.000001&&x_inF1>0)||(x_inF1>-0.000001&&x_inF1<0)?0:x_inF1;
            PolyEquation second_derivative = E_Derivative.derivate();
            double x_inF2 = second_derivative.getFin(x);
            x_inF2 = (x_inF2<0.000001&&x_inF2>0)||(x_inF2>-0.000001&&x_inF2<0)?0:x_inF2;
            PolyEquation third_derivative = second_derivative.derivate();
            double x_inF3 = third_derivative.getFin(x);
            x_inF3 = (x_inF3<0.000001&&x_inF3>0)||(x_inF3>-0.000001&&x_inF3<0)?0:x_inF3;

            if(x_inF1>0){
                message=message+"F(x) es creciente en x = "+x+".\n";
            }
            else {
                if(x_inF1<0){
                    message=message+"F(x) es decreciente en x = "+x+".\n";
                }
                else {
                    if(x_inF2<0){
                        message=message+"La funcion tiene un máximo en ("+ x +", " + x_inF + ").\n";
                    }
                    else {
                        if (x_inF2 > 0) {
                            message = message + "La funcion tiene un mínimo en (" + x + ", " + x_inF + ").\n";
                        }
                    }
                }
            }
            if(x_inF1!=0&&x_inF2==0){
                message = message + "La funcion tiene un punto de inflexión en (" + x + ", " + x_inF + ").\n";
            }
            if(x_inF2<0){
                message=message+"La funcion es cóncava en ("+x+", "+x_inF+").\n";
            }
            else {
                if (x_inF2 > 0) {
                    message = message + "La funcion es convexa en (" + x + ", " + x_inF + ").\n";
                } 
            }
            if(x_inF==0&&x_inF1==0){
                message = message + "Se detectaron raices múltiples.\n";
            }
        }
        Results.add(madeit);
        Results.add(x);
        Results.add(message);

        return Results;
    }
}
