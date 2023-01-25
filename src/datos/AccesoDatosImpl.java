package datos;

import dominio.Pelicula;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
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
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        var archivo = new File(nombre);
        List<Pelicula> lista = new ArrayList<>();

        try {

            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula peliculas = new Pelicula(lectura);
                lista.add(peliculas);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar peliculas: " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.print(pelicula.toString());
            salida.close();
        } catch (IOException ex) {
           ex.printStackTrace();
           throw new EscrituraDatosEx("excepcion al escribir: " + ex.getMessage());
        }
        
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
