package rommel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
// import util.Archivo;

/**
 *
 * @author aaron
 */
public class GestionDeArchivos {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    public String rutaArchivo = null;
    private boolean existe = false;
    
    private String pathExistente;
    private String path;
    private String[] lineas;
    private JFileChooser seleccion;
    
     

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    
    
      public GestionDeArchivos(){
        
    }
      
      public void FileChooser() {
        seleccion = new JFileChooser();
        // DIRECTORIO DEL ARCHIVO
        seleccion.setCurrentDirectory(new File("C:\\Users\\Aaron"));
        seleccion.setFileFilter(new FileNameExtensionFilter("Archivo Rommel", "rml"));

    }
    
    /*Abrir un archivo de texto*/
    public String AbrirATexto(File archivo){
        
        String contenido="";
        
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!= -1){
                char carcater = (char)ascci;
                contenido += carcater;
            }
        } catch (Exception e) {
        }
        
            
           
         return contenido;}
        
       
    
    
    /*Guardar archivo de texto*/
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

    
    
}
