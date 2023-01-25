package dominio;

public class Pelicula {

    private String nombrePelicula;

    public Pelicula() {
    }

    public Pelicula(String nombre) {

        this.nombrePelicula = nombre;
    }

    public String getNombrePelicula() {
        return this.nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
       return this.nombrePelicula;
    }
    
    

}
