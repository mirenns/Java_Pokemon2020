
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(1);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/pokedex",
                            "root",
                            "");
            estado = conexion.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();
        movimiento1 = new javax.swing.JLabel();
        movimiento2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextPane();
        altura = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        habilidad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon);
        imagenPokemon.setBounds(57, 170, 250, 167);

        izq.setBorderPainted(false);
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq);
        izq.setBounds(226, 423, 50, 50);

        der.setBorderPainted(false);
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der);
        der.setBounds(300, 420, 40, 50);

        nombrePokemon.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        nombrePokemon.setForeground(new java.awt.Color(255, 255, 255));
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombrePokemon);
        nombrePokemon.setBounds(440, 170, 264, 40);

        movimiento1.setForeground(new java.awt.Color(255, 255, 255));
        movimiento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(movimiento1);
        movimiento1.setBounds(440, 330, 133, 34);

        movimiento2.setForeground(new java.awt.Color(255, 255, 255));
        movimiento2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(movimiento2);
        movimiento2.setBounds(580, 330, 125, 34);

        descripcion.setBackground(new java.awt.Color(0, 0, 0));
        descripcion.setBorder(null);
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(descripcion);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 230, 264, 70);

        altura.setForeground(new java.awt.Color(255, 255, 255));
        altura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(altura);
        altura.setBounds(440, 400, 40, 40);

        peso.setForeground(new java.awt.Color(255, 255, 255));
        peso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(peso);
        peso.setBounds(500, 400, 40, 43);

        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Altura");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 380, 38, 16);

        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Peso");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 380, 29, 16);

        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Movimiento 1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 310, 86, 16);

        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Movimiento 2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 310, 86, 16);

        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Habilidad");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(610, 380, 60, 16);

        habilidad.setForeground(new java.awt.Color(255, 255, 255));
        habilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(habilidad);
        habilidad.setBounds(580, 410, 133, 30);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(430, 170, 280, 350);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 750, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        if (contador <=0){
            contador = 1;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed

        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador+1));
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
                altura.setText(resultadoConsulta.getString(3));
                peso.setText(resultadoConsulta.getString(4));
                movimiento1.setText(resultadoConsulta.getString(10));
                movimiento2.setText(resultadoConsulta.getString(11));
                habilidad.setText(resultadoConsulta.getString(9));
            }
            else{
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
            }
        } catch (SQLException ex) {
        }
        contador ++;
        if (contador >=649){
            contador = 649;
        }
        
    }//GEN-LAST:event_derActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altura;
    private javax.swing.JButton der;
    private javax.swing.JTextPane descripcion;
    private javax.swing.JLabel habilidad;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel movimiento1;
    private javax.swing.JLabel movimiento2;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JLabel peso;
    // End of variables declaration//GEN-END:variables
}
