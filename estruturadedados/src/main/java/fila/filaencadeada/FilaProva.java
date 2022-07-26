package main.java.fila.filaencadeada;

import main.java.fila.IFila;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;

public class FilaProva<T> implements IFila<T> {

    public No<T> refEntrada;
    public int qtd = 0;
    public int max;


    public FilaProva() {
        this.refEntrada = null;
        this.max = 10;
    }


    @Override
    public void incluir(T valor) throws FilaCheiaException {
        No<T> novoNo = new No<>(valor);
        novoNo.setProximoNo(refEntrada);
        refEntrada = novoNo;
        qtd++;
    }

    @Override
    public T remover() throws FilaVaziaException {
        if (!this.estaVazia()) {
            No<T> primeiroNo = refEntrada;
            No<T> noAuxiliar = refEntrada;
            while (true) {
                if (primeiroNo.getProximoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getProximoNo();
                    qtd--;
                } else {
                    noAuxiliar.setProximoNo((null));
                    qtd--;
                    break;
                }
            }
            return (T) primeiroNo.getConteudo();
        }
        throw new FilaVaziaException("A fila está vazia!");
    }

    @Override
    public boolean estaVazia() {
        return this.refEntrada == null ? true : false;
    }

    @Override
    public void limpar() {
        this.refEntrada = null;
    }

    public int getQtd() {
        return this.qtd;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No<T> noAuxiliar = refEntrada;

        if (refEntrada != null) {
            while (true) {
                stringRetorno += "\n[" + noAuxiliar.getConteudo() + "]";
                if (noAuxiliar.getProximoNo() != null) {
                    noAuxiliar = noAuxiliar.getProximoNo();
                } else {
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }

    public No<T> getRefEntrada() {
        return refEntrada;
    }

    public void setRefEntrada(No<T> refEntrada) {
        this.refEntrada = refEntrada;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    
}
