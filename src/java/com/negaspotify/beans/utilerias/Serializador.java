/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans.utilerias;

/**
 *
 * @author minutti
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


/**
 * Esta clase sirve para guardar y cargar un archivo por medio de serialización
 * @author minutti
 */
public class Serializador {
    /**
     * Este método sirve para crear el archivo y guardarlo
     * @param someObject objeto que se va a serializar
     * @param outputFile archivo que se va a guardar
     */
    public static void serialize(Object someObject, File outputFile) throws IOException{
        
        FileOutputStream fileStream = new FileOutputStream(outputFile);
        ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
        
        outStream.writeObject(someObject);
        
        outStream.close();
    }
    
    /**
     * Este método sirve para leer el archivo guardado previamente
     * @param inputFile ruta del archivo a leer
     * 
     */
    
    public static Object deserialize(File inputFile) throws IOException, ClassNotFoundException{
        FileInputStream fileStream = new FileInputStream(inputFile);
        ObjectInputStream inputStream = new ObjectInputStream(fileStream);
        
        Object readObject = inputStream.readObject();
        inputStream.close();
        
        return readObject;
    }
    
}

