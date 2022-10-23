package nombredominio.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nombredominio.config.Conexion;
import nombredominio.models.serie;

public class serieDAO {
    Conexion conexion = new Conexion();

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement statement;

    serie serie = new serie();
    ArrayList<serie> series = new ArrayList<serie>();
    
    public serie save(serie serie) {
        String sql = "INSERT INTO serie (nombre, director, genero) VALUES ('" + serie.getNombre() + "', '"+ 
                                            serie.getDirector()+"', '"+ serie.getGenero()+"')";
        System.out.println(sql);
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serie;
    }
    
    public boolean eliminar(int id) {
        String sql = "DELETE FROM serie WHERE id = " + id;

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
    
    public serie update(serie serie) {
        String sql = "";
        if(serie.getGenero() != null) {
            sql = "UPDATE serie SET nombre = '" + serie.getNombre() +
                    "', director = '" + serie.getDirector() + "' WHERE id="+ serie.getId();
        }
            
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return serie;
    }
    
    public serie find(int id) {
        String sql = "SELECT * FROM serie WHERE id = " + id;
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                serie.setId(rs.getInt("id"));
                serie.setNombre(rs.getString("nombre"));
                serie.setDirector(rs.getString("director"));
                serie.setGenero(rs.getString("genero"));
                
                return serie;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<serie> all(){
        String sql = "SELECT * FROM serie";
        series = new ArrayList<serie>();
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                serie = new serie();
                serie.setId(rs.getInt("id"));
                serie.setNombre(rs.getString("nombre"));
                serie.setDirector(rs.getString("director"));
                serie.setGenero(rs.getString("genero"));
                series.add(serie);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return series;
    }
    
    public boolean validate(String director, String genero) {
        String sql = "SELECT * FROM series where director = '" + director + "' AND genero = '" + genero + "'";
        
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
    
    public serie getserie(String director, String genero) {
        String sql = "SELECT * FROM series where director = '" + director + "' AND genero = '" + genero + "'";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                serie.setId(rs.getInt("id"));
                serie.setNombre(rs.getString("nombre"));
                serie.setDirector(rs.getString("director"));
                serie.setGenero(rs.getString("genero"));
                
                return serie;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

