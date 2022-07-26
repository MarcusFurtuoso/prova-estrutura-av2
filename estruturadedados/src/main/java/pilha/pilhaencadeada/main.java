package main.java.pilha.pilhaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;
import main.java.fila.filaencadeada.FilaProva;
import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;

public class main {
    public static void main(String[] args) throws PilhaCheiaException, PilhaVaziaException, FilaCheiaException,
            FilaVaziaException, ParametroInvalidoException, Exception {

        PilhaProva<String> pilha = new PilhaProva<>();

        FilaProva<String> fila = new FilaProva<>();
        
        fila.incluir("A");
        fila.incluir("B");
        fila.incluir("C");
        fila.incluir("D");
        fila.incluir("E");
        fila.incluir("F");
        fila.incluir("G");
        fila.incluir("H");
        fila.incluir("I");
        fila.incluir("J");
        // System.out.println(fila);
        // fila.remover();
        // System.out.println(fila);
        
               
        
        System.out.println(pilha.obterListaPilhas(fila,6));
    }
}
