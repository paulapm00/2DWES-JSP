package nombredominio.models;

public class pelicula {
	private int id;
	private String nombre;
	private String director;
	private String genero;
	

	public pelicula(int id, String nombre, String director, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.director = director;
		this.genero = genero;
	}
	
	public pelicula(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
