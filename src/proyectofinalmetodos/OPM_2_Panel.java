/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalmetodos;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Morales
 */
public class OPM_2_Panel extends javax.swing.JPanel {

    Validate V = new Validate();
    Mensaje M = new Mensaje();
    private final int TABLE_HEIGHT = 271;
    
    
    public OPM_2_Panel(JButton backButton, int x_button, int y_button, JLabel Titulo) {
        initComponents();
        int titulo_x = 586;
        int titulo_y = 80;
        this.add(backButton);
        backButton.setBounds(x_button, y_button, 50, 50);
        this.add(Titulo); 
        Titulo.setBounds(200, Math.abs(y_button - (titulo_y/2)), titulo_x, titulo_y);
        this.validate();
        
        //Inicializar componentes
        OPM_2_A_Rows.setEditor(new JSpinner.DefaultEditor(OPM_2_A_Rows));
        OPM_2_A_Columns.setEditor(new JSpinner.DefaultEditor(OPM_2_A_Columns));
        OPM_2_B_Rows.setEditor(new JSpinner.DefaultEditor(OPM_2_B_Rows));
        OPM_2_B_Columns.setEditor(new JSpinner.DefaultEditor(OPM_2_B_Columns));
        
        OPM_2_Matrix_A.setTableHeader(null);
        OPM_2_Matrix_B.setTableHeader(null);
        OPM_2_Matrix_Output.setTableHeader(null);
        
        changeTable(OPM_2_Matrix_A, (int)OPM_2_A_Rows.getValue(), (int)OPM_2_A_Columns.getValue());
        changeTable(OPM_2_Matrix_B, (int)OPM_2_B_Rows.getValue(), (int)OPM_2_B_Columns.getValue());
        changeTable(OPM_2_Matrix_Output, 1, 1);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        OPM_2_Sections = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OPM_2_Matrix_A = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        OPM_2_A_Rows = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        OPM_2_A_Columns = new javax.swing.JSpinner();
        OPM_2_nA_Input = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OPM_2_Matrix_B = new javax.swing.JTable();
        OPM_2_nB_Input = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OPM_2_B_Rows = new javax.swing.JSpinner();
        OPM_2_B_Columns = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        OPM_2_OperationBox = new javax.swing.JComboBox();
        OPM_2_CalculateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OPM_2_Matrix_Output = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 219, 255), 4));
        setEnabled(false);

        OPM_2_Matrix_A.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        OPM_2_Matrix_A.setToolTipText("");
        OPM_2_Matrix_A.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        OPM_2_Matrix_A.setGridColor(new java.awt.Color(204, 204, 204));
        OPM_2_Matrix_A.setRowSelectionAllowed(false);
        OPM_2_Matrix_A.setShowGrid(true);
        OPM_2_Matrix_A.getTableHeader().setResizingAllowed(false);
        OPM_2_Matrix_A.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(OPM_2_Matrix_A);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(185, 219, 255));
        jLabel4.setText("n");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(185, 219, 255));
        jLabel1.setText("A");

        OPM_2_A_Rows.setModel(new javax.swing.SpinnerNumberModel(2, 1, 5, 1));
        OPM_2_A_Rows.setToolTipText("Cantidad de renglones de A");
        OPM_2_A_Rows.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OPM_2_A_RowsStateChanged(evt);
            }
        });

        jLabel5.setText("x");

        OPM_2_A_Columns.setModel(new javax.swing.SpinnerNumberModel(2, 1, 5, 1));
        OPM_2_A_Columns.setToolTipText("Cantidad de columnas de A");
        OPM_2_A_Columns.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OPM_2_A_ColumnsStateChanged(evt);
            }
        });

        OPM_2_nA_Input.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        OPM_2_nA_Input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        OPM_2_nA_Input.setToolTipText("Valor numérico de n para A");

        OPM_2_Matrix_B.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        OPM_2_Matrix_B.setToolTipText("");
        OPM_2_Matrix_B.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        OPM_2_Matrix_B.setGridColor(new java.awt.Color(204, 204, 204));
        OPM_2_Matrix_B.setRowSelectionAllowed(false);
        OPM_2_Matrix_B.setShowGrid(true);
        OPM_2_Matrix_B.getTableHeader().setResizingAllowed(false);
        OPM_2_Matrix_B.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(OPM_2_Matrix_B);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OPM_2_nB_Input.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        OPM_2_nB_Input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        OPM_2_nB_Input.setToolTipText("Valor numérico de n para B");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(185, 219, 255));
        jLabel6.setText("n");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(185, 219, 255));
        jLabel2.setText("B");

        OPM_2_B_Rows.setModel(new javax.swing.SpinnerNumberModel(2, 1, 5, 1));
        OPM_2_B_Rows.setToolTipText("Cantidad de renglones de B");
        OPM_2_B_Rows.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OPM_2_B_RowsStateChanged(evt);
            }
        });

        OPM_2_B_Columns.setModel(new javax.swing.SpinnerNumberModel(2, 1, 5, 1));
        OPM_2_B_Columns.setToolTipText("Cantidad de columnas de B");
        OPM_2_B_Columns.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OPM_2_B_ColumnsStateChanged(evt);
            }
        });

        jLabel7.setText("x");

        OPM_2_OperationBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "+", "*" }));
        OPM_2_OperationBox.setToolTipText("Operación a realizar");

        OPM_2_CalculateButton.setText("Calcular");
        OPM_2_CalculateButton.setToolTipText("Realizar operación escogida");
        OPM_2_CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPM_2_CalculateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(OPM_2_nA_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OPM_2_A_Rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OPM_2_A_Columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(OPM_2_nB_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGap(21, 21, 21)))
                    .addComponent(OPM_2_OperationBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OPM_2_CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OPM_2_B_Rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OPM_2_B_Columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OPM_2_nA_Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(OPM_2_B_Rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OPM_2_B_Columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(OPM_2_OperationBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(OPM_2_A_Rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(OPM_2_A_Columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(OPM_2_CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OPM_2_nB_Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))))
        );

        OPM_2_Sections.addTab("Operación", jPanel3);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Resultado");

        OPM_2_Matrix_Output.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        OPM_2_Matrix_Output.setToolTipText("Matriz resultante de operación");
        OPM_2_Matrix_Output.setGridColor(new java.awt.Color(204, 204, 204));
        OPM_2_Matrix_Output.setRowSelectionAllowed(false);
        OPM_2_Matrix_Output.setShowGrid(true);
        OPM_2_Matrix_Output.getTableHeader().setResizingAllowed(false);
        OPM_2_Matrix_Output.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(OPM_2_Matrix_Output);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        OPM_2_Sections.addTab("Resultado", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OPM_2_Sections)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OPM_2_Sections)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OPM_2_A_RowsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OPM_2_A_RowsStateChanged
        changeTable(OPM_2_Matrix_A, (int)OPM_2_A_Rows.getValue(), (int)OPM_2_A_Columns.getValue());
    }//GEN-LAST:event_OPM_2_A_RowsStateChanged

    private void OPM_2_A_ColumnsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OPM_2_A_ColumnsStateChanged
        changeTable(OPM_2_Matrix_A, (int)OPM_2_A_Rows.getValue(), (int)OPM_2_A_Columns.getValue());
    }//GEN-LAST:event_OPM_2_A_ColumnsStateChanged

    private void OPM_2_B_RowsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OPM_2_B_RowsStateChanged
        changeTable(OPM_2_Matrix_B, (int)OPM_2_B_Rows.getValue(), (int)OPM_2_B_Columns.getValue());
    }//GEN-LAST:event_OPM_2_B_RowsStateChanged

    private void OPM_2_B_ColumnsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OPM_2_B_ColumnsStateChanged
        changeTable(OPM_2_Matrix_B, (int)OPM_2_B_Rows.getValue(), (int)OPM_2_B_Columns.getValue());
    }//GEN-LAST:event_OPM_2_B_ColumnsStateChanged

    private void OPM_2_CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPM_2_CalculateButtonActionPerformed
        try{
        String op = (String) OPM_2_OperationBox.getModel().getSelectedItem();
        int A_rows = (int) OPM_2_A_Rows.getValue();
        int A_columns = (int) OPM_2_A_Columns.getValue();
        int B_rows = (int) OPM_2_B_Rows.getValue();
        int B_columns = (int) OPM_2_B_Columns.getValue();
        if(V.isNumberValid(OPM_2_nA_Input.getText())){
            if(!V.isNumberValid(OPM_2_nB_Input.getText())){
                M.mostarError("n de B no es válido.");
                return;
            }
           double nA = Double.parseDouble(OPM_2_nA_Input.getText());
           double nB = Double.parseDouble(OPM_2_nB_Input.getText());
           String A_values[][] = getMatrixValues(OPM_2_Matrix_A, OPM_2_A_Rows, OPM_2_A_Columns);
           String B_values[][] = getMatrixValues(OPM_2_Matrix_B, OPM_2_B_Rows, OPM_2_B_Columns);
           if(!V.isMatrixValid(A_values)){
               M.mostarError("Los valores de A no son válidos.");
               return;
           }
           if(!V.isMatrixValid(B_values)){
               M.mostarError("Los valores de B no son válidos.");
               return;
           }
           
           if(op.equals("*")){
                if("*".equals(op)&&A_columns!=B_rows){
                    M.mostarError("Las columnas de A y los renglones de B deben ser el mismo número.");
                    return;
                } 
                Matrix A_mult = new Matrix(A_values).timesScalar(nA);
                Matrix B_mult = new Matrix(B_values).timesScalar(nB);
                Matrix result_mult = A_mult.productWith(B_mult);
                changeTable(OPM_2_Matrix_Output, result_mult.Rows, result_mult.Columns);
                setResult(result_mult.Values);
                OPM_2_Sections.setSelectedIndex(1);
                return;
            }
            else{
                if((op.equals("-")||op.equals("+"))&&(A_rows==B_rows)&&(A_columns==B_columns)){
                    Matrix A_sum = new Matrix(A_values);
                    Matrix B_sum = new Matrix(B_values);
                    Matrix result_sum = A_sum.operationWith(nA, (op.equals("-")?-1:1), nB, B_sum);
                    changeTable(OPM_2_Matrix_Output, result_sum.Rows, result_sum.Columns);
                    setResult(result_sum.Values);
                    OPM_2_Sections.setSelectedIndex(1);
                    return;
                }
                else{
                    M.mostarError("En suma o resta el orden debe ser el mismo.");
                }
            } 
        }
       else{
           M.mostarError("n de A no es válido.");
        }    
        }
        catch(Exception e){
            M.mostarError("ERROR FATAL: "+e.toString()+"\nCERRANDO PROGRAMA.");
            System.exit(0);
        }
    }//GEN-LAST:event_OPM_2_CalculateButtonActionPerformed

    private void changeTable(JTable table, int rows, int columns){        
        DefaultTableModel temp = new DefaultTableModel();
        temp.setColumnCount(columns);
        temp.setRowCount(rows);
        table.setModel(temp);
        table.setRowHeight(TABLE_HEIGHT/rows);
        Font table_font = table.getFont();
        Font new_font = new Font(table_font.getName(), table_font.getStyle(), (int) ((TABLE_HEIGHT/(int)OPM_2_A_Rows.getValue()) * 0.33));
        table.setFont(new_font);      
    }
    
    private String[][] getMatrixValues(JTable matrix, JSpinner rows, JSpinner columns){
        String Values[][] = new String[(int) rows.getValue()][(int) columns.getValue()];
        for(int i = 0; i<(int) rows.getValue(); i++){
            for(int j = 0; j<(int) columns.getValue(); j++){
                String n = (String)matrix.getModel().getValueAt(i, j);
                Values[i][j] = (n==null? "" : n);
            }           
        }
        return Values;
    }
    
    private void setResult(double values[][]){
        for(int i = 0; i<(int) values.length; i++){
            for(int j = 0; j<(int) values[i].length; j++){
                OPM_2_Matrix_Output.getModel().setValueAt(values[i][j], i, j);
            }           
        }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner OPM_2_A_Columns;
    private javax.swing.JSpinner OPM_2_A_Rows;
    private javax.swing.JSpinner OPM_2_B_Columns;
    private javax.swing.JSpinner OPM_2_B_Rows;
    private javax.swing.JButton OPM_2_CalculateButton;
    private javax.swing.JTable OPM_2_Matrix_A;
    private javax.swing.JTable OPM_2_Matrix_B;
    private javax.swing.JTable OPM_2_Matrix_Output;
    private javax.swing.JComboBox OPM_2_OperationBox;
    private javax.swing.JTabbedPane OPM_2_Sections;
    private javax.swing.JTextField OPM_2_nA_Input;
    private javax.swing.JTextField OPM_2_nB_Input;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
