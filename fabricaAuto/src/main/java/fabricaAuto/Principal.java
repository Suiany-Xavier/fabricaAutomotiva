
package fabricaAuto;

import java.util.Scanner;

/** Inicializa a interface de linha de comando do sistema. */
public class Principal {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new MenuConsole(scanner, System.out).executar();
        }
    }
}
