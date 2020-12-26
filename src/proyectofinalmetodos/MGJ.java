package proyectofinalmetodos;
import java.util.ArrayList;

/**
 * MGJ
 * Clase que contiene los procedimientos necesarios para resolver el método de Gauss-Jordan
 * Fecha de creación: 31/10/16
 * Fecha de última modificación: 8/11/16 
 * Autor original: Josué Morales
 * Autor de última modificación: Josué Morales, 
 * Descripción de última modificación:
 * "El método Conclusion() se llamaba antes de ser necesitado, por lo que se cambió al lugar
 * donde está actualmente" 
 * Clases que lo llaman: Matriz, MGJ_Panel
 * Clases que llama: Matriz
 */

public class MGJ {

    //Atributos de la clase
    public Matrix M;
    public boolean isInverse;

    //donde la matríz está aumentada con los resultados
    /**
     * Constructor de la clase, asigna parámetros
     * @param m Matriz a evaluar
     * @param isinverse si se está realizando la inversa de una matriz
     */
    public MGJ(Matrix m, boolean isinverse){
        M = m;
        isInverse = isinverse;
    }

    //boolean, double[], posicion row
    /**
     * Método que busca un 1 en la columna escogida
     * @param position_pivot posicion en la que se encuentra el pivote de 1s
     * @param act_row renglón actual
     * @param act_column columna actual
     * @return Arraylist con boolean (verdadero - se encontró, falso - no se encontró), double[] (renglón con 1 en la misma columna qu el pivote), int (posición del renglón con 1 en la matriz)  
     */
    private ArrayList lookForOne(int position_pivot, int act_row, int act_column){
        int row_pos = 0;
        ArrayList results = new ArrayList();
        double row_with_npivot[] = new double[M.Columns];
        boolean found_it = false;
        for(int i = act_row; i<M.Rows; i++){
            for(int j = act_column; j<M.Columns; j++){
                if(j==position_pivot && M.Values[i][j] == 1){
                    row_with_npivot = M.Values[i];
                    row_pos = i;
                    found_it = true;
                }
            }
        }
        results.add(found_it);
        results.add(row_with_npivot);
        results.add(row_pos);
        return results;
    }

    //boolean, double[], posicion row
    /**
     * Método que busca un número mayor a 1 en la columna escogida
     * @param position_pivot posicion en la que se encuentra el pivote de 1s
     * @param act_row renglón actual
     * @param act_column columna actual
     * @return Arraylist con boolean (verdadero - se encontró, falso - no se encontró), double[] (renglón con número en la misma columna qu el pivote), int (posición del renglón con número en la matriz)  
     */
    private ArrayList lookForN(int position_pivot, int act_row, int act_column){
        int row_pos = 0;
        ArrayList results = new ArrayList();
        double row_with_npivot[] = new double[M.Columns];
        boolean found_it = false;
        for(int i = act_row; i<M.Rows; i++){
            for(int j = act_column; j<M.Columns; j++){
                if(j==position_pivot && M.Values[i][j] != 1 && M.Values[i][j] != 0){
                    row_with_npivot = M.Values[i];
                    row_pos = i;
                    found_it = true;
                }
            }
        }
        results.add(found_it);
        results.add(row_with_npivot);
        results.add(row_pos);
        return results;
    }

    /**
     * Mñetodo que checa si todos los elementos de un array son 0s
     * @param zeros array
     * @return verdadero - todos son ceros, falso - hay almenos un elemento que no es cero
     */
    private boolean allZeros(boolean zeros[]){
        boolean res = true;
        for (boolean zero: zeros) {
            if(!zero){
                res = false;
            }
        }
        return res;
    }

