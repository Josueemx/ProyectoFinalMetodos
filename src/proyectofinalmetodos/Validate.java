package proyectofinalmetodos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate
 * Clase que valida entradas al programa y obtiene factoriales
 * Fecha de creación: 29/10/16
 * Fecha de última modificación: 3/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales
 * Descripción de última modificación:
 * "El método isEquationValid(String equation) no verificaba bien la ecuación, por lo que se le agregaron unos ifs para checar."
 * Clases que lo llaman: MCMPR, MTH_Panel, MNR_Panel, MNM_Panel, MCMPR_Panel, OPM_1_Panel, OPM_2_Panel, MGJ_Panel, MNM_Panel
 * Clases que llama: Ninguna
 */

public class Validate {

    //Atributos de la clase
    public final String numberTerm_Regex = "(\\+|\\-)?(\\d+(\\.\\d+)?)";
    public final String xTerm_Regex = "(\\+|\\-)?(\\d+(\\.\\d+)?)?[x]([\\^]\\d+)?";
    public final String Term_Regex = "(\\+|\\-)?(\\d+(\\.\\d+)?)?[x]?([\\^]\\d+)?";
    public final String Equation_Regex = "((\\+|\\-)?(\\d+(\\.\\d+)?)?[x]?([\\^]\\d+)?)*";
    public final String Number_Regex = "([(\\+|\\-)])?\\d+(\\.\\d+)?";
    public final String InvalidInput1_Regex = "\\^\\d+(\\.\\d+)?[x]";
    public final String InvalidInput2_Regex = "([(\\+|\\-)])?\\d+(\\.\\d+)?[\\^]([(\\+|\\-)])?\\d+(\\.\\d+)?";
    public final String InvalidInput3_Regex = "(\\-{2,}|\\+{2,})";
    public final String InvalidInput4_Regex = "[x]\\d+";
    
    /**
     * Metodo que verifica si la ecuación introducida es valiada.
     * @param equation ecuación a probar
     * @return true - ecuación valida, false - ecuasion invalida
     */
    //0 - valid, 1 - message, 2 - terms
    public ArrayList isEquationValid(String equation){
        boolean valid;
        String message = "";
        List<String> Terms = new ArrayList<String>();
        ArrayList Res = new ArrayList();

        Pattern P1 = Pattern.compile(Equation_Regex);
        Matcher M1 = P1.matcher(equation);


        if(M1.matches() && !(Pattern.compile(InvalidInput3_Regex).matcher(equation).find()) && !equation.equals("-") && !equation.equals("+")){
            Pattern P2 = Pattern.compile(Term_Regex);
            Matcher M2 = P2.matcher(equation);
            Pattern P3 = Pattern.compile(Number_Regex+"\\^"+Number_Regex);
            while (M2.find()) {
                String term_s = M2.group();
                if(!Pattern.compile(Term_Regex).matcher(term_s).matches()){
                    message = "La ecuación no es correcta.";
                    valid = false;
                    System.out.println("atrapado: "+term_s);
                    break;
                }
                if(term_s != ""){
                    Terms.add(term_s);
                }
                Matcher M3 = P3.matcher(term_s);
                if(M3.matches()){
                    valid = false;
                    message = "El término '"+term_s +"' no es válido.";
                    break;
                }

            }


            if(Objects.equals(equation, "")){
                message = "La ecuación no puede estar vacia.";
                valid = false;
            }
            else
            {
                valid = true;
            }

            if(Terms.size()>0){
                Terms.remove((Terms.size()-1));
            }
            for (String t: Terms){
                if(!Pattern.compile(numberTerm_Regex).matcher(t).matches() && !Pattern.compile(xTerm_Regex).matcher(t).matches()) {
                    valid = false;
                    message = "La ecuación no es correcta.";

                }
            }
        }
        else{
            valid = false;
            message = "La ecuación no es correcta.";
        }

        Matcher M5 =Pattern.compile(InvalidInput1_Regex).matcher(equation);
        if(M5.find()){
            message = "Creo que a tu ecuasión le falta un signo entre el número y "+M5.group();
            valid = false;
        }

        Matcher M4 = Pattern.compile(InvalidInput2_Regex).matcher(equation);
        if(M4.find()){
            message = "Los números con potencia no son válidos: "+M4.group();
            valid = false;
        }

        if(Pattern.compile(InvalidInput4_Regex).matcher(equation).find()){
            message = "La ecuación no es correcta.";
            valid = false;
        }

        Res.add(valid);
        Res.add(message);
        Res.add(Terms);
        return Res;
    }
    
    /**
     * Método que verifica si un String se puede convertir a número.
     * @param number String a checar
     * @return true - la String es un número, false - la String no es un número
     */
    public boolean isNumberValid(String number){
        Pattern P = Pattern.compile(Number_Regex);
        Matcher M = P.matcher(number);
        if(M.matches())
            return true;
        else
            return false;
    }

    /**
     * Método que obtiene el factorial del número introducido
     * @param num inicio
     * @return double (resultado)
     */
    public double factorial(double num){
        double fact = 1;
        for (double i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }


    //boolean, values, message
    /**
     * Método que checa si los valores de una matriz son válidos
     * @param values valores a checar
     * @return boolean (verdadero - matriz es válida, falso - matriz inválida)
     */
    public boolean isMatrixValid(String values[][]){
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[i].length; j++){
                if(!isNumberValid(values[i][j]))
                    return false;
            }
        }
        return true;
    }
}
