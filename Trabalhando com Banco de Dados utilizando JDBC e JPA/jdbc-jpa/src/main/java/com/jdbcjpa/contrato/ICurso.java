
package com.jdbcjpa.contrato;

import com.jdbcjpa.Curso;
import java.util.List;

/**
 *
 * @author danilo
 */
public interface ICurso {
    
    void inserir(Curso curso);
    
    List<Curso> buscar();
    
    void atualizar(Curso curso);
    
    void excluir(Curso curso);
    
}
