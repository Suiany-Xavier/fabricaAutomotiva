package fabricaAuto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FormatadorVeiculoTest {

    @Test
    void preservesCarDetailsAndOptionalFeatures() {
        Carro carro = new Carro("Preto", "ABC1234", "Sedan", true, false, true, false);

        String detalhes = carro.getDetalhes();

        assertTrue(detalhes.contains("CARRO"));
        assertTrue(detalhes.contains("Sedan"));
        assertTrue(detalhes.contains("ABC1234"));
        assertTrue(detalhes.contains("Teto solar: Sim"));
        assertTrue(detalhes.contains("Janelas  : Fechadas"));
    }

    @Test
    void preservesMotorcycleDetailsAndOptionalFeatures() {
        Moto moto = new Moto("Vermelha", "XYZ1A23", "Urbana", true, true, false, true);

        String detalhes = moto.getDetalhes();

        assertTrue(detalhes.contains("MOTO"));
        assertTrue(detalhes.contains("Urbana"));
        assertTrue(detalhes.contains("XYZ1A23"));
        assertTrue(detalhes.contains("Freio ABS: Não"));
        assertTrue(detalhes.contains("Baú      : Sim"));
    }
}
