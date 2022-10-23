package nombredominio.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nombredominio.config.Conexion;
import nombredominio.models.pelicula;

public class peliculaDAO {
	
	Conexion conexion = new Conexion();

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Statement statement;
	
	pelicula pelicula = new pelicula();
	ArrayList<pelicula> peliculas = new ArrayList<pelicula>();
	
	public pelicula save(pelicula pelicula) {
		String sql = "INSERT INTO pelicula (nombre, director, genero) VALUES ('" + pelicula.getNombre() + "', '"+ 
											pelicula.getDirector()+"', '"+ pelicula.getGenero()+"')";
		System.out.println(sql);
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pelicula;
	}
	
	public boolean eliminar(int id) {
		String sql = "DELETE FROM pelicula WHERE id = " + id;

		try {
			conn = conexion.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public pelicula update(pelicula pelicula) {
		String sql = "";
		if(pelicula.getGenero() != null) {
			sql = "UPDATE pelicula SET nombre = '" + pelicula.getNombre() +
					"', director = '" + pelicula.getDirector() + "' WHERE id="+ pelicula.getId();
		}
			
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pelicula;
	}
	
	public pelicula find(int id) {
	    System.out.println(id);
		String sql = "SELECT * FROM pelicula WHERE id = " + id;
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pelicula.setId(rs.getInt("id"));
				pelicula.setNombre(rs.getString("nombre"));
				pelicula.setDirector(rs.getString("director"));
				pelicula.setGenero(rs.getString("genero"));
				
				return pelicula;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("es aqui");
		}
		return null;
	}
	
	public ArrayList<pelicula> all(){
		String sql = "SELECT * FROM pelicula";
		peliculas = new ArrayList<pelicula>();
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pelicula = new pelicula();
				pelicula.setId(rs.getInt("id"));
				pelicula.setNombre(rs.getString("nombre"));
				pelicula.setDirector(rs.getString("director"));
				pelicula.setGenero(rs.getString("genero"));
				peliculas.add(pelicula);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
	}
	
	public boolean validate(String director, String genero) {
		String sql = "SELECT * FROM peliculas where director = '" + director + "' AND genero = '" + genero + "'";
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public pelicula getpelicula(String director, String genero) {
		String sql = "SELECT * FROM peliculas where director = '" + director + "' AND genero = '" + genero + "'";
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pelicula.setId(rs.getInt("id"));
				pelicula.setNombre(rs.getString("nombre"));
				pelicula.setDirector(rs.getString("director"));
				pelicula.setGenero(rs.getString("genero"));
				
				return pelicula;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
