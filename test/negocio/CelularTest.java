package negocio;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CelularTest {
    Celular celular;
    static Contato contato;
    static Chamada chamada;
    List<Contato> contatos;
    List<Chamada> chamadas;

    @BeforeAll
    public static void beforeAll() {
        contato = new Contato("Exemplo", "1");
        chamada = new Chamada("1");
    }

    @BeforeEach
    public void beforeEach() {
        celular = new Celular();
        contatos = new ArrayList<>();
        chamadas = new ArrayList<>();
    }

    @Test
    void getContatoByNumberRetornaContato() {
        contatos.add(contato);
        celular.setContatos(contatos);
        Contato contatoRetornado = celular.getContatoByNumber("1");
        assertEquals(contato, contatoRetornado);
    }

    @Test
    void getContatoByNumberRetornaNull() {
        Contato contatoRetornado = celular.getContatoByNumber("1");
        assertNull(contatoRetornado);
    }

    @Test
    void cadastraContato() {
        celular.cadastraContato(contato);
        assertTrue(celular.getContatos().contains(contato));
    }

    @Test
    void removeContato() {
        contatos.add(contato);
        celular.setContatos(contatos);
        celular.removeContato(contato);
        assertTrue(celular.getContatos().isEmpty());
    }

    @Test
    void cadastraChamadaNaoAtendida() {
        celular.cadastraChamada(chamada);
        assertTrue(celular.getChamadas().contains(chamada));
    }

    @Test
    void excluiTodasAsChamadasNaoAtendidas() {
        chamadas.add(chamada);
        celular.setChamadas(chamadas);
        celular.excluiTodasAsChamadasNaoAtendidas();
        assertTrue(celular.getChamadas().isEmpty());
    }
}