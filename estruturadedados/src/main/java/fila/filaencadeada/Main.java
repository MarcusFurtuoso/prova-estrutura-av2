package main.java.fila.filaencadeada;

import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;

public class Main {
    public static void main(String[] args) throws FilaCheiaException, FilaVaziaException {
        FilaProva<String> minhaFila = new FilaProva<>();

        minhaFila.incluir("primeiro");
        // minhaFila.incluir("segundo");
        // minhaFila.incluir("terceiro");
        // minhaFila.incluir("quarto");

        System.out.println(minhaFila);

        System.out.println(minhaFila.remover());

        System.out.println(minhaFila.getQtd());

        // minhaFila.remover();
       
        // System.out.println(minhaFila.getQtd());
        System.out.println(minhaFila);
    }
}
