package DAO;

import entidades.Aula;
import DAO.*;
import Database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class AulaDAO implements DAO<Aula>{
     

    @Override
    public int add(Aula aula) {
        String sql = "INSERT INTO aulas (nombreAula, activa, edicion, maxParticipantes) VALUES (?, ?, ?, ?);";
        int resultado;
        try(Connection con = Conexion.openConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1, aula.getNombreAula());
            stmt.setString(2, aula.getActiva().toString());
            stmt.setString(3, aula.getEdicion());
            stmt.setInt(4, aula.getMaxParticipantes());
            resultado = stmt.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Se ha añadido correctamente el aula");
            }
            
            return resultado;
            
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Aula getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Aula> getAll() {
        String sql = "SELECT * FROM aulas";
        List<Aula> aulas = new ArrayList<>();
        try(Connection con = Conexion.openConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            Aula aula;
            while(rs.next()){
                aula = new Aula(rs.getString(2), Activa.valueOf(rs.getString(3)), rs.getString(4), rs.getInt(5));
                aulas.add(aula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aulas;
    }

    @Override
    public int update(Aula t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Aula> getActivas(){
        String sql = "SELECT * FROM aulas WHERE activa = 'SI'";
        List<Aula> aulas = new ArrayList<>();
        try(Connection con = Conexion.openConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            Aula aula;
            while(rs.next()){
                aula = new Aula(rs.getString(2), Activa.valueOf(rs.getString(3)), rs.getString(4), rs.getInt(5));
                aulas.add(aula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aulas;
    }
    
}
