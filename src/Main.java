import java.util.ArrayList;
import java.util.UUID;

public class Main {


    // Observem que o processo de impressão é o mesmo e se repete várias vezes.
    // Tente extraír para um novo método. Se estiver trabalhando no main, o método deve ser estático
    public static void main(String[] args) {
        Repository repository = new Repository();
        Paciente paciente;
        ArrayList<Paciente> pacientes;


        System.out.println("Cadastrando alguns pacientes...");

        System.out.println();
        System.out.println("-----------------");
        System.out.println();

        repository.cadastrarPaciente(
                new Paciente(
                        "Mula sem cabeça",
                        "01/01/1982"));
        repository.cadastrarPaciente(
                new Paciente(
                        "Curupira",
                        "06/01/1982"));
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
        // IMPRIMINDO A LISTA RETORNADA
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente " + i + ": ");
            System.out.println(pacientes.get(i));
        }


        System.out.println();
        System.out.println("-----------------");
        System.out.println();

        pacientes = repository.buscarPorNome("FULANO DE TAL");

        System.out.println("Imprimindo todos os pacientes com o " +
                "nome fulano de tal");
        if (!pacientes.isEmpty()) {
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println("Paciente " + i + ": ");
                System.out.println(pacientes.get(i));
            }
        } else {
            System.out.println();
            System.out.println("Pessoa não encontrada");
        }

        System.out.println();

//        Paciente p = repository.listarTodos().get(0);
//        UUID id = p.getId();


        // Obtém o id de um elemento da lista
        UUID idParaBusca = repository.listarTodos().get(0).getId();
        //buscando por ID
        paciente = repository
                .buscarID(idParaBusca);

        System.out.println("Paciente do ID " + idParaBusca + ": " + paciente);

        // Alterando o nome
        paciente.alterarNome("Cuca");

        // Alterando o elemento no repositório
//        repository.alterarPaciente(paciente);


        pacientes = repository.listarTodos();

        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente " + i + ": ");
            System.out.println(pacientes.get(i));
        }
    }

}
