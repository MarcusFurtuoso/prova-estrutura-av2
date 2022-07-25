package main.java.fila;

import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;

public interface IFila<T> {
    public void incluir(T valor) throws FilaCheiaException;
    public T remover() throws FilaVaziaException;
    public boolean estaVazia();
    public void limpar();
}
