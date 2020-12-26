package proyectofinalmetodos;
import java.util.ArrayList;
import java.util.List;

/**
 * PolyEquation
 * Clase que simula una ecuación polinomial
 * Fecha de creación: 29/10/16
 * Fecha de última modificación: 3/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales
 * Descripción de última modificación:
 * "En el método derivate() se agregó que en caso de que ya no quedaran terminos con x que se agregara un término con coeficiente de cero."
 * Clases que lo llaman: MTH, MNR, MNM, MCMPR, MTH_Panel, MNR_Panel, MNM_Panel, MCMPR_Panel
 * Clases que llama: ETerm
 */

public class PolyEquation {

    //Atributos
    public List<ETerm> Equation;
    public double Degree;
    public double Lowest_Degree;
    public ArrayList degrees;

    /**
     * Constructor de la clase vacio
     */
    public PolyEquation(){
    }

    /**
     * Método interno que se llama para calcular atributos
     */
    private void createPolyEquation(){
        degrees = new ArrayList();
        for(ETerm eterm: Equation){
            if(!degrees.contains(eterm.Degree)){
                degrees.add(eterm.Degree);
            }
        }
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for(Object obj_degree: degrees) {
            if ((double) obj_degree > max) {
                max = (double) obj_degree;
            }
            if ((double) obj_degree < min) {
                min = (double) obj_degree;
            }
        }
        Degree = max;
        Lowest_Degree = min;
    }

    /**
     * Constructor de la clase con List<String>
     * @param Terms lista de términos
     */
    public PolyEquation(List<String> Terms){
        Equation = new ArrayList<ETerm>();
        List<ETerm> equation_temp = new ArrayList<ETerm>();
        for (String term : Terms) {
            ETerm term_temp = new ETerm(term);
            equation_temp.add(term_temp);
        }

        degrees = new ArrayList();
        for(ETerm eterm: equation_temp){
            if(!degrees.contains(eterm.Degree)){
                degrees.add(eterm.Degree);
            }
        }

        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for(Object obj_degree: degrees){
            if((double) obj_degree > max){
                max = (double) obj_degree;
            }
            if((double) obj_degree < min){
                min = (double) obj_degree;
            }
            ETerm eterm_degree = new ETerm();
            eterm_degree.Degree = (double) obj_degree;
            Equation.add(eterm_degree);
            for(int i = 0; i<equation_temp.size(); i++){
                if((double)obj_degree == equation_temp.get(i).Degree){
                    int posicion = 0;
                    ETerm term_sum = null;
                    for(int a = 0; a<Equation.size(); a++){
                        posicion = a;
                        if(Equation.get(a).Degree == (double) obj_degree){
                            term_sum = Equation.get(a);
                            break;
                        }
                    }
                    double num1 = equation_temp.get(i).Cons * equation_temp.get(i).Sign;
                    double num2 = term_sum.Cons * term_sum.Sign;
                    double new_Cons = num1 + num2;
                    double new_Sign = 0;
                    if(new_Cons>0){
                        new_Sign = 1;
                    }
                    else {
                        if(new_Cons<0){
                            new_Sign = -1;
                            new_Cons = new_Cons * -1;
                        }
                        else {
                            new_Cons = 0;
                        }
                    }
                    term_sum.hasX = equation_temp.get(i).hasX;
                    term_sum.Degree = equation_temp.get(i).Degree;
                    term_sum.Cons = new_Cons;
                    term_sum.Sign = new_Sign;
                    Equation.set(posicion, term_sum);
                }
            }
        }

        Degree = max;
        Lowest_Degree = min;

    }

    /**
     * Método que obtiene el coeficiente del grado especificado.
     * @param degree grado
     * @return coeficiente en caso de que exista, si no, 0.
     */
    public double getCoefficientAtDegree(double degree){
        for (ETerm term: Equation) {
            if(degree == term.Degree){
                return (term.Sign*term.Cons);
            }
        }
        return 0;
    }

    /**
     * Método que determina si existe un grado en la ecuación
     * @param degree grado a checar
     * @return boolean (verdadero - existe, falso - no existe)
     */
    public boolean hasEquationDegree(double degree){
        return degrees.contains(degree);
    }

    /**
     * Método que convierte a String una ecuación
     * @return String (ecuación)
     */
    public String toString(){
        String Res = "";
        for (ETerm term: Equation) {
            Res = Res +((int)term.Sign>0?"+":"")+(int)term.Sign+"*"+term.Cons+(term.hasX?"x^"+term.Degree:"");
        }
        return Res;
    }

    /**
     * Método que evalua un valor x en la función
     * @param x valor a evaluar
     * @return double (f(x))
     */
    public double getFin(double x){
        double res = 0;
        for (ETerm term: Equation) {
            res = res + (term.Sign*term.Cons*Math.pow(x, term.Degree));
        }
        return res;
    }

    /**
     * Método que regresa la derivada de la ecuación
     * @return PolyEquation (derivada)
     */
    public PolyEquation derivate(){
        List<ETerm> new_terms = new ArrayList<ETerm>();
        for(ETerm term : Equation){
            if(term.hasX){
                ETerm temp = new ETerm();
                temp.Degree = term.Degree - (double) 1;
                if(temp.Degree == 0){
                    temp.hasX = false;
                }
                else{
                    temp.hasX = true;
                }
                temp.Cons = term.Sign * term.Cons * term.Degree;
                if(temp.Cons>0){
                    temp.Sign = 1;
                }
                else {
                    if(temp.Cons<0){
                        temp.Sign = -1;
                        temp.Cons = temp.Cons * -1;
                    }
                    else {
                        temp.Cons = 0;
                    }
                }
                new_terms.add(temp);
            }
        }

        if(new_terms.isEmpty()){
            ETerm term_aux = new ETerm();
            term_aux.Degree = 0;
            term_aux.Sign = 1;
            term_aux.Cons = 0;
            term_aux.hasX = false;
            new_terms.add(term_aux);
        }

        PolyEquation Res = new PolyEquation();
        Res.Equation = new_terms;
        Res.createPolyEquation();
        return Res;
    }

}

