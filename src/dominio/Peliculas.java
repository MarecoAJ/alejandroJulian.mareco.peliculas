package dominio;

public class Peliculas {

    private String nombrePelicula;

    public Peliculas() {
    }

    public Peliculas(String nombre) {

        this.nombrePelicula = nombre;
    }

    public String getNombrePelicula() {
        return this.nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

}
