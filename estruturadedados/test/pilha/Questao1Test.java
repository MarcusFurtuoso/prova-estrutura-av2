package pilha;

import main.java.comum.ParametroInvalidoException;
import main.java.fila.exception.FilaCheiaException;
import main.java.fila.exception.FilaVaziaException;
import main.java.fila.filaencadeada.FilaProva;
import main.java.lista.Lista;
import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;
import main.java.pilha.pilhaencadeada.PilhaProva;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Questao1Test extends PilhaInteiroTest {
    @Test
    void _0_5_obterListasComFilaVaziaTest() throws PilhaCheiaException, PilhaVaziaException {
        FilaProva<Integer> fila = new FilaProva<>();

        assertThatExceptionOfType(FilaVaziaException.class)
                .isThrownBy(() -> pilha.obterListaPilhas(fila, 1));

    }

    @Test
    void _0_5_validarParametroQtdPilhasTest() throws PilhaCheiaException, PilhaVaziaException, FilaCheiaException, ParametroInvalidoException, FilaVaziaException, Exception {
        FilaProva<Integer> fila = new FilaProva<>();
        fila.incluir(10);
        assertThatExceptionOfType(ParametroInvalidoException.class)
                .isThrownBy(() -> pilha.obterListaPilhas(fila, 0));
        assertThatExceptionOfType(ParametroInvalidoException.class)
                .isThrownBy(() -> pilha.obterListaPilhas(fila, -1));
        assertThatExceptionOfType(ParametroInvalidoException.class)
                .isThrownBy(() -> pilha.obterListaPilhas(fila, 11));

        assertThat(pilha.obterListaPilhas(fila, 1));
        assertThat(pilha.obterListaPilhas(fila, 10));
    }
    @Test
    void _1_5_distribuicaoElementosTest() throws Exception {
        FilaProva<Integer> fila = new FilaProva<>();
        for (int i = 10; i < 100; i += 10) {
            fila.incluir(i);
        }
        int[] qtdPrevista = new int[]{2, 2, 2, 4};

        Lista<PilhaProva<Integer>> resultado = pilha.obterListaPilhas(fila, qtdPrevista.length);
        assertThat(resultado.getTamanho()).isEqualTo(qtdPrevista.length);
        for(int i = 0; i <qtdPrevista.length; i++) {
            int qtdAtual = 0;
            PilhaProva<Integer> pilha = resultado.get(i);
            while (!pilha.estahVazia()) {
                assertThat(qtdAtual).isLessThanOrEqualTo(qtdPrevista[i]);
                qtdAtual++;
            }
        }
    }
    @Test
    void _1_5_ordemDosElementosTest() throws Exception {
        FilaProva<Integer> fila = new FilaProva<>();
        for (int i = 10; i < 100; i += 10) {
            fila.incluir(i);
        }
        int[] qtdPrevista = new int[]{3,3,4};
        Lista<PilhaProva<Integer>> resultado = pilha.obterListaPilhas(fila, qtdPrevista.length);
        int valorEsperado = 10;
        for(int i = 0; i <qtdPrevista.length; i++){
            int qtdAtual = 0;
            PilhaProva<Integer> pilha = resultado.get(i);
            while (!pilha.estahVazia()){
                qtdAtual++;
                assertThat(qtdAtual).isLessThanOrEqualTo(qtdPrevista[i]);
                assertThat(pilha.desempilhar()).isEqualTo(valorEsperado);
                valorEsperado+=10;
            }
            assertThat(qtdAtual).isEqualTo(qtdPrevista[i]);
        }
    }

    @Test
    void _1_0_filaOriginalNaoFoiModificadaTest() throws FilaCheiaException, PilhaCheiaException, PilhaVaziaException, ParametroInvalidoException, FilaVaziaException, Exception {
        FilaProva<Integer> fila = new FilaProva<>();
        for (int i = 10; i < 100; i += 10) {
            fila.incluir(i);
        }
        pilha.obterListaPilhas(fila, 3);
        assertThat(fila.estaVazia()).isFalse();
        for (int i = 10; i < 100; i += 10) {
            assertThat(fila.remover()).isEqualTo(i);
        }
    }
}
