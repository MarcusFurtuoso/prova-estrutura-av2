package main.java.fila.filaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.IFila;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;

public class FilaProva<T> implements IFila<T> {

    public int qtd = 0;
    public int max;
    public No<T> inicio;
    public No<T> finalFila;

    public FilaProva() {
        this.max = 10;
    }

    @Override
    public void incluir(T valor) throws FilaCheiaException {
        if(this.qtd == this.max) {
            throw new FilaCheiaException("A fila está cheia");
        }
        No<T> novoNo = new No<>(valor);
        if(inicio == null) {
            inicio = novoNo;
            finalFila = novoNo;
            novoNo.setProximoNo(null);
        } else {
            finalFila.setProximoNo(novoNo);
            novoNo.setProximoNo(null);
            finalFila=novoNo;
        }
        qtd++;
    }

    @Override
    public T remover() throws FilaVaziaException {
        if(this.qtd == 0) {
            throw new FilaVaziaException("A fila está vazia!");
        }
        No<T> aux = inicio;
        if(inicio == finalFila && inicio != null) {
            inicio = null;
            finalFila = null;
        } else {
            inicio = inicio.getProximoNo();
        }
        qtd--;
       return aux.getConteudo();
    }

    @Override
    public boolean estaVazia() {
        return this.qtd == 0 ? true : false;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.qtd = 0;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void imptimir() {
        No<T> aux = inicio;
       while(aux!=null) {
        System.out.println(aux.getConteudo());
        aux=aux.getProximoNo();
       }
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
    }

    public No<T> getFinalFila() {
        return finalFila;
    }

    public void setFinalFila(No<T> finalFila) {
        this.finalFila = finalFila;
    }
    
}
