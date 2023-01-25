package datos;

import dominio.Pelicula;
import excepciones.*;
import java.io.*;
import java.util.*;

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
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;

            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "pelicula " + linea + " encontrdan el indice:  " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar: " + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

        try {
            var salida = new PrintWriter(new File(nombreArchivo));
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("excepcion al crear archivo " + ex.getMessage());
        }

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
