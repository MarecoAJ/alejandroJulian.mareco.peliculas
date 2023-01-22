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
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{nombrePelicula=").append(nombrePelicula);
        sb.append('}');
        return sb.toString();
    }
    
    

}
