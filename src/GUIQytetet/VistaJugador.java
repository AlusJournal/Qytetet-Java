/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;

/**
 *
 * @author Paula
 */
public class VistaJugador extends javax.swing.JPanel {

    /**
     * Creates new form VistaJugador
     */
    public VistaJugador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTextoJugador = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        jtTextoJugador.setColumns(20);
        jtTextoJugador.setRows(5);
        jScrollPane1.setViewportView(jtTextoJugador);

        jLabel1.setText("Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

public void actualizar(String descripcionJugador){
    this.jtTextoJugador.setText(descripcionJugador);
    this.repaint(); //Investiga para qué sirven estos métodos
    this.revalidate();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtTextoJugador;
    // End of variables declaration//GEN-END:variables
}
