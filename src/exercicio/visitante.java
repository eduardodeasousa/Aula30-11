package exercicio;


public class visitante {
    private int id;
    private String nome;
    private int idade;
    private String entrada;
    private String saida;

    public visitante() {
    }

    public visitante(int id, String nome, int idade, String entrada, String saida) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.entrada = entrada;
        this.saida = saida;
    }

    public visitante(int id, String nome, int idade, String entrada) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.entrada = entrada;
    }

    public visitante(String nome, int idade, String entrada) {
        this.nome = nome;
        this.idade = idade;
        this.entrada = entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
}
