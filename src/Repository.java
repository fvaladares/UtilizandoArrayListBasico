import java.util.ArrayList;
import java.util.UUID;

public class Repository {
    private ArrayList<Paciente> repository;

    public Repository() {
        repository = new ArrayList<>();
    }

    public UUID cadastrarPaciente(Paciente paciente) {
        if (paciente.getId() == null) {
            paciente.setId(UUID.randomUUID());
        }

        if (repository.add(paciente)) {
            return paciente.getId();
        } else {
            return null;
        }
    }

    public ArrayList<Paciente> buscarPorNome(String nome) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Paciente paciente;

        for (Paciente value : repository) {
            paciente = value;
            if (paciente.getNomeCompleto().equalsIgnoreCase(nome)) {
                pacientes.add(paciente);
            }
        }

        return pacientes;
    }

    public Paciente buscarID(UUID id) {
        Paciente paciente;

        for (int i = 0; i < repository.size(); i++) {
            paciente = repository.get(i);

            if (paciente.getId().compareTo(id) == 0) {
                return paciente;
            }
        }

        return null;
    }

    public ArrayList<Paciente> listarTodos() {
        return repository;
    }

    public void alterarPaciente(Paciente paciente) {

        int index = repository.indexOf(paciente);
        repository.remove(index);
        repository.add(index, paciente);
    }
}
