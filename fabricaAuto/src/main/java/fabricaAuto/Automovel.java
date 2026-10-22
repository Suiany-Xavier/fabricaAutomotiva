package fabricaAuto;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Classe base que representa um automóvel genérico.
 * Contém os atributos e comportamentos comuns a todos os veículos.
 */
public abstract class Automovel {

    private static final Pattern REGEX_PLACA =
            Pattern.compile("^[A-Z]{3}(?:[0-9]{4}|[0-9][A-Z][0-9]{2})$");

    private String cor;
    private String placa;
    private String modelo;
    private boolean ligado;
    private boolean emMovimento;

    public Automovel(String cor, String placa, String modelo, boolean ligado, boolean emMovimento) {
        if (cor == null || cor.isBlank()) throw new IllegalArgumentException("Cor não pode ser vazia.");
        if (!placaValida(placa)) {
            throw new IllegalArgumentException("Placa inválida. Use o formato ABC1234 ou ABC1D23.");
        }
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Modelo não pode ser vazio.");

        this.cor = cor.trim();
        this.placa = placa.trim().toUpperCase(Locale.ROOT);
        this.modelo = modelo.trim();
        this.ligado = ligado;

        if (emMovimento && !ligado) {
            throw new IllegalArgumentException("Um veículo desligado não pode estar em movimento.");
        }
        this.emMovimento = emMovimento;
    }

    static boolean placaValida(String placa) {
        return placa != null && REGEX_PLACA.matcher(placa.trim().toUpperCase(Locale.ROOT)).matches();
    }

    // --- Getters ---
    public String getCor()      { return cor; }
    public String getPlaca()    { return placa; }
    public String getModelo()   { return modelo; }
    public boolean isLigado()   { return ligado; }
    public boolean isEmMovimento() { return emMovimento; }

    /**
     * Retorna uma string formatada com o status operacional do veículo.
     */
    public String getStatus() {
        return "Ligado: " + (ligado ? "Sim" : "Não")
             + " | Movimento: " + (emMovimento ? "Em movimento" : "Parado");
    }

    /**
     * Exibe os detalhes completos do veículo (a ser implementado pelas subclasses).
     */
    public abstract String getDetalhes();

    @Override
    public String toString() {
        return modelo + " - " + cor + " [" + placa + "]";
    }
}
