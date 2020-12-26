package proyectofinalmetodos;
import java.util.ArrayList;

/**
 * MTH
 * Clase que contiene los procedimientos necesarios para resolver el método de Horner
 * Fecha de creación: 30/10/16
 * Fecha de última modificación: 14/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "Se agregaron redondeos a los valores cercanos a cero y que detectara y hay raices múltiples."
 * Clases que lo llaman: MTH_Panel
 * Clases que llama: PolyEquation
 */

public class MTH {

    //Atributos
    public ArrayList Coefficients;
    public double x;
    public double A;

    /**
     * Contructor de la clase, asigna atributos y calcula los coeficientes a usar en la primera iteración
     * @param ecuation ecuación a evaluar
     * @param x valor a evaluar
     */
    public MTH(PolyEquation ecuation, double x){
        this.x = x;
        Coefficients = new ArrayList();
        for(double i = ecuation.Degree; i>=0; i--){
            if(ecuation.hasEquationDegree(i)){
                Coefficients.add(ecuation.getCoefficientAtDegree(i));
            }
            else {
                Coefficients.add((double)0);
            }
        }
        A = (double) Coefficients.get(0);
    }

    /**
     * Método que deriva 4 veces la ecuación dada por medio del método de horner
     * @return Arraylist con 4 doubles (f(x), f'(x), f''(x), f'''(x))
     */
    public ArrayList calculate(){
        Validate V = new Validate();
        ArrayList Results = new ArrayList();

        int x = 0;
        int counter = 0;
        while(counter<4){
            ArrayList New_Coefficients = new ArrayList();
            New_Coefficients.add(A);
            for(int y=1;y<Coefficients.size();y++){
                double Res = ((double)New_Coefficients.get(y-1)*this.x + (double)Coefficients.get(y));
                New_Coefficients.add(Res);
            }
            double value = ((double) New_Coefficients.get(New_Coefficients.size()-1)*(V.factorial((double)x)));
            value = (value<0.000001&&value>0)||(value>-0.000001&&value<0)?0:value;
            Results.add(value);
            New_Coefficients.remove((New_Coefficients.size()-1));
            Coefficients = New_Coefficients;
            x++;
            counter++;
        }

        while(Results.size()<4){
            Results.add((double) 0);
        }

        return Results;
    }

    //pos 0 - 3: resultados y 4:conclusion
    /**
     * Método que inicia los cálculos y determina el comportamiento de estos
     * @return ArrayList con 4 doubles (f(x), f'(x), f''(x), f'''(x)), String (conclusión de operación)
     */
    public ArrayList start(){
        String Conclusion = "";
        ArrayList f_results = calculate();
        double x_inF = (double) f_results.get(0);
        double x_inF1 = (double) f_results.get(1);
        double x_inF2 = (double) f_results.get(2);
        double x_inF3 = (double) f_results.get(3);
        
        if(x_inF1>0){
            Conclusion=Conclusion+"F(x) es creciente en x = "+x+".\n";
        }
        else {
            if(x_inF1<0){
                Conclusion=Conclusion+"F(x) es decreciente en x = "+x+".\n";
            }
            else {
                if(x_inF2<0){
                    Conclusion=Conclusion+"La funcion tiene un máximo en ("+ x +", "+x_inF+").\n";
                }
                else {
                    if (x_inF2 > 0) {
                        Conclusion = Conclusion + "La funcion tiene un mínimo en (" + x + ", "+x_inF+").\n";
                    }
                }
            }
        }
        if(x_inF1!=0&&x_inF2==0){
            Conclusion = Conclusion + "La funcion tiene un punto de inflexión en (" + x + ", "+x_inF+").\n";
        }
        if(x_inF2<0){
            Conclusion=Conclusion+"La funcion es cóncava en ("+x+","+x_inF+").\n";
        }
        else {
            if (x_inF2 > 0) {
                Conclusion = Conclusion + "La funcion es convexa en (" + x + ", "+x_inF+").\n";
            } 
        }
        if(x_inF==0&&x_inF1==0){
            Conclusion = Conclusion + "Se detectaron raices múltiples.\n";
        }
        
        f_results.add(Conclusion);
        return  f_results;
    }
}
