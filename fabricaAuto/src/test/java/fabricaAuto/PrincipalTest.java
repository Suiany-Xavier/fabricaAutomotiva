package fabricaAuto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrincipalTest {

    @Test
    void exitsCleanlyWhenInputEndsAtMenu() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MenuConsole principal = new MenuConsole(
                new Scanner(""), new PrintStream(output, true, StandardCharsets.UTF_8));

        principal.executar();

        assertTrue(output.toString(StandardCharsets.UTF_8).contains("Entrada encerrada. Até logo!"));
    }

    @Test
    void exitsCleanlyWhenInputEndsDuringRegistration() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MenuConsole principal = new MenuConsole(
                new Scanner("1\n"), new PrintStream(output, true, StandardCharsets.UTF_8));

        principal.executar();

        assertTrue(output.toString(StandardCharsets.UTF_8).contains("Entrada encerrada. Até logo!"));
    }

    @Test
    void reportsDuplicatePlateAndRetainsOnlyFirstVehicle() {
        String input = String.join("\n",
                "1", "Preto", "ABC1234", "Sedan", "N", "N", "N",
                "2", "Vermelha", "abc1234", "Moto urbana", "S", "N", "S", "N",
                "4", "0");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MenuConsole principal = new MenuConsole(
                new Scanner(input), new PrintStream(output, true, StandardCharsets.UTF_8));

        principal.executar();

        String result = output.toString(StandardCharsets.UTF_8);
        assertTrue(result.contains("Já existe um veículo cadastrado com a placa ABC1234."));
        assertTrue(result.contains("Frota completa (1 veículo(s))"));
    }

    @Test
    void informsThatTurnedOffVehicleWillBeStationary() {
        String input = String.join("\n",
                "1", "Preto", "ABC1234", "Sedan", "N", "N", "N",
                "4", "0");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MenuConsole menu = new MenuConsole(
                new Scanner(input), new PrintStream(output, true, StandardCharsets.UTF_8));

        menu.executar();

        String result = output.toString(StandardCharsets.UTF_8);
        assertTrue(result.contains("Veículo desligado será cadastrado como parado."));
        assertTrue(result.contains("Carro cadastrado com sucesso!"));
    }

    @Test
    void asksForMovementWhenVehicleIsTurnedOn() {
        String input = String.join("\n",
                "1", "Preto", "ABC1234", "Sedan", "S", "S", "N", "N",
                "4", "0");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MenuConsole menu = new MenuConsole(
                new Scanner(input), new PrintStream(output, true, StandardCharsets.UTF_8));

        menu.executar();

        String result = output.toString(StandardCharsets.UTF_8);
        assertTrue(result.contains("Está em movimento?"));
        assertTrue(result.contains("Carro cadastrado com sucesso!"));
    }
}
