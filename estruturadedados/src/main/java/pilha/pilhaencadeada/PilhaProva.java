package main.java.pilha.pilhaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;
import main.java.fila.filaencadeada.FilaProva;
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
        this.tamanhoMax = 2;
    }

    public Lista<PilhaProva<T>> obterListaPilhas(FilaProva<T> fila, int qtdDePilhas)
            throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException, Exception {

        Lista<PilhaProva<T>> lista = new ListaEncadeada<>();

        int quociente = fila.getQtd() / qtdDePilhas;
        int restoDiv = fila.getQtd() % qtdDePilhas;
        int capacidadeMaior = quociente + restoDiv;

        int qtdFila = fila.getQtd();

        if (qtdFila != 0) {
            for (int i = 0; i < qtdFila; i++) {
                empilhar(fila.remover());
            }
            if (qtdDePilhas < qtdFila && qtdDePilhas > 1) {
                if (restoDiv == 0) {
                    for (int i = 0; i < qtdDePilhas; i++) {
                        PilhaProva<T> pilha = new PilhaProva<>();
                        for (int j = 0; j < quociente; j++) {
                            pilha.empilhar(desempilhar());
                        }
                        lista.incluirInicio(pilha);
                    }
                } else {
                    PilhaProva<T> pilha = new PilhaProva<>();
                    for (int j = 0; j < capacidadeMaior; j++) {
                        pilha.empilhar(desempilhar());
                    }
                    lista.incluirInicio(pilha);

                    for (int i = 0; i < qtdDePilhas - 1; i++) {
                        pilha = new PilhaProva<>();
                        for (int j = 0; j < quociente; j++) {
                            pilha.empilhar(desempilhar());
                        }
                        lista.incluirInicio(pilha);
                    }
                }
            } else {
                throw new ParametroInvalidoException("obterListaPilhas");
            }
        } else {
            throw new FilaVaziaException("A fila está vazia");
        }

        return lista;

    }

    public Lista<PilhaProva<T>> obterBr(FilaProva<T> fila, int qtdDePilhas)
            throws FilaCheiaException, FilaVaziaException,
            PilhaCheiaException, PilhaVaziaException,
            ParametroInvalidoException, Exception {

        if (fila.estaVazia())
            throw new FilaVaziaException("A fila está vazia");
        if (qtdDePilhas < 1)
            throw new ParametroInvalidoException("obterListaPilhas");
        if (fila.getQtd() < qtdDePilhas)
            throw new ParametroInvalidoException("obterListaPilhas");

        int quociente = fila.getQtd() / qtdDePilhas;
        int resto = fila.getQtd() % qtdDePilhas;
        int capacidadeMaior = quociente + resto;

        PilhaProva<T> pilhaAux = new PilhaProva<>(); // recebe a fila

        for (int i = 0; i < fila.max; i++) {
            pilhaAux.empilhar((T) fila.getRefEntrada().getProximoNo());
        }

        Lista<PilhaProva<T>> listaDePilhas = new ListaEncadeada<>();

        if (resto == 0) {

            for (int i = 0; i < qtdDePilhas; i++) {

                PilhaProva<T> pilha = new PilhaProva<>();
                for (int j = 0; j < quociente; j++) {
                    pilha.empilhar(pilhaAux.desempilhar());
                }
                listaDePilhas.incluirInicio(pilha);
            }
        } else {

            PilhaProva<T> pilha = new PilhaProva<>();
            for (int j = 0; j < capacidadeMaior; j++) {
                pilha.empilhar(pilhaAux.desempilhar());
            }
            listaDePilhas.incluirInicio(pilha);

            for (int i = 0; i < qtdDePilhas - 1; i++) {

                pilha = new PilhaProva<>();
                for (int j = 0; j < quociente; j++) {
                    pilha.empilhar(pilhaAux.desempilhar());
                }
                listaDePilhas.incluirInicio(pilha);
            }

        }

        return listaDePilhas;
    }

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

        for (int i = 0; i < this.qtd; i++) {

            str.append("\n[").append(noAux.conteudo).append("]");
            noAux = noAux.proximoNo;
        }
        return str.toString();
    }

    private void verificaPilhaVazia() throws PilhaVaziaException {
        if (this.inicio == null) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }
    }

}
