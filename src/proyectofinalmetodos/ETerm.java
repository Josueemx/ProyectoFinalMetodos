package proyectofinalmetodos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ETerm
 * Clase quesimula un término de una ecuación polinomial.
 * Fecha de creación: 29/10/16
 * Fecha de última modificación: 2/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "En el constructor con String: Si la String a convertir a término contiene 
 * '-x', el coeficiente se vuelve 1, el signo negativo y su grado 1" 
 * Clases que lo llaman: PolyEquation
 * Clases que llama: Ninguna
 */
public class ETerm {

    //Atributos de la clase
    public double Degree;
    public double Sign;
    public double Cons;
    public boolean hasX;

    /**
     * Constructor de la clase vacio, inicia variables en cero
     */
    public ETerm(){
        Degree = 0;
        Sign = 0;
        Cons = 0;
    }

    /**
     * Constructor de la clase con String, determina valores y asigna atributos 
     * @param term termino a generar
     */
    public ETerm(String term){

        Validate V = new Validate();

        Degree = 1;
        Sign = 1;
        Cons = 1;

        if (term.contains("^")){
            String temp[] = term.split("\\^");
            Degree = Double.parseDouble(temp[1]);
        }
        else {
            Degree = 0;
        }

        if (term.contains("x")) {
            hasX = true;
            if(term.contains("^0")){
                hasX = false;
            }
        }
        else {
            hasX = false;
            Degree = 0;
        }

        if (term.contains("x") && !term.contains("^")) {
            hasX = true;
            Degree = 1;
        }

        Pattern P = Pattern.compile("^"+V.Number_Regex);
        Matcher M = P.matcher(term);
        if(M.find()){;
            Cons = Double.parseDouble(M.group());
            if(Cons>0){
                Sign = 1;
            }
            else {
                if(Cons<0){
                    Sign = -1;
                    Cons = Cons * -1;
                }
                else {
                    Cons = 0;
                }
            }
        }

        if(term.contains("-x")){
            Cons = 1;
            Sign = -1;
        }

    }

    /**
     * Método para comparar objetos Eterm
     * @param pterm Eterm a comparar
     * @return verdadero - son iguales, falso - no son iguales
     */
    public boolean equals(ETerm pterm){
        if(hasX == pterm.hasX && Degree == pterm.Degree)
            return true;
	    else
            return false;
    }

}

