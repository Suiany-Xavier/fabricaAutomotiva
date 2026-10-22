package fabricaAuto;

/**
 * Representa uma moto, com opcionais de freio ABS e baú traseiro.
 */
public class Moto extends Automovel {

    private boolean freioAbs;
    private boolean bau;

    public Moto(String cor, String placa, String modelo,
                boolean ligado, boolean emMovimento,
                boolean freioAbs, boolean bau) {

        super(cor, placa, modelo, ligado, emMovimento);
        this.freioAbs = freioAbs;
        this.bau = bau;
    }

    public boolean isFreioAbs() { return freioAbs; }
    public boolean isBau()      { return bau; }

    @Override
    public String getDetalhes() {
        return FormatadorVeiculo.detalhes(this);
    }
}
