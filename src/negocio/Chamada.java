package negocio;

public class Chamada {
    private String telefone;

    public Chamada(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Chamada{" +
                "telefone='" + telefone + '\'' +
                '}';
    }
}
