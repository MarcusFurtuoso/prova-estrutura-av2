package main.java.lista.listaencadeada;

import main.java.comum.ParametroInvalidoException;

public class ListaB<T> {

    private No<T> inicio;
    private int tamanho = 0;

    public ListaB() {
        this.inicio = null;
    }

    
    public void incluir(T elemento) throws Exception { // no final
        No<T> novoNo = new No<>(elemento);
        if(inicio == null){
            inicio = novoNo;
        } else {
            No<T> noAux = inicio;
            while (noAux.proximoNo != null){
                noAux = noAux.proximoNo;
            }
            noAux.proximoNo = novoNo;
        }

        tamanho++;
    }

    
    public void incluirInicio(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if(inicio == null){
            inicio = novoNo;
        } else {
            No<T> noAux = new No<>(elemento);
            noAux.proximoNo = inicio;
            inicio = noAux;
        }

        tamanho++;
    }

    
    public void incluir(T elemento, int posicao) throws Exception {
        if(posicao == 0){
            incluirInicio(elemento);
        } else if (posicao == tamanho) {
            incluir(elemento);
        } else {

            No<T> noAux = inicio;
            for (int i = 0; i < posicao - 1; i++){
                noAux = noAux.proximoNo;
            }

            No<T> novoNo = new No<>(elemento);
            novoNo.proximoNo = noAux.proximoNo;
            noAux.proximoNo = novoNo;

            tamanho++;
        }
    }

    
    public T get(int posicao) throws Exception {
        validarPos(posicao);
        return getNoAux(posicao).conteudo;
    }

    
    public int get(T elemnto) throws Exception {
        validarElemento(elemnto);
        No<T> noAux = new No<>(elemnto);
        int pos = 0;

        No<T> noIterador = inicio;
        while (noIterador.proximoNo != null){

//            if(noAux.conteudo.compareTo(noIterador.conteudo) == 0)
            if(noAux.conteudo.equals(noIterador.conteudo))
                break;

            noIterador = noIterador.proximoNo;
            pos++;
        }

        return pos;
    }

    
    public void remover(int posicao) throws Exception {
        validarPos(posicao);
        No<T> noAux = getNoAux(posicao);

        if(posicao == 0){
            inicio = noAux.proximoNo;
            tamanho--;
            return;
        }
        No<T> noAnterior = getNoAux(posicao - 1);
        noAnterior.proximoNo = noAux.proximoNo;

        tamanho--;
    }

    
    public boolean contem(T elemento) throws Exception {

        No<T> referenciaAux = inicio;
        while(true){
            if(referenciaAux != null){

//                if(referenciaAux.conteudo.compareTo(elemento) == 0)
                if(referenciaAux.conteudo.equals(elemento)){
                    return true;
                }
                if(referenciaAux.proximoNo != null){
                    referenciaAux = referenciaAux.proximoNo;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return false;
    }

    
    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    
    public int getTamanho() {
        return tamanho;
    }

    // /_ auxiliary methods __________________________/
    private No<T> getNoAux(int posicao){
        No<T> noRetorno = null;

        No<T> noAux = inicio;
        for(int i = 0; i <= posicao; i++){
            noRetorno = noAux;
            noAux = noAux.proximoNo;
        }

        return noRetorno;
    }

    public void validarPos(int posicao) throws ParametroInvalidoException {
        if(posicao < 0 || posicao >= tamanho){
            throw new ParametroInvalidoException("A posição informada é inválida");
        }
    }

    public void validarElemento(T elemento) throws Exception {
       if(!contem(elemento)){
           throw new ParametroInvalidoException("O elemento informado não está na lista");
       }
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        No<T> noAux = inicio;

        if(noAux == null){
            str.append("Lista vazia");
        } else {
            while(noAux != null){
                str.append("\n[No ").append(noAux.conteudo).append("\n]--> \n");
                noAux = noAux.proximoNo;
            }
            str.append("null");
        }

        return str.toString();
    }
}
