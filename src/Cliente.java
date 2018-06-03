import java.util.Random;

public class Cliente {
    private String nome;
    private int idade;

    //Construtor
    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    //Retorna a idade do cliente
    public int getIdade() {
        return idade;
    }


    //Criar clientes com nomes aleatórios (Nome e Sobrenome)
    public static String gerarCliente() {
        String cliente = "AEIOUABCDEFGHIJKLMNOPQRSTUVYWXZAAEEIIOOUU";
        Random r = new Random();

        //Nome do cliente, será as duas letras iniciais (Nome e Sobrenome)
        char letra_um = cliente.charAt(r.nextInt(36));
        char letra_dois = cliente.charAt(r.nextInt(36));

        cliente = Character.toString(letra_um) + Character.toString(letra_dois);

        return cliente;
    }

    //Retorna idade no intervalo 18-100 anos
    public static int gerarIdade() {
        Random r = new Random();
        int idade_min = 18;
        int idade_max = 100;

        return r.nextInt((idade_max - idade_min) + 1) + idade_min;
    }


    @Override
    public String toString() {
        return "Cliente [nome:" + nome + ", idade:" + idade + "]";
    }

}