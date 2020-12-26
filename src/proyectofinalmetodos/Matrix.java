package proyectofinalmetodos;

/**
 * Matrix
 * Clase para manejar matrices y operaciones con estas
 * Fecha de creación: 30/10/16
 * Fecha de última modificación: 3/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales
 * Descripción de última modificación:
 * "El se agrego el método operationWith(double a_n, double b_sign, double b_n, Matrix B) para hacer operaciones con dos matrices"
 * Clases que lo llaman: OPM_1_Panel, OPM_2_Panel, MNM, MGJ, MRPMC, MNM_Panel, MGJ_Panel, MRPMC_Panel 
 * Clases que llama: MGJ
 */

public class Matrix {

    //Atributos
    public int Rows;
    public int Columns;
    public double Values[][];
    public boolean isCuadratic;

    /**
     * Constructor con integers, calcula los demás atributos
     * @param rows cantidad de renglones
     * @param columns cantidad de columnas
     */
    public Matrix(int rows, int columns){
        Rows = rows;
        Columns = columns;
        Values = new double[rows][columns];
        if(rows == columns){
            isCuadratic = true;
        }
        else{
            isCuadratic = false;
        }
    }

    /**
     * Constructor con double[][], calcula los demás atributos
     * @param values valores de la matriz
     */
    public Matrix(double values[][]){
        Values = values;
        Rows = values.length;
        Columns = values[0].length;
        if(Rows==Columns){
            isCuadratic = true;
        }
        else {
            isCuadratic = false;
        }
    }

    /**
     * Constructor con String[][], calcula los demás atributos
     * @param values valores de la matriz
     */
    public Matrix(String values[][]){
        Rows = values.length;
        Columns = values[0].length;
        Values = new double[Rows][Columns];
        for(int i = 0; i < Rows; i++){
            for(int j = 0; j < Columns; j++){
                Values[i][j] = Double.parseDouble(values[i][j]);
            }
        }
        if(Rows == Columns){
            isCuadratic = true;
        }
        else{
            isCuadratic = false;
        }
    }

    /**
     * Constructor vacio
     */
    public Matrix(){}

    /**
     * Método para multiplicar una matriz por un valor
     * @param scalar valor a mutiplicar
     * @return Matrix (resultado)
     */
    public Matrix timesScalar(double scalar){
        double new_values[][] = new double[Rows][Columns];
        for(int i = 0; i<Rows; i++){
            for(int j = 0; j<Columns; j++){
                new_values[i][j] = (Values[i][j] * scalar);
            }
        }
        Matrix new_matrix = new Matrix();
        new_matrix.Rows = Rows;
        new_matrix.Columns = Columns;
        new_matrix.Values = new_values;
        new_matrix.isCuadratic = isCuadratic;
        return new_matrix;
    }

    /**
     * Método para transponer una matriz
     * @return Matrix (Matriz transpuesta)
     */
    public Matrix transpose() {
        Matrix new_matrix = new Matrix(Columns, Rows);
        for (int i = 0; i < Rows; i++)
            for (int j = 0; j < Columns; j++)
                new_matrix.Values[j][i] = Values[i][j];
        return new_matrix;
    }

    //El número de rows de ambas matrices debe ser el mismo
    /**
     * Método para aumentar dos matrices (a la derecha)
     * @param B Matriz a aumentar a la derecha
     * @return Matrix (Matriz aumentada)
     */
    public Matrix augmentWith(Matrix B){
        Matrix new_matrix = new Matrix(Rows, Columns + B.Columns);
        for(int i=0; i<Rows; i++){
            for(int j=0; j<new_matrix.Columns; j++){
                if(j>=Columns){
                    new_matrix.Values[i][j] = B.Values[i][j-Columns];
                }
                else {
                    new_matrix.Values[i][j] = Values[i][j];
                }
            }
        }
        return new_matrix;
    }

    /**
     * Método para obtener un valor en el lugar especificado
     * @param row posicion de renglón
     * @param column posición de columna
     * @return double (valor)
     */
    public double getValueAt(int row, int column){
        return Values[row][column];
    }

    /**
     * Método para poner valor en el lugar indicado
     * @param row posicion de renglón
     * @param column posición de columna
     * @param value valor a poner
     */
    public void setValueAt(int row, int column, double value){
        Values[row][column] = value;
    }

    /**
     * Método para obtener el rengón especificado
     * @param row posicion de renglón
     * @return double[] (renglón)
     */
    public double[] getRowAt(int row){
        return Values[row];
    }
    
    /**
     * Método para poner renglón en el lugar especificado
     * @param row posicion de renglón
     * @param values renglón a poner
     */
    public void setRowAt(int row, double values[]){
        Values[row] = values;
    }

