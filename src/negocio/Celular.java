package negocio;

import java.util.ArrayList;
import java.util.List;

public class Celular {
    private List<Chamada> chamadas;
    private List<Contato> contatos;

    public Celular() {
        this.chamadas = new ArrayList<>();
        this.contatos = new ArrayList<>();
    }

    public List<Chamada> getChamadas() {
        return chamadas;
    }

    public void setChamadas(List<Chamada> chamadas) {
        this.chamadas = chamadas;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Contato getContatoByNumber(String telefone) {
        for (Contato contato : contatos)
            if (contato.getTelefone().equals(telefone))
                return contato;

        return null;
    }

    public void cadastraContato(Contato contato) {
        contatos.add(contato);
    }

    public void removeContato(Contato contato) {
        contatos.remove(contato);
    }

    public void cadastraChamada(Chamada chamada) {
        chamadas.add(chamada);
    }

    public void excluiTodasAsChamadasNaoAtendidas() {
        chamadas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Chamadas não atendidas: " + chamadas +
                " | Contatos: " + contatos;
    }
}
