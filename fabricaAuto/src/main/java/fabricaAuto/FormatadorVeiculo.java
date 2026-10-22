package fabricaAuto;

/** Concentra a apresentação textual detalhada dos veículos. */
final class FormatadorVeiculo {

    private FormatadorVeiculo() {
    }

    static String detalhes(Carro carro) {
        return String.format(
                "%n╔══════════════════════╗" +
                "%n║       CARRO          ║" +
                "%n╠══════════════════════╣" +
                "%n║  Modelo: %s          ║" +       
                "%n║  Cor: %s             ║" +          
                "%n║  Placa: %s           ║" +
                "%n║  %s                  ║" +
                "%n║  Teto solar: %s      ║" +
                "%n║  Janelas: %s         ║" +
                "%n╚══════════════════════╝",
                carro.getModelo(), carro.getCor(), carro.getPlaca(),
                carro.getStatus(),
                carro.isTetoSolar() ? "Sim" : "Não",
                carro.isAberto() ? "Abertas" : "Fechadas"
        );
    }

    static String detalhes(Moto moto) {
        return String.format(
                "%n╔══════════════════════╗" +
                "%n║       MOTO           ║" +
                "%n╠══════════════════════╣" +
                "%n║ Modelo: %s           ║" +
                "%n║  Cor: %s             ║" +
                "%n║  Placa: %s           ║" +
                "%n║  %s                  ║" +
                "%n║  Freio ABS: %s       ║" +
                "%n║  Baú: %s             ║" +
                "%n╚══════════════════════╝",
                moto.getModelo(), moto.getCor(), moto.getPlaca(),
                moto.getStatus(),
                moto.isFreioAbs() ? "Sim" : "Não",
                moto.isBau() ? "Sim" : "Não"
        );
    }
}
