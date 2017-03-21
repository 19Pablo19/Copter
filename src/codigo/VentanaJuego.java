/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Pablo
 */
public class VentanaJuego extends javax.swing.JFrame {
        
    Image background; 
        boolean comienzo = false;
        boolean gameOver = false;
        Helicoptero miHelicoptero = new Helicoptero(50);
        
        BufferedImage buffer = null;

    
        Graphics2D bufferGraphics, lienzoGraphics = null;
       
        
    static int ANCHOPANTALLA = 600;
    static int ALTOPANTALLA = 400;
    static int SEPARACION_COLUMNAS = 80;
    
    
 Obstaculo miObstaculo = new Obstaculo(ANCHOPANTALLA  , ANCHOPANTALLA);
  Obstaculo miObstaculo2 = new Obstaculo(ANCHOPANTALLA + 5*SEPARACION_COLUMNAS, ANCHOPANTALLA);
 
    
    Columna miColumna1 = new Columna(0 , ANCHOPANTALLA);
    Columna miColumna2 = new Columna(0 + SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna3 = new Columna(0 + 2*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna4 = new Columna(0 + 3*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna5 = new Columna(0 + 4*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna6 = new Columna(0 + 5*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna7 = new Columna(0 + 6*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna8 = new Columna(0 + 7*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna9 = new Columna(0 + 8*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna10 = new Columna(0 + 9*SEPARACION_COLUMNAS, ANCHOPANTALLA);

    /**
     * Creates new form VentanaJuego
     */
    
    
        Timer temporizador = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            bucleDelJuego();

        }
    });
    
    public VentanaJuego() {
        initComponents();
        inicializaBuffers();
      
    }
    

    private void inicializaBuffers(){
        lienzoGraphics = (Graphics2D) jPanel1.getGraphics();
        buffer = (BufferedImage) jPanel1.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        bufferGraphics = buffer.createGraphics();
        
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
    }

    private void gameOver(){
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
    System.exit(ABORT);
    
    }
    
    
    private void precargaimagenes(){
        
        background = (new ImageIcon(new ImageIcon(
                getClass().getResource("/imagenes/images.jpeg"))
                .getImage().getScaledInstance(ANCHOPANTALLA,ALTOPANTALLA, Image.SCALE_DEFAULT)))
                .getImage();
        
       
    }
    
    private void bucleDelJuego(){
        if (miHelicoptero.chequeaColision(miColumna1)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna2)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna3)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna4)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna5)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna6)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna7)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna8)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna9)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision(miColumna10)){temporizador.stop(); gameOver();}
        
        if (miHelicoptero.chequeaColision2(miObstaculo)){temporizador.stop(); gameOver();}
        if (miHelicoptero.chequeaColision2(miObstaculo2)){temporizador.stop(); gameOver();}
        
        
        //limpio la pantalla
        bufferGraphics.setColor(Color.white);
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA); 
        //dibujo el pájaro en su nueva posición
        miHelicoptero.mueve(bufferGraphics);
        miColumna1.mueve(bufferGraphics);
        miColumna2.mueve(bufferGraphics);
        miColumna3.mueve(bufferGraphics);
        miColumna4.mueve(bufferGraphics);
        miColumna5.mueve(bufferGraphics);
        miColumna6.mueve(bufferGraphics);
        miColumna7.mueve(bufferGraphics);
        miColumna8.mueve(bufferGraphics);
        miColumna9.mueve(bufferGraphics);
        miColumna10.mueve(bufferGraphics);
        
        miObstaculo.mueve(bufferGraphics);
        miObstaculo2.mueve(bufferGraphics);
        
        lienzoGraphics.drawImage(buffer, 0,0, null);
    }
    
    private void bucleJuego2(){
       //CREAR OTRO PANEL PARA QUE SEA EL MENU PRINCIPAL Y HACER QUE EL JUEGO NO COMIENCE Y SE MUESTRE VISIBLE 
       //EL PANEL SELECCIONADO Y CUANDO COMIENCE EL PANEL 'SUPERPUESTO' SE OCULTE
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(32, 128, 21));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("START");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
             
        if (evt.getKeyCode() == KeyEvent.VK_SPACE){
                  
           miHelicoptero.yVelocidad += 10;
        
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                  
           miHelicoptero.yVelocidad += 10;
        
        }
    }//GEN-LAST:event_formKeyPressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
                 //ALGUNA FUNCION PARA LLAMAR A TODOS LOS CHEQUEA COLISION A LA VEZ
                 //if chequacolision = false ...
//        temporizador.start();
    }//GEN-LAST:event_formMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        temporizador.start();
    }//GEN-LAST:event_jLabel1MousePressed
     
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
