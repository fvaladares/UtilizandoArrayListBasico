import java.util.UUID;

public class Paciente {

    private UUID id; // Identificador único
    private String nomeCompleto;
    private String dataNascimento;

    public Paciente(UUID id,
                    String nomeCompleto,
                    String dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public Paciente(String nomeCompleto,
                    String dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UUID getId() {
        return id;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "\n\tid=" + id +
                ", \n\tnomeCompleto='" + nomeCompleto + '\'' +
                ", \n\tdataNascimento='" + dataNascimento + '\'' +
                "\n}";
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public boolean alterarNome(String novoNome) {
        if (!novoNome.isEmpty() && !novoNome.isBlank()) {
            this.nomeCompleto = novoNome;
            return true;
        } else {
            return false;
        }
    }
}
