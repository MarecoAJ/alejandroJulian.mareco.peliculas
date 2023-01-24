package datos;

import dominio.Pelicula;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        var archivo = new File(nombre);
        Pelicula peliculas = new Pelicula();
        List<Pelicula> lista = null;
        BufferedReader entrada = null;
        var lectura = "";

        try {
            entrada = new BufferedReader(new FileReader(archivo));
            lectura = entrada.readLine();
            while (lectura != null) {
                peliculas.setNombrePelicula(lectura);
                lista.add(peliculas);
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new FileWriter(archivo, anexar));
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el archivo");
        }
        salida.print(pelicula.getNombrePelicula());
        salida.close();
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        String encontrada = "";
        for (Pelicula pelicula : listar(nombreArchivo)) {
            if (pelicula.getNombrePelicula().equals(buscar)) {
                encontrada = pelicula.getNombrePelicula();
                break;
            }
        }

        return encontrada;
    }

    @Override
    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        File archivo = new File(nombreArchivo);
        try {
            salida = new PrintWriter(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo crear archivo");
        }
        salida.close();

    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.delete()) {
            System.out.println("Se elimino el archivo: " + nombreArchivo);
        } else {
            System.out.println("Se no se pudo eliminar el archivo: " + nombreArchivo);
        }
    }

}
