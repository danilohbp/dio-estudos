
package com.jdbcjpa;

import com.jdbcjpa.dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author danilo
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        // Insere cursos predefinidos
        insereAlgunsCursos();
        
        // Busca todos os cursos inseridos
        buscarCursos();
        
        
        // Atualiza um curso, foi atualizado o curso com id 3
        
        Curso curso = new Curso();
        curso.setId(3);
        curso.setNome("Matemática para Desenvolvedores");
        curso.setDuracaoHoras(200);
        
        atualizarCurso(curso);


        // Exclui um curso, exemplo o curso de id 3
        excluirCurso(3);
    }
    
    
    public static void insereAlgunsCursos() {
        inserirCursosAutomaticamente("JSF, JPA e Hibernate na prática", 120);
        inserirCursosAutomaticamente("Matemática para Programadores", 240);
        inserirCursosAutomaticamente("Otimização de projetos com JPA", 100);
        inserirCursosAutomaticamente("Leitura e escrita de arquivos em Java", 80);
        inserirCursosAutomaticamente("Regex com Java", 40);
        inserirCursosAutomaticamente("Visão Computacional com Java", 50);
        inserirCursosAutomaticamente("Manutenção de códigos em Java", 60);
        inserirCursosAutomaticamente("Teste automatizados em Java", 100);
        inserirCursosAutomaticamente("Docker e Java - Projetos Avançados", 120);
        inserirCursosAutomaticamente("Dockerizando uma infraestrutura com Tomcat", 80);
        inserirCursosAutomaticamente("Desenvolvendo um API simples em Java", 10);
    }
    
    public static void inserirCursosAutomaticamente(String nome, int duracaoHoras) {
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setDuracaoHoras(duracaoHoras);
        new CursoDAO().inserir(curso);
        System.out.println("Curso " + curso.getNome() + " inserido com sucesso!");
    }
    
    public static void buscarCursos(){
        List<Curso> cursos = new CursoDAO().buscar();
        cursos.stream().forEach(System.out::println);
    }
    
    public static void atualizarCurso(Curso curso) {
        new CursoDAO().atualizar(curso);
        System.out.println("Curso atualizado com sucesso!");
    }
    
    public static void excluirCurso(int id) {
        new CursoDAO().excluir(new Curso(id, null, 0));
        System.out.println("Excluído com sucesso!");
    }
}
