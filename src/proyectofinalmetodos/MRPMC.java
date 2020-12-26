package proyectofinalmetodos;
import java.util.ArrayList;
import java.util.List;

/**
 * MRPMC
 * Clase que contiene los procedimientos necesarios para resolver el método de regresión polinomial por mínimos cuadrados
 * Fecha de creación: 4/11/16
 * Fecha de última modificación: 10/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "Había un error cuando se quería encontrar P(x), ej P(x) = x+1*10^15, lo cual era algo muy cercano al cero,
 * por lo que se agregaron varios ifs para corregirlo"
 * Clases que lo llaman: MRPMC_Panel
 * Clases que llama: Matrix, Validate, PolyEquation
 */

public class MRPMC {

    //Atributos
    public Matrix x_Values;
    public Matrix y_Values;
    public double y_media;
    public int Degree;
    public int numTerms;
    public Matrix A;
    public Matrix A_Trans;
    public Matrix A_Inverse;
    public Validate V;
    public Matrix New_b;

    /**
     * Constructor de la clase, asigna y calcula atributos
     * @param xy_values matriz con valores de x y y
     * @param degree Grado de P(x)
     */
    public MRPMC(Matrix xy_values, int degree){
        V = new Validate();
        numTerms = xy_values.Values.length;
        Degree = degree;
        x_Values = xy_values.getSubMatrixFrom(0, (numTerms-1) , 0, 0);
        y_Values = xy_values.getSubMatrixFrom(0, (numTerms-1) , 1, 1);
        A = new Matrix( numTerms, 1);
        //agregar 1s
        for(int i = 0; i<A.Rows; i++){
            for(int j = 0; j<A.Columns; j++){
                A.Values[i][j] = 1;
            }
        }
        A = A.augmentWith(x_Values);
        for(int a = 2; a<=Degree; a++){
            Matrix new_column = new Matrix(A.Rows, 1);
            for(int b = 0; b<A.Rows; b++){
                if(a==2){
                    new_column.Values[b][0] = Math.pow(A.Values[b][1], 2);
                }
                else{
                    Matrix column_temp = A.getSubMatrixFrom(0, A.Rows-1, A.Columns-1, A.Columns-1);
                    new_column.Values[b][0] = x_Values.Values[b][0] * column_temp.Values[b][0];
                }
            }
            A = A.augmentWith(new_column);
        }
        A_Trans = A.transpose();
        New_b = A_Trans.productWith(y_Values);
        A = A_Trans.productWith(A);
        A_Inverse = A.inverse();
        double top = 0;
        for(int y = 0; y<y_Values.Rows; y++){
            top = top + y_Values.Values[y][0];
        }
        y_media = top/numTerms;
    }

    /**
     * Método que inicia el proceso del método de regresión polinomial por mínimos cuadrados
     * @return ArrayList con String (P(x) en función de x), double (valor de r^2)
     */
    public ArrayList start(){
        ArrayList results = new ArrayList();
        Matrix coefficients = A_Inverse.productWith(New_b);
        String equation = "";
        for(int i = Degree; i>=0; i--){
            double coeffficient = coefficients.Values[i][0];
            System.out.println("coeffficient = " + coeffficient);
            coeffficient = (coeffficient<0.000001&&coeffficient>0)||(coeffficient>-0.000001&&coeffficient<0)?0:coeffficient;
            if(coeffficient!=0){
                if(i!=Degree){
                    if(i<=1){
                        boolean all_zerosb = true;
                        for(int c = Degree; c>i; c--){
                            if(!(coefficients.Values[c][0]==0 || coefficients.Values[c][0]<0.000001&&coefficients.Values[c][0]>0||(coeffficient>-0.000001&&coeffficient<0))){
                                all_zerosb = false;
                                break;
                            }
                        }
                        if (all_zerosb) {
                            if(i==1){
                                equation = equation + (coeffficient==1?"":coeffficient) + "x"; 
                            }
                        }
                        else{
                            if(i==1){
                                equation = equation + (coeffficient>0?"+":"") + (coeffficient==1?"":coeffficient)+"x";
                            }
                        }
                        if(i==0){
                            equation = equation + (coeffficient>0?"+":"") + coeffficient;
                        }
                    }
                    else {
                        if(coeffficient>0){
                            equation = equation + "+" + (coeffficient==1?"":coeffficient) + "x^"+i;
                        }
                        else{
                            equation = equation + (coeffficient==1?"":coeffficient) + "x^"+i;
                        }
                    }
                }
                else{
                    equation = equation + (coeffficient==1?"":coeffficient)+ "x^"+i;
                }
            }
        }

        PolyEquation poly_equation = new PolyEquation((List<String>) V.isEquationValid(equation).get(2));

        double y_minus_ym =  0;
        double y_minus_px = 0;
        for(int t = 0; t<numTerms; t++){
            y_minus_ym = y_minus_ym + (Math.pow((y_Values.Values[t][0]-y_media),2));
            double px = poly_equation.getFin(x_Values.Values[t][0]);
            y_minus_px = y_minus_px + (Math.pow((y_Values.Values[t][0]-px),2));
        }

        double r2 = (y_minus_ym-y_minus_px)/y_minus_ym;

        results.add(equation);
        results.add(r2);
        return results;
    }
}
