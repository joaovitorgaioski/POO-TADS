public enum Pais {
    // Constantes
    BRASIL("Brasil", "BR", "América do Sul"),
    ANGOLA("Angola", "AO", "África"),
    FRANCA("França", "FR", "Europa"),
    CHINA("China", "CN", "Ásia"),
    RUSSIA("Rússia", "RU", "Ásia/Europa"),
    ESTADOS_UNIDOS("Estados Unidos", "US", "América do Norte");

    // final define uma constante
    private final String nome, sigla, continente;

    // Construtor
    Pais(String nome, String sigla, String continente) {
        this.nome = nome;
        this.sigla = sigla;
        this.continente = continente;
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getContinente() {
        return this.continente;
    }

}
