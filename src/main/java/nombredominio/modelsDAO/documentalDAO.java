package nombredominio.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nombredominio.config.Conexion;
import nombredominio.models.documental;

public class documentalDAO {
    Conexion conexion = new Conexion();

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement statement;
    
    documental documental = new documental();
    ArrayList<documental> documentales = new ArrayList<documental>();
    
    public documental save(documental documental) {
        String sql = "INSERT INTO documental (nombre, director, genero) VALUES ('" + documental.getNombre() + "', '"+ 
                                            documental.getDirector()+"', '"+ documental.getGenero()+"')";
        System.out.println(sql);
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documental;
    }
    
    public boolean eliminar(int id) {
        String sql = "DELETE FROM documental WHERE id = " + id;

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
    
    public documental update(documental documental) {
        String sql = "";
        if(documental.getGenero() != null) {
            sql = "UPDATE documental SET nombre = '" + documental.getNombre() +
                    "', director = '" + documental.getDirector() + "' WHERE id="+ documental.getId();
        }
            
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return documental;
    }
    
    public documental find(int id) {
        System.out.println(id);
        String sql = "SELECT * FROM documental WHERE id = " + id;
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                documental.setId(rs.getInt("id"));
                documental.setNombre(rs.getString("nombre"));
                documental.setDirector(rs.getString("director"));
                documental.setGenero(rs.getString("genero"));
                
                return documental;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("es aqui");
        }
        return null;
    }
    
    public ArrayList<documental> all(){
        String sql = "SELECT * FROM documentales";
        documentales = new ArrayList<documental>();
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                documental = new documental();
                documental.setId(rs.getInt("id"));
                documental.setNombre(rs.getString("nombre"));
                documental.setDirector(rs.getString("director"));
                documental.setGenero(rs.getString("genero"));
                documentales.add(documental);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return documentales;
    }
    
    public boolean validate(String director, String genero) {
        String sql = "SELECT * FROM documentales where director = '" + director + "' AND genero = '" + genero + "'";
        
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
    
    public documental getdocumentales(String director, String genero) {
        String sql = "SELECT * FROM documentales where director = '" + director + "' AND genero = '" + genero + "'";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                documental.setId(rs.getInt("id"));
                documental.setNombre(rs.getString("nombre"));
                documental.setDirector(rs.getString("director"));
                documental.setGenero(rs.getString("genero"));
                
                return documental;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

