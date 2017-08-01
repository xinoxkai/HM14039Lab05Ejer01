/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hm14039ejem01lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author PRN-315
 */
public class EjercicioArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JOptionPane.showMessageDialog(null, "Iniciaremos escribiendo un archivo.\nNombre el archivo con su numero de carnet");
        escribirArchivo();
        File archivo;
    }
    
    public static void escribirArchivo(){
        JOptionPane.showMessageDialog(null, "Ejemplo crear archivo");
        
        //Se crea el filtro de archivos
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivos de texto","txt");
        
        //El objeto swing que mostrara la ventana para seleccionar el archivo
        JFileChooser seleccionador=new JFileChooser();
        seleccionador.setFileFilter(filtro);
        seleccionador.setDialogTitle("Abrir");
        
        //Muestra la ventana de dialogo
        seleccionador.showOpenDialog(null);
        
        if(seleccionador.getSelectedFile()!=null){
            File archivo = seleccionador.getSelectedFile();
            PrintWriter flujoSalida=null;
            
            try{
                flujoSalida=new PrintWriter(archivo);
            }catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Error al intentar abrir el archivo"+archivo);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Debera ingresar tres lineas de texto");
            
            for(int i=1;i<=3;i++){
                String linea = JOptionPane.showInputDialog("ingrese la linea"+i);
                flujoSalida.println(i+""+linea);
            }
            flujoSalida.close();
            
            JOptionPane.showMessageDialog(null, "El texto fue guardado en el archivo"+archivo);
        }
    }
    
}
