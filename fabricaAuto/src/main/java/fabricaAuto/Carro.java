package fabricaAuto;

/**
 * Representa um carro, com opcionais de teto solar e janelas abertas.
 */
public class Carro extends Automovel {

    private boolean tetoSolar;
    private boolean aberto;

    public Carro(String cor, String placa, String modelo,
                 boolean ligado, boolean emMovimento,
                 boolean tetoSolar, boolean aberto) {

        super(cor, placa, modelo, ligado, emMovimento);
        this.tetoSolar = tetoSolar;
        this.aberto = aberto;
    }

    public boolean isTetoSolar() { return tetoSolar; }
    public boolean isAberto()    { return aberto; }

    @Override
    public String getDetalhes() {
        return FormatadorVeiculo.detalhes(this);
    }
}
