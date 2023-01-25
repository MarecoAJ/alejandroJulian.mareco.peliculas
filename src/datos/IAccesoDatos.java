package datos;

import dominio.Pelicula;
import excepciones.*;
import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
