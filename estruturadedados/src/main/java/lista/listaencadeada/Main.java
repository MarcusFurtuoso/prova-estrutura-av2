package main.java.lista.listaencadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaEncadeada<String> listaEnc = new ListaEncadeada<>();
        // listaEnc.incluir("A");
        listaEnc.incluir("B");
        // listaEnc.incluir("F", 0);
        // listaEnc.incluirInicio("C");
        // System.out.println(listaEnc);
        // System.out.println(listaEnc.contem("Z"));
        // System.out.println(listaEnc.get(9));
        // System.out.println(listaEnc.getPosElemento("F"));
        // listaEnc.limpar();
        listaEnc.remover(7);
        // System.out.println(listaEnc.getTamanho());

       
        System.out.println(listaEnc);


    }
}
