package fabricaAuto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FrotaTest {

    @Test
    void acceptsUniqueVehiclesAndReturnsAnUnmodifiableList() {
        Frota frota = new Frota();
        Carro carro = new Carro("Preto", "ABC1234", "Sedan", false, false, false, false);
        Moto moto = new Moto("Vermelha", "XYZ1A23", "Urbana", true, false, true, false);

        frota.adicionar(carro);
        frota.adicionar(moto);

        assertEquals(List.of(carro, moto), frota.listar());
        assertThrows(UnsupportedOperationException.class, () -> frota.listar().clear());
    }

    @Test
    void rejectsDuplicatePlatesIgnoringCaseAndKeepsOriginalVehicle() {
        Frota frota = new Frota();
        Carro carro = new Carro("Preto", "ABC1234", "Sedan", false, false, false, false);
        Moto moto = new Moto("Vermelha", "abc1234", "Urbana", true, false, true, false);
        frota.adicionar(carro);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> frota.adicionar(moto));

        assertTrue(exception.getMessage().contains("ABC1234"));
        assertEquals(List.of(carro), frota.listar());
    }

    @Test
    void rejectsNullVehicles() {
        Frota frota = new Frota();

        assertThrows(NullPointerException.class, () -> frota.adicionar(null));
        assertTrue(frota.listar().isEmpty());
    }
}
