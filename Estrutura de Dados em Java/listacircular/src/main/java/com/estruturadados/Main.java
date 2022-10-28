
package com.estruturadados;

/**
 *
 * @author danilo
 */
public class Main {
    public static void main(String[] args) {
        ListaCircular<String> minhaListaCircular = new ListaCircular<>();
        
        minhaListaCircular.add("c0");
        minhaListaCircular.add("c1"); 
        minhaListaCircular.add("c2"); // Adicionei na 'cauda' da lista então ela é a nova entrada da listagem
        
        // Mostra toda a lista
        System.out.println(minhaListaCircular);
        
        
        // Remove o 3º item da listagem
        minhaListaCircular.remove(2);
        
        // Mostra toda a lista
        System.out.println(minhaListaCircular);
        
       
        System.out.println(minhaListaCircular.get(2));
    }
}
