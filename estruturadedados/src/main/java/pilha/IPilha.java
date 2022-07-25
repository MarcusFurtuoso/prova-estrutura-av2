package main.java.pilha;

import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;

public interface IPilha<T> {
    void empilhar(T valor) throws PilhaCheiaException;
    T desempilhar() throws PilhaVaziaException;
    T getTopo() throws PilhaVaziaException;
    int getQtd();
    boolean estahVazia();

}
