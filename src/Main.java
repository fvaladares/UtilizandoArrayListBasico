import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        Paciente paciente;
        ArrayList<Paciente> pacientes;


        System.out.println("Cadastrando alguns pacientes");

        repository.cadastrarPaciente(
                new Paciente(
                        "Fulano de Tal",
                        "01/01/1982"));
        repository.cadastrarPaciente(
                new Paciente("Papai Noel",
                "25/12/2000"));
        repository.cadastrarPaciente(
                new Paciente("Saci Pererê",
                        "25/10/1944"));

        // Busca todos os pacientes cadastrados
        // e salva e uma lista
        pacientes = repository.listarTodos();

        System.out.println();

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente " + i + ": ");
            System.out.println(pacientes.get(i));
        }

        pacientes = repository.buscarPorNome("Fulano tal");

        if (!pacientes.isEmpty()) {
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println("Paciente " + i + ": ");
                System.out.println(pacientes.get(i));
            }
        } else {
            System.out.println();
            System.out.println("Pessoa não encontrada");
        }

        paciente = repository
                .buscarID(repository.listarTodos().get(0).getId());

        System.out.println("Paciente: " + paciente);

        paciente.alterarNome("Meu nome nome");

        repository.alterarPaciente(paciente);


        pacientes = repository.listarTodos();

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente " + i + ": ");
            System.out.println(pacientes.get(i));
        }
    }

}