    //bool-incconsistente, bool - sol_multi, String, int renglon 0s, int column donde debe ir el 1
    /**
     * Método que determina si el resultado es un sistema inconsistente o si tiene soluciones múltiples
     * @return ArrayList con boolean (verdadero - es inconsistente, falso - es consistente), boolean (verdadero - tiene soluciones múltiples, falso - no tiene soluciones múltiples), String (Mensaje para desplegar en interfaz), int (posicion del renglón de 0), int (columna donde debe ir un 1 si hay un renglón con ceros)
     */
    private ArrayList Conclusion(){
        ArrayList results = new ArrayList();
        String conclusion = "";
        boolean inconsistente = false;
        boolean sol_multi = false;
        int row_pos = 0;
        int column_pos = 0;
        System.out.println("Matriz entrante a conclusion = ");
        M.print();
        System.out.println("------------------");
        Matrix Ones = M.getSubMatrixFrom(0, M.Rows-1, 0, M.Columns-2);
        Matrix b = M.getSubMatrixFrom(0, M.Rows-1, M.Columns-1, M.Columns-1);
        int pivot = 0;
        for(int i = 0; i<Ones.Rows; i++){
            boolean ceros[] = new boolean[Ones.Columns];
            for(int j = 0; j<Ones.Columns; j++){
                ceros[j] = false;
                if(Ones.Values[i][j]==0){
                    ceros[j] = true;
                }
            }
            if(allZeros(ceros) && b.Values[i][0] == 0){
                row_pos = i;
                column_pos = pivot;
                sol_multi = true;
                conclusion =  "El sistema de ecuasiones tiene soluciones múltples.\nFavor de agregar un valor:";
                break;
            }
            if(allZeros(ceros) && b.Values[i][0] != 0){
                inconsistente = true;
                conclusion = "El sistema de ecuasiones es inconsistente.";
                break;
            }
            pivot++;
        }

        results.add(inconsistente);
        results.add(sol_multi);
        results.add(conclusion);
        results.add(row_pos);
        results.add(column_pos);

        return results;
    }

    /**
     * Método que inicia el proceso para calcular el método
     * @return Matriz resultante de operación
     */
    public Matrix execute(){
        double pivot_cons = 0;
        int pivot = 0;
        for(int i = 0; i<M.Rows; i++){
            for(int j = 0; j<M.Columns; j++){
                if (j==(M.Columns-1)) {
                    break;
                }
                if(isInverse&&j>=(M.Columns/2)&&j<=(M.Columns-1)){
                    break;
                }
                if(j==pivot){
                    if(M.Values[i][j]==0){
                        ArrayList look_for_1 = lookForOne(pivot, i, j);
                        double row_to_move[] = M.Values[i];
                        if((boolean) look_for_1.get(0)){
                            M.Values[i] = (double[]) look_for_1.get(1);
                            M.Values[(int) look_for_1.get(2)] = row_to_move;
                            MGJ mgj = new MGJ(M, isInverse);
                            return mgj.execute();
                        }
                        else{
                            //busca otro candidato para ser pivote que no sea 1 ni 0
                            ArrayList look_for_n = lookForN(pivot, i, j);
                            if((boolean) look_for_n.get(0)){
                                M.Values[i] = (double[]) look_for_n.get(1);
                                M.Values[(int) look_for_n.get(2)] = row_to_move;
                                MGJ mgj = new MGJ(M, isInverse);
                                return mgj.execute();
                            }
                            else{
                                i--;
                                break;
                            }
                        }
                    }
                    else{
                        if(M.Values[i][j]==1){
                            pivot_cons = 1;
                        }
                        else{
                            pivot_cons = M.Values[i][j];
                        }
                    }
                    double row[] = M.getRowAt(i);
                    for(int x= 0; x<row.length; x++){
                        row[x] = row[x]/pivot_cons;
                    }
                    M.setRowAt(i, row);
                    for(int y = 0; y<M.Rows; y++){
                        double multiplier = M.Values[y][pivot]*-1;
                        for(int z = 0; z<M.Columns; z++){
                            if(!row.equals(M.Values[y])){
                                M.Values[y][z] = (multiplier*row[z]) + M.Values[y][z];
                            }
                        }
                    }
                }
            }
            pivot++;
        }
        return M;
    }

    //bool-incconsistente, bool - sol_multi, String, int renglon 0s, int column donde debe ir el 1, matriz resultado
    /**
     * Método que llama a hacer el procedimiento del método al igual que una conclusión del resultado
     * @return ArrayList con boolean (verdadero - es inconsistente, falso - es consistente), boolean (verdadero - tiene soluciones múltiples, falso - no tiene soluciones múltiples), String (Mensaje para desplegar en interfaz), int (posicion del renglón de 0), int (columna donde debe ir un 1 si hay un renglón con ceros), Marix (matriz resultante de operación)
     */
    public ArrayList start(){
        Matrix matrix_result = execute();
        ArrayList results = Conclusion();
        results.add(matrix_result);
        return results;
    }

    /**
     * Método para poner un valor nuevo en el lugar escogido (en caso de que se hayan detectado sol. múltiples)
     * @param row_1 renglón a poner el valor
     * @param column_1 columna a poner el valor
     * @param value valor
     * @return Matrix con procedimiento hecho de nuevo
     */
    public Matrix setValueToResult(int row_1, int column_1, double value){
        M.setValueAt(row_1, column_1, 1);
        M.setValueAt(row_1, M.Columns-1, value);
        return execute();
    }

}
