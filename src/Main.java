import java.util.Random;

/**
 * Criado por:
 * Guilherme Dall'Agnol Deconto
 */
public class Main {

    public static void main(String[] args) {

        String nome;
        int idade;
        int numCaixa;
        int pessoasFila;

        Random random = new Random();

        FilaClientes filaClientes = new FilaClientes();
        Caixa atendimento = new Caixa(filaClientes);

        pessoasFila = random.nextInt(40) + 1;

        // Adiciona pessoas na fila
        for (int i = 0; i < pessoasFila; i++) {

            nome = Cliente.gerarCliente();
            idade = Cliente.gerarIdade();
            Cliente c = new Cliente(nome, idade);

            filaClientes.enqueue(c);

            pessoasFila += random.nextInt(2);

        }

        // Realizado o atendimento aos clientes
        // Numero de caixas é random
        for (int j = 1; j <= pessoasFila; j++) {

            numCaixa = random.nextInt(10) + 1;

            System.out.println(
                    "\nPessoas na fila: " + (filaClientes.sizeFilaPrioritaria() + filaClientes.sizeFilaNormal()));

            System.out.println("Atendimento prioritário: " + filaClientes.sizeFilaPrioritaria());
            System.out.println("Atendimento normal: " + filaClientes.sizeFilaNormal());
            System.out.println("\nPróximo 'NORMAL'  " + filaClientes.headFilaNormal());
            System.out.println("Próximo 'PRIORITÁRIO'  " + filaClientes.headFilaPrioritaria());

            System.out.println("\nCAIXA " + numCaixa + " LIVRE");

            if (numCaixa >= 1 && numCaixa <= 5)
                System.out.println("\nCliente '" + filaClientes.headFilaPrioritaria().getNome() + "' ATENDIDO");

            else
                System.out.println("\nCliente '" + filaClientes.headFilaNormal().getNome() + "' ATENDIDO");

            atendimento.efetuaAtendimento(numCaixa);

            System.out.println("----------------------------\n");

        }

    }

}
