package main.java.pilha.pilhaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;
import main.java.fila.filaencadeada.FilaProva;
import main.java.fila.filaencadeada.No;
import main.java.lista.Lista;
import main.java.lista.listaencadeada.ListaEncadeada;
import main.java.pilha.IPilha;
import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;

public class PilhaProva<T> implements IPilha<T> {

    public No<T> inicio;
    public No<T> noAuxiliar;
    public int qtd = 0;
    int tamanhoMax;

    public PilhaProva() {
        this.tamanhoMax = 10;
    }

    public Lista<PilhaProva<T>> obterListaPilhas(FilaProva<T> fila, int qtdDePilhas)
            throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException, Exception {

        Lista<PilhaProva<T>> lista = new ListaEncadeada<>();
        int qtdFila = fila.getQtd();
                
            if(qtdFila == 0) {
                throw new FilaVaziaException("A fila está vazia");
            }
            if(qtdDePilhas == 0) {
                throw new ParametroInvalidoException("obterListaPilhas");
            }
            if(qtdDePilhas < 0) {
                throw new ParametroInvalidoException("obterListaPilhas");
            }
             if(qtdDePilhas > qtdFila) {
                throw new ParametroInvalidoException("obterListaPilhas");
            }

        
        int divFilaPorPilhas = qtdFila / qtdDePilhas;
        int restoDiv = fila.getQtd() % qtdDePilhas;
        int maiorTamanho = divFilaPorPilhas + restoDiv;

        if (!estahVazia()) {
            for (int i = 0; i < qtdFila; i++) {
                empilhar(fila.remover());
            }
            if (qtdDePilhas < qtdFila && qtdDePilhas > 1) {
                if (restoDiv == 0) {
                    for (int i = 0; i < qtdDePilhas; i++) {
                        PilhaProva<T> pilha = new PilhaProva<>();
                        for (int j = 0; j < divFilaPorPilhas; j++) {
                            pilha.empilhar(desempilhar());
                        }
                        lista.incluirInicio(pilha);
                    }
                } else {
                    PilhaProva<T> pilha = new PilhaProva<>();
                    for (int j = 0; j < maiorTamanho; j++) {
                        pilha.empilhar(desempilhar());
                    }
                    lista.incluirInicio(pilha);

                    for (int i = 0; i < qtdDePilhas - 1; i++) {
                        pilha = new PilhaProva<>();
                        for (int j = 0; j < divFilaPorPilhas; j++) {
                            pilha.empilhar(desempilhar());
                        }
                        lista.incluirInicio(pilha);
                    }
                }
            } 
        } 
        return lista;
    }

    public boolean temConteudoIgual(FilaProva<T> fila) throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException {

        if (fila == null)
        return false;

        boolean retorno = true;

        if (fila.estaVazia() || this.estahVazia()) {
            retorno = false;
        } else {
            No<T> noAux = inicio;
            while (noAux.proximoNo != null) {
                for (int j = 0; j < fila.qtd; j++) {
                    No<T> noFila = fila.getInicio();
                    while (noFila.proximoNo != null) {
                        if (!noAux.conteudo.equals(noFila)) {
                            retorno = false;
                        }
                        noFila = noFila.proximoNo;
                    }
                }
                noAux = noAux.proximoNo;
            }
        }
        return retorno ;
    }

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        if (this.qtd == this.tamanhoMax) {
            throw new PilhaCheiaException("A pilha está cheia");
        }
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
        return this.qtd == 0 ? true : false;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        No<T> noAux = inicio;

        for (int i = 0; i < this.qtd; i++) {

            str.append("\n[").append(noAux.conteudo).append("]");
            noAux = noAux.proximoNo;
        }
        return str.toString();
    }

    private void verificaPilhaVazia() throws PilhaVaziaException {
        if (this.qtd == 0) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
    }

}
