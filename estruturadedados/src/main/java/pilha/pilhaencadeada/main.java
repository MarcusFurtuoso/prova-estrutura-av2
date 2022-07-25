package main.java.pilha.pilhaencadeada;

import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;

public class main {
    public static void main(String[] args) throws PilhaCheiaException, PilhaVaziaException {

        PilhaProva<String> pilha = new PilhaProva<>();
        pilha.empilhar("Bruno");
        pilha.empilhar("Rafael");
        pilha.empilhar("Andre");
        pilha.empilhar("Simoes");
        pilha.desempilhar();
        System.out.println(pilha);
    }
}
