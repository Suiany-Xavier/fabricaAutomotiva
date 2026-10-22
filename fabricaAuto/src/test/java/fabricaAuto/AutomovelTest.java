package fabricaAuto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AutomovelTest {

    @Test
    void acceptsOldAndMercosulPlateFormats() {
        assertTrue(Automovel.placaValida("ABC1234"));
        assertTrue(Automovel.placaValida("abc1d23"));
        assertFalse(Automovel.placaValida("AB1234"));
        assertFalse(Automovel.placaValida("ABC12D3"));
        assertFalse(Automovel.placaValida(null));
    }

    @Test
    void normalizesPlateAndRejectsInvalidPlateAtModelBoundary() {
        Carro carro = new Carro("Preto", " abc1234 ", "Sedan", false, false, false, false);

        assertEquals("ABC1234", carro.getPlaca());
        assertThrows(IllegalArgumentException.class,
                () -> new Carro("Preto", "INVALIDA", "Sedan", false, false, false, false));
    }

    @Test
    void rejectsVehicleInMotionWhenItIsNotTurnedOn() {
        assertThrows(IllegalArgumentException.class,
                () -> new Carro("Preto", "ABC1234", "Sedan", false, true, false, false));
    }

    @Test
    void allowsTurnedOffVehicleWhenItIsStationary() {
        Carro carro = new Carro("Preto", "ABC1234", "Sedan", false, false, false, false);

        assertFalse(carro.isEmMovimento());
    }
}
