package datos;

import dominio.Pelicula;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {

        return false;

    }

    @Override
    public List<Pelicula> listar(String nombre) {
        var archivo = new File(nombre);
        Pelicula peliculas = new Pelicula();
        List<Pelicula> lista = null;
        var entrada = new BufferedReader(new FileReader(archivo));
        var lectura = entrada.readLine();
        while (lectura != null) {
            peliculas.setNombrePelicula(lectura);
            lista.add(peliculas);
        }
        entrada.close();
        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
        salida.print(pelicula.getNombrePelicula());
        salida.close();
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {

        return null;
    }

    @Override
    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(archivo);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccesoDatosImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            salida.close();
        }

    }

    @Override
    public void borrar(String nombreArchivo) {

    }

}
