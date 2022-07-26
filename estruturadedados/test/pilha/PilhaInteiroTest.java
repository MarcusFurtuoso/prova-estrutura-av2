package pilha;

import main.java.pilha.exception.PilhaCheiaException;
import main.java.pilha.exception.PilhaVaziaException;
import main.java.pilha.pilhaencadeada.PilhaProva;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class PilhaInteiroTest {

    PilhaProva<Integer> pilha;
    @BeforeEach
    void setUp() {
        pilha = new PilhaProva<Integer>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void empilhar_1Elemento_ComPilhaVaziaTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);
    }
    @Test
    void empilhar_NElementosTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);
        pilha.empilhar(2);
        assertThat(pilha.getTopo()).isEqualTo(2);
        pilha.empilhar(3);
        assertThat(pilha.getTopo()).isEqualTo(3);
    }


    @Test
    void desempilhar() throws PilhaVaziaException, PilhaCheiaException {
        int i = 0;
        for(; i< 3; i++) {
            pilha.empilhar(i);
        }
        while (!pilha.estahVazia()){
            assertThat(pilha.desempilhar()).isEqualTo(--i);
        }
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }

    @Test
    void desempilhar_MaisQueOPossivelTest() throws PilhaVaziaException, PilhaCheiaException {
        for(int i = 0; i< 3; i++) {
            pilha.empilhar(i);
        }
        for(int i = 0; i< 3; i++) {
            pilha.desempilhar();
        }

        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }
    @Test
    void desempilhar_PilhaVaziaErrorTest() {
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }

    @Test
    void pilhaCheiaExceptionTest() throws PilhaCheiaException {
        for( int i =0; i < 10; i++){
            pilha.empilhar(i);
        }
        assertThatExceptionOfType(PilhaCheiaException.class).isThrownBy(() -> pilha.empilhar(10));
    }

    @Test
    void getTopo_0_ElementoTest() {
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.getTopo());
    }

    @Test
    void getTopo_1_ElementoTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);
    }


    @Test
    void getQtd_Pilha_1_ElementoTest() throws PilhaCheiaException {
        pilha.empilhar(1);
        assertThat(pilha.estahVazia()).isFalse();
    }
    @Test
    void estahVaziaTest() {
        assertThat(pilha.estahVazia()).isTrue();
    }

    @Test
    void estahVazia_NaConstrucaoTest() {
        assertThat(pilha.estahVazia()).isEqualTo(true);
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.getTopo());

    }
    @Test
    void estahVazia_PosRemocaoTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        pilha.desempilhar();
        assertThat(pilha.estahVazia()).isEqualTo(true);
    }

    @Test
    void naoEstahVazia_PosInclusao() throws PilhaCheiaException {
        pilha.empilhar(1);
        assertThat(pilha.estahVazia()).isEqualTo(false);
    }
}
