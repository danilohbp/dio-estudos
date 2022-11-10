
package com.jdbcjpa.dao;

import com.jdbcjpa.Curso;
import com.jdbcjpa.contrato.ICurso;
import com.jdbcjpa.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danilo
 */
public class CursoDAO implements ICurso {

    @Override
    public void inserir(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()){
            
            String sql = "INSERT INTO curso (nome, duracao_horas) VALUES(?, ?)";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, curso.getNome());
            pst.setInt(2, curso.getDuracaoHoras());
            
            pst.executeUpdate();
        } catch(SQLException e){
            System.out.println("Inserção falhou!");
            e.getStackTrace();
        }
    }

    @Override
    public List<Curso> buscar() {
        
        List<Curso> retorno = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection()){
            
            String sql = "SELECT * FROM curso";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery(sql);
            
            while(rs.next()){
                Curso curso = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("duracao_horas"));
                retorno.add(curso);
            }
            
        } catch(SQLException e){
            System.out.println("A busca falhou!");
            e.printStackTrace();
        }
        return retorno;
    }

    @Override
    public void atualizar(Curso curso) {
       try (Connection conn = ConnectionFactory.getConnection()){
           
           String sql = "UPDATE curso SET NOME = ?, DURACAO_HORAS = ? WHERE ID = ?";
           
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, curso.getNome());
           pst.setInt(2, curso.getDuracaoHoras());
           pst.setInt(3, curso.getId());
           
           int linhasAfetadas = pst.executeUpdate();
       } catch(SQLException e){
           System.out.println("Falha na atualização!");
           e.printStackTrace();
       }
    }

    @Override
    public void excluir(Curso curso) {
       try (Connection conn = ConnectionFactory.getConnection()){
           
           String sql = "DELETE FROM curso WHERE id = ?";
           
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setInt(1, curso.getId());
           
           int linhasAfetadas = pst.executeUpdate();
       } catch(SQLException e){
           System.out.println("Falha ao tentar excluir!");
           e.printStackTrace();
       } 
    }
    
}
