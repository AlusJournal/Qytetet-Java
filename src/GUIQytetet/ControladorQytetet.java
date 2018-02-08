/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeloqytetet.Casilla;
import modeloqytetet.Jugador;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import modeloqytetet.Sorpresa;

/**
 *
 * @author Shiri
 */
public class ControladorQytetet extends javax.swing.JFrame {
    private static Qytetet modeloQytetet = Qytetet.getInstance();
    
    private Jugador jugadorActual;
    private Sorpresa sorpresaActual;
    private Casilla casillaActual;
    /**
     * Creates new form ControladorQytetet
     */
    public ControladorQytetet() {
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

        vistaQytetet = new GUIQytetet.VistaQytetet();
        jbSalirCarcelDado = new javax.swing.JButton();
        jbSalirCarcelPagando = new javax.swing.JButton();
        jbJugar = new javax.swing.JButton();
        jbComprar = new javax.swing.JButton();
        jbAplicarSorpresa = new javax.swing.JButton();
        jbSiguienteJugador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSalirCarcelDado.setText("Salir Cárcel Dado");
        jbSalirCarcelDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelDadoActionPerformed(evt);
            }
        });

        jbSalirCarcelPagando.setText("Salir Cárcel Pagando");
        jbSalirCarcelPagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelPagandoActionPerformed(evt);
            }
        });

        jbJugar.setText("Jugar");
        jbJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJugarActionPerformed(evt);
            }
        });

        jbComprar.setText("Comprar Propiedad");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbAplicarSorpresa.setText("Aplicar Sorpresa");
        jbAplicarSorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarSorpresaActionPerformed(evt);
            }
        });

        jbSiguienteJugador.setText("Siguiente Jugador");
        jbSiguienteJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jbSalirCarcelDado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbSalirCarcelPagando)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbAplicarSorpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jbSiguienteJugador))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalirCarcelDado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalirCarcelPagando))
                    .addComponent(jbSiguienteJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAplicarSorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAplicarSorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarSorpresaActionPerformed
        boolean resultado = modeloQytetet.aplicarSorpresa(); 
        this.vistaQytetet.actualizar(modeloQytetet); 
    }//GEN-LAST:event_jbAplicarSorpresaActionPerformed

    private void jbJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJugarActionPerformed
        this.jbJugar.setEnabled(false);
        boolean resultado = modeloQytetet.jugar(); 
        
        switch (jugadorActual.getCasillaActual().getTipo()){
            case SORPRESA:
                System.out.println(modeloQytetet.getCartaActual().toString());
                this.jbAplicarSorpresa.setEnabled(true);
                break;
            case CALLE: 
                if(resultado){
                    JOptionPane.showMessageDialog(this,"Has caido en una casilla con propietario");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Has caido en una casilla sin propietario ¿Quieres comprar?");
                    this.jbComprar.setEnabled(true);
                }
                break;
            case JUEZ:
                JOptionPane.showMessageDialog(this,"Has caido en la casilla Juez. Vas a la carcel.");
                break;
            case PARKING:
            case IMPUESTO:
            case SALIDA:
            case CARCEL:
                break;
        }
        this.jbSiguienteJugador.setEnabled(true);
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_jbJugarActionPerformed

    private void jbSalirCarcelDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelDadoActionPerformed
    boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
    this.jbSalirCarcelDado.setEnabled(false);
    this.jbSalirCarcelPagando.setEnabled(false);
    if(resultado){
        JOptionPane.showMessageDialog(this, "Sales de la cárcel");
        this.jbJugar.setEnabled(true);
    }
    else {
        JOptionPane.showMessageDialog(this, "NO sales de la carcel");
        this.jbSiguienteJugador.setEnabled(true);
    }
    this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_jbSalirCarcelDadoActionPerformed

    private void jbSalirCarcelPagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelPagandoActionPerformed
    boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
    this.jbSalirCarcelPagando.setEnabled(false);
    this.jbSalirCarcelDado.setEnabled(false);
    if(resultado){
        JOptionPane.showMessageDialog(this, "Sales de la cárcel");
        this.jbJugar.setEnabled(true);
    }
    else {
        JOptionPane.showMessageDialog(this, "NO sales de la carcel");
        this.jbSiguienteJugador.setEnabled(true);
    }
    this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_jbSalirCarcelPagandoActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        this.jbComprar.setEnabled(false);
        boolean puedoComprar = modeloQytetet.comprarTituloPropiedad();
        if (puedoComprar) {
            JOptionPane.showMessageDialog(this,"Has comprado la casilla " + jugadorActual.getCasillaActual().getNumeroCasilla());
        } else {
            JOptionPane.showMessageDialog(this,"No puedes comprar la casilla " + jugadorActual.getCasillaActual().getNumeroCasilla());
        }
        this.jbSiguienteJugador.setEnabled(true);
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jbSiguienteJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteJugadorActionPerformed
        this.jbSiguienteJugador.setEnabled(false);
        if (jugadorActual.getSaldo() <= 0) {
            // bancarrota
            JOptionPane.showMessageDialog(this, "Ha terminado el juego porque el jugador actual ha caído en bancarrota");
            
            this.jbJugar.setEnabled(false);
        } 
        else {
            jugadorActual = modeloQytetet.siguienteJugador();
            casillaActual = jugadorActual.getCasillaActual();
            
            this.jbJugar.setEnabled(true);
            this.jbComprar.setEnabled(false);
            this.jbAplicarSorpresa.setEnabled(false);
            this.jbSalirCarcelDado.setEnabled(false);
            this.jbSalirCarcelPagando.setEnabled(false);
        }
        
            this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_jbSiguienteJugadorActionPerformed

    public void actualizar(Qytetet descripcionQytetet){
        this.modeloQytetet = descripcionQytetet;
        
        this.jugadorActual = modeloQytetet.getJugadorActual();
        this.sorpresaActual = modeloQytetet.getCartaActual();
        this.casillaActual = modeloQytetet.getJugadorActual().getCasillaActual();
        
        this.habilitarComenzarTurno();
        
        this.repaint(); //Investiga para qué sirven estos métodos
        this.revalidate();
    }
    public void habilitarComenzarTurno(){
        this.jbComprar.setEnabled(false);
        this.jbSiguienteJugador.setEnabled(false);
        this.jbAplicarSorpresa.setEnabled(false);
        if(modeloQytetet.getJugadorActual().getEncarcelado()){
            this.jbSalirCarcelPagando.setEnabled(true);
            this.jbSalirCarcelDado.setEnabled(true);
        }
        else
            this.jbJugar.setEnabled(true);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ControladorQytetet controladorQytetet= new ControladorQytetet();
        CapturaNombreJugadores capturaNombres = new CapturaNombreJugadores(controladorQytetet, true);
        ArrayList<String> nombres = capturaNombres.obtenerNombres();
        
        Dado.createInstance(controladorQytetet);
        modeloQytetet.inicializarJuego(nombres);
        
        controladorQytetet.actualizar(modeloQytetet);
        controladorQytetet.setVisible(true); //Esta debe ser la última
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAplicarSorpresa;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbJugar;
    private javax.swing.JButton jbSalirCarcelDado;
    private javax.swing.JButton jbSalirCarcelPagando;
    private javax.swing.JButton jbSiguienteJugador;
    private GUIQytetet.VistaQytetet vistaQytetet;
    // End of variables declaration//GEN-END:variables
}