package rommel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import rommel.GestionDeArchivos;

public class Interfaz extends javax.swing.JFrame {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] bytesImg;
    GestionDeArchivos gestion = new GestionDeArchivos();
    FileInputStream entrada;
    FileOutputStream salida;
    public String rutaArchivo = null;
    private JFileChooser seleccion;
    private boolean existe = false;
    private String pathExistente;
    private String path;
    private String[] lineas;
    private boolean iniciado = false;
    private lexico lex;

    public Interfaz() {
        initComponents();

        setTitle("Rommel");
        //this.areaConsola.disable();
        this.nLineas.disable();
        this.setLocation(100, 100);
        //this.setSize(500, 500);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Rommel/Imagenes/Romel.png"));
        setIconImage(icon);
    }

    public JTextArea getAreaConsola() {
        return areaConsola;
    }

    public void setAreaConsola(String texto) {
        areaConsola.setText(texto);
    }

    public void setAreaTexto(String texto) {
        nLineas.setText("");
        areaTexto.setText(texto);
        numeroLineas();
    }

    public String getAreaTexto() {
        return areaTexto.getText();
    }

    public void setLineas() {
        nLineas.setText("");
    }

    public void numeroLineas() {
        int lineas = areaTexto.getLineCount();
        nLineas.setText("  ");
        for (int i = 1; i <= lineas; i++) {
            nLineas.setText(nLineas.getText() + i + "\n  ");
        }
    }

    public void FileChooser() {
        seleccion = new JFileChooser();
        // DIRECTORIO DEL ARCHIVO
        seleccion.setCurrentDirectory(new File("C:\\Users\\Aaron"));
        seleccion.setFileFilter(new FileNameExtensionFilter("Archivo Rommel", "rml"));

    }

    public void compilar() throws FileNotFoundException {
        try {
            String[] lineas = areaTexto.getText().split("\n");
            areaConsola.setText("");
            PrintWriter pw = new PrintWriter(new File("Romel.rml"));

            for (String linea : lineas) {
                pw.println(linea);
                pw.flush();
            }
            lexico analex1;
            analex1 = new lexico(new FileInputStream("Romel.rml"));

            try {
                analex1.Programa();
                if (!analex1.contador.isEmpty()) {
                    areaConsola.setForeground(Color.RED);
                    for (int i = 0; i < analex1.contador.size(); i++) {
                        areaConsola.setText(areaConsola.getText() + analex1.contador.elementAt(i));
                    }
                    analex1.contador.removeAllElements();

                } else {
                    areaConsola.setText("Compilación exitosa.");
                    Color color = new Color(51, 153, 0);
                    areaConsola.setForeground(color);
                    analex1.contador.removeAllElements();
                }
            } catch (ParseException er) {
                System.out.println("Se ha producido el siguiente error: " + "\n" + er.getMessage());
                areaConsola.setForeground(Color.RED);

            } catch (Exception er) {
                System.out.println("Se ha producido el siguiente error: " + "\n" + er.getMessage());
                areaConsola.setForeground(Color.RED);
            }

            //ATENCION ACONTINUACION QUITAR LA COMENTACION DE ANALISIS LEXICO PARA IMPRIMIR TAMBIEN EL ANALIS LEXICO
            /*   
                    for (int i = 0; i < AnalizadorTokenManager.getPares().size(); i++) {
                        //System.out.println("ANALISIS LEXICO "+AnalizadorTokenManager.getPares().get(i));
                    }
                    AnalizadorTokenManager.getPares().clear();
             */
        } catch (FileNotFoundException er) {
            System.out.println("Error al compilar. " + er.getMessage());
        }
        setLineas();
        numeroLineas();

    }