    /**
     * Método para imprimir una matriz
     */
    public void print() {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++)
                System.out.print(Values[i][j]+" ");
            System.out.println();
        }
    }
    
    /**
     * Método para volver una matriz String
     * @return String (matriz)
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++)
                res = res + Values[i][j]+"\t\t";
            res = res + "\n";
        }
        return res;
    }

    /**
     * Método para rellenar de valores la matriz (empezando con 3)
     */
    public void fillUp() {
        double count = 3;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                Values[i][j] = count;
                count++;
            }
        }
    }

    /**
     * Método que calcula la identidad de la matriz (en caso de ser cuadrada)
     * @return Matrix (matriz identidad)
     */
    public Matrix getIdentity(){
        if(isCuadratic){
            int count = 0;
            double new_values[][] = new double[Rows][Columns];
            for(int i = 0; i<Values.length; i++){
                for(int j = 0; j<Values.length; j++){
                    if(j==count){
                        new_values[i][j] = 1;
                    }
                    else {
                        new_values[i][j] = 0;
                    }
                }
                count++;
            }
            Matrix new_matrix = new Matrix();
            new_matrix.Values = new_values;
            new_matrix.Columns = Columns;
            new_matrix.Rows = Rows;
            new_matrix.isCuadratic = isCuadratic;
            return new_matrix;
        }
        else {
            return null;
        }
    }

    /**
     * Método para eliminar una columna de la matriz
     * @param column posición de columna a eliminar
     */
    public void removeColumn(int column) {
        double new_values[][]  = new double[Rows][Columns-1];
        for(int i=0; i<Rows; i++){
            for(int j=0; j<Rows; j++){
                if(j!=column){
                    new_values[i][j-1] = Values[i][j];
                }
            }
        }
        Values = new_values;
    }

    /**
     * Método que calcula la inversa de la matríz mediante el método de Gauss-Jordan
     * @return Matriz (Matriz inversa)
     */
    public Matrix inverse(){
        MGJ mgj = new MGJ(augmentWith(getIdentity()), true);
        Matrix res_mgj = mgj.execute();
        Matrix res = res_mgj.getSubMatrixFrom(0, res_mgj.Rows-1, res_mgj.Columns/2, res_mgj.Columns-1);
        return res;
    }

    /** 
     * Método que llama a calcular el determinante de la matriz
     * @return double (determinante de la matriz)
     */
    public double getDet(){
        return det(Values);
    }

    /**
     * Método que calcula el determinante de una matriz
     * @param values valores a usar
     * @return determinante
     */
    private double det(double[][] values) {
        if (values.length == 1) {
            return values[0][0];
        }
        if (values.length==2) {
            return values[0][0] * values[1][1] -  values[0][1] * values[1][0];
        }
        double suma = 0.0;
        for (int i=0; i<values[0].length; i++) {
            suma += getSign(i) * values[0][i] * det(getSubValues(values, 0, i));
        }
        return suma;
    }

    /**
     * Método que determina el signo a usar
     * @param num valor a evaluar
     * @return int (signo numérico)
     */
    private int getSign(int num){
        if ((num % 2) == 0){
            return 1;
        }
        else{
            return -1;
        }
    }

    /**
     * Método para obtener los sub-valores a partir de una columna y un renglón
     * @param values valores a usar
     * @param row posición de renglón
     * @param column posición de columna
     * @return double[][] (valores resultantes)
     */
    private double[][] getSubValues(double[][] values, int row, int column) {
        int sign = -1;
        double new_values[][]= new double[values.length-1][values[0].length-1];
        for (int i=0;i<values.length;i++) {
            if (i==row){
                continue;
            }
            sign++;
            int a = -1;
            for (int j=0;j<values[0].length;j++) {
                if (j==column){
                    continue;
                }
                new_values[sign][++a]=values[i][j];
            }
        }
        return new_values;
    }
    
    /**
     * Método para obtener la sub-matriz de una matriz entre dos renglones y dos columnas
     * @param from_row renglón de inicio
     * @param to_row renglón fin
     * @param from_column columna de inicio
     * @param to_column columna fin
     * @return Matrix (matriz resultante)
     */
    public Matrix getSubMatrixFrom(int from_row, int to_row, int from_column, int to_column){
        double new_values[][] = new double[to_row-from_row+1][to_column-from_column+1];
        for(int i = 0; i<Rows; i++){
            for(int j = 0; j<Columns; j++){
                if(i >= from_row && i <= to_row && j >= from_column && j <= to_column){
                    new_values[i-from_row][j-from_column] = Values[i][j];
                }
            }
        }
        Matrix new_matrix = new Matrix();
        new_matrix.Rows = new_values.length;
        new_matrix.Columns = new_values[0].length;
        new_matrix.Values = new_values;
        if(new_matrix.Rows == new_matrix.Columns){
            new_matrix.isCuadratic = true;
        }
        else {
            new_matrix.isCuadratic = false;
        }
        return new_matrix;
    }

    //número de columnas de esta y renglones de B tienen que ser iguales
    /**
     * Método para sacar el producto con otra matriz
     * @param B Matriz a operar
     * @return Matrix (Producto matricial)
     */
    public Matrix productWith(Matrix B){
        double new_values[][] = new double[Rows][B.Columns];

        for (int i = 0; i<new_values.length; i++){
            for (int a = 0; a<new_values[i].length; a++){
                for(int c = 0 ;c < Columns; c++){
                    new_values[i][a] = new_values[i][a] + Values[i][c] * B.Values[c][a];
                }
            }
        }

        Matrix new_matrix = new Matrix();
        new_matrix.Rows = new_values.length;
        new_matrix.Columns = new_values[0].length;
        new_matrix.Values = new_values;
        if(new_matrix.Rows == new_matrix.Columns){
            new_matrix.isCuadratic = true;
        }
        else {
            new_matrix.isCuadratic = false;
        }

        return new_matrix;
    }

    //tienen que ser del mismo orden
    //b_sign solo -1 o 1
    /**
     * Método para obtener una operación (suma p resta) entre dos matrices
     * @param a_n escalar de la matriz actual
     * @param b_sign signo de la matriz b
     * @param b_n escalar de la matriz b
     * @param B Matriz a operar
     * @return Matrix (resultado de operación)
     */
    public Matrix operationWith(double a_n, double b_sign, double b_n, Matrix B) {
        Matrix result = new Matrix(Rows, Columns);
        for (int i = 0; i < Rows; i++)
            for (int j = 0; j < Columns; j++)
                result.Values[i][j] = (a_n*Values[i][j]) + (b_sign * b_n * B.Values[i][j]);
        return result;
    }
}
