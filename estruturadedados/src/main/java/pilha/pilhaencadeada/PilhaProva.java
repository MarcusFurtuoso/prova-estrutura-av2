package main.java.pilha.pilhaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;
import main.java.fila.filaencadeada.FilaProva;
import main.java.lista.Lista;
import main.java.pilha.IPilha;
import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;

public class PilhaProva<T> implements IPilha<T> {

    public Lista<PilhaProva<T>> obterListaPilhas(FilaProva<T> fila, int qtdDePilhas)
            throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException {
           
       return null;
    }

    public No<T> inicio;
    public No<T> noAuxiliar;
    public int qtd = 0;

    public boolean temConteudoIgual(FilaProva<T> fila) throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException {
        throw new ParametroInvalidoException("temConteudoIgual");
    }

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        if (inicio == null) {
            inicio = new No<>(valor);
        } 
        noAuxiliar = new No<>(valor);
        noAuxiliar.proximoNo = inicio;
        inicio = noAuxiliar;
        this.qtd++;
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        verificaPilhaVazia();
        T aux = inicio.conteudo;
        inicio = inicio.proximoNo;
        this.qtd--;
        return aux;
    }

    @Override
    public T getTopo() throws PilhaVaziaException {
        verificaPilhaVazia();
        return inicio.conteudo;
    }

    @Override
    public int getQtd() {
        return this.qtd;
    }

    @Override
    public boolean estahVazia() {
        return inicio == null;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        No<T> noAux = inicio;
        int inv = this.qtd;
        for(int i = 0; i < this.qtd; i++){
            inv--;
            str.append("\n[").append(inv).append(" (").append(noAux.conteudo).append(")]");
            noAux = noAux.proximoNo;
        }
        return str.toString();
    }

    private void verificaPilhaVazia() throws PilhaVaziaException {
        if(this.inicio == null) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }
    }

}