public void GuardarATexto(File archivo, String contenido){
        String respuesta=null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo con éxito el archivo";
        } catch (Exception e) {
        }
        //return respuesta;
    }

    public void guardar() throws IOException {
        numeroLineas();
        FileChooser();
        if (existe) {
            File archivo2 = new File(pathExistente);
            GuardarATexto(archivo2,areaTexto.getText());
            JOptionPane.showMessageDialog(null,
                    "Archivo guardado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            seleccion.showSaveDialog(jMenu1);
            File archivo = seleccion.getSelectedFile();
            if (archivo != null) {
                FileWriter writer = null;
                writer = new FileWriter(archivo + ".rml");
                writer.write(this.getAreaTexto());
                writer.close();
                JOptionPane.showMessageDialog(null,
                        "Archivo guardado",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                existe = true;
                //pathExistente = archivo + ".smt";
            } else {
                JOptionPane.showMessageDialog(null,
                        "El archivo no se guardó",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            setLineas();
            numeroLineas();
            existe = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLineas = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        scroll2 = new javax.swing.JScrollPane();
        areaConsola = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoProyecto = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        guardarComo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("ventana"); // NOI18N
        setResizable(false);

        nLineas.setColumns(20);
        nLineas.setForeground(new java.awt.Color(102, 102, 102));
        nLineas.setRows(5);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rommel/Imagenes/logo2.jpg"))); // NOI18N

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        areaTexto.setToolTipText("Todo codigo logico aquí");
        jScrollPane1.setViewportView(areaTexto);

        scroll2.setBorder(javax.swing.BorderFactory.createTitledBorder("Salida de consola"));

        areaConsola.setEditable(false);
        areaConsola.setColumns(20);
        areaConsola.setRows(5);
        areaConsola.setToolTipText("Analisis sinctactico");
        scroll2.setViewportView(areaConsola);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Compilar");
        jButton1.setToolTipText("Compilar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        nuevoProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rommel/Imagenes/nuevo.png"))); // NOI18N
        nuevoProyecto.setText("Nuevo");
        nuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoProyecto);

        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rommel/Imagenes/abrir.png"))); // NOI18N
        abrir.setText("Abrir...");
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirMouseClicked(evt);
            }
        });
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rommel/Imagenes/guardar.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu1.add(guardar);

        guardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rommel/Imagenes/guardarcomo.png"))); // NOI18N
        guardarComo.setText("Guardar como...");
        guardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(guardarComo);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(171, 171, 171)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(nLineas)
                    .addComponent(scroll2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(180, 180, 180))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseClicked

    }//GEN-LAST:event_abrirMouseClicked

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        existe = false;
        String line, text = "";

        FileChooser();
        try {
            seleccion.showOpenDialog(jMenu1);
//            seleccion.showOpenDialog(panel);
            File archivo = seleccion.getSelectedFile();
//            seleccion.setAcceptAllFileFilterUsed(false);
            setTitle(seleccion.getName(archivo));

            seleccion.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter txt = new FileNameExtensionFilter("archivo de texto", "txt");
            seleccion.setFileFilter(txt);
            FileNameExtensionFilter rml = new FileNameExtensionFilter("archivo rommel", "rml");
            seleccion.setFileFilter(rml);
            path = archivo.getAbsolutePath();
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                text += " " + line + "\n";
            }
            br.close();
            // JOptionPane.showMessageDialog(panel);
            setAreaTexto(text);
            setAreaConsola("");
            existe = true;
            pathExistente = path.toString();
        } catch (Exception er) {
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void nuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProyectoActionPerformed
        this.areaTexto.setText("");
        this.areaConsola.setText("");
        this.nLineas.setText("");
        this.setTitle("Rommel");
        existe = false;

    }//GEN-LAST:event_nuevoProyectoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            guardar();
        } catch (IOException ex) {
            //Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void guardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoActionPerformed
        lineas = getAreaTexto().split("\n");
        // CARPETA
        JFileChooser seleccion2 = new JFileChooser("C:\\Users\\Aaron");

        seleccion2.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro1 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        seleccion2.setFileFilter(filtro1);
        FileNameExtensionFilter rml = new FileNameExtensionFilter("archivo rommel", "rml");
        seleccion2.setFileFilter(rml);

        int opcion = seleccion2.showSaveDialog(jMenu1);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String ext = "." + ((FileNameExtensionFilter) seleccion2.getFileFilter()).getExtensions()[0];
            rutaArchivo = seleccion2.getSelectedFile().getAbsolutePath();
            if (!rutaArchivo.endsWith(ext)) {
                rutaArchivo += ext;
            }
           //Archivo.grabarArchivo(rutaArchivo, lineas);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El archivo no se guardó",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        existe = true;
    }//GEN-LAST:event_guardarComoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try {
            compilar();
            //String texto = "";
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mitzy\\Documents"));
//            if (!iniciado) {
//                lex = new lexico(new FileReader("C:\\Users\\mitzy\\Documents"));
//                iniciado = true;
//            } else {
//                lex.ReInit(new FileReader("C:\\Users\\mitzy\\Documents"));
//            }
//
//            //this.jButton2.setEnabled(false);
//        } catch (Exception ex) {
//            System.out.println("error" + ex);
//        }
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    public static javax.swing.JTextArea areaConsola;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarComo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea nLineas;
    private javax.swing.JMenuItem nuevoProyecto;
    private javax.swing.JScrollPane scroll2;
    // End of variables declaration//GEN-END:variables
}
