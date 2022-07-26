package main.java.lista.listaencadeada;

public class No<T> {
    public T conteudo;
    public No<T> proximoNo;

    public No(T conteudo) {
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    public No(T conteudo, No<T> proximoNo) {
        this.conteudo = conteudo;
        this.proximoNo = proximoNo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    
}
