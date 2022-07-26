package main.java.lista.listaencadeada;

import main.java.comum.ParametroInvalidoException;
import main.java.lista.Lista;

public class ListaEncadeada<T> extends Lista<T> {

    private No<T> inicio;
    private int qtd;

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = novoNo;
        } else {
            No<T> noAuxiliar = inicio;
            while (noAuxiliar.proximoNo != null) {
                noAuxiliar = noAuxiliar.proximoNo;
            }
            noAuxiliar.proximoNo = novoNo;
        }
        qtd++;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = novoNo;
        }
        No<T> noAuxiliar = new No<>(elemento);
        noAuxiliar.proximoNo = inicio;
        inicio = noAuxiliar;
        qtd++;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if(posicao > qtd)
            throw new ParametroInvalidoException("Posição inválida!");
        if (posicao == 0) {
            incluirInicio(elemento);
        } else if (posicao == qtd) {
            incluir(elemento);
        } else {
            No<T> noAuxiliar = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                noAuxiliar = noAuxiliar.proximoNo;
            }
            No<T> novoNo = new No<>(elemento);
            novoNo.proximoNo = noAuxiliar.proximoNo;
            noAuxiliar.proximoNo = novoNo;

            qtd++;
        }
    }

    @Override
    public T get(int posicao) throws Exception {
         if (estaVazia())
            throw new ParametroInvalidoException("A lista está vazia!");
        validaIndice(posicao);
        return getNoAuxiliar(posicao).conteudo;
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        if (estaVazia())
            throw new ParametroInvalidoException("A lista está vazia!");

        No<T> auxiliar = inicio;
        int posicao = 0;

        while (auxiliar != null) {
            if (auxiliar.conteudo.equals(elemento)) {
                return posicao;
            }
            posicao++;
            auxiliar = auxiliar.proximoNo;
        }
        throw new ParametroInvalidoException("Elemento não encontrado!");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if(estaVazia()) 
            throw new ParametroInvalidoException("A lista está vazia!");

        validaIndice(posicao);

        No<T> noAux = getNoAuxiliar(posicao);
        if (posicao == 0) {
            inicio = noAux.proximoNo;
            qtd--;
            return;
        }
        No<T> noAnterior = getNoAuxiliar(posicao - 1);
        noAnterior.proximoNo = noAux.proximoNo;

        qtd--;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.qtd = 0;
    }

    @Override
    public int getTamanho() {
        return qtd;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        if (estaVazia())
            throw new ParametroInvalidoException("A lista está vazia!");

        No<T> auxiliar = inicio;
        while (auxiliar != null) {
            if (auxiliar.conteudo.equals(elemento)) {
                return true;
            }
            auxiliar = auxiliar.proximoNo;
        }
        return false;
    }

    private boolean estaVazia() {
        return inicio == null ? true : false;
    }

    private No<T> getNoAuxiliar(int posicao) throws ParametroInvalidoException {
        No<T> noAuxiliar = inicio;
        No<T> noSuporte = null;

        for (int i = 0; i <= posicao; i++) {
            noSuporte = noAuxiliar;
            noAuxiliar = noAuxiliar.proximoNo;
        }

        return noSuporte;
    }

    public void validaIndice(int index) throws ParametroInvalidoException {
        if (index >= qtd || index < 0) {
            throw new ParametroInvalidoException("Posição inválida!");
        }
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return null;
        }
      
        String strRetorno = "";

        No<T> noAuxiliar = inicio;

        for (int i = 0; i < qtd; i++) {
            strRetorno += "\n[No\nPilha: " + noAuxiliar.conteudo + "\n]===== ";
            noAuxiliar = noAuxiliar.proximoNo;
        }
        return strRetorno;
    }

}
