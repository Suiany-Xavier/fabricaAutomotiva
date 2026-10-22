package fabricaAuto;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Interface interativa de linha de comando para gerenciamento da frota. */
class MenuConsole {

    private final Scanner sc;
    private final PrintStream saida;
    private final Frota frota = new Frota();

    MenuConsole(Scanner sc, PrintStream saida) {
        this.sc = sc;
        this.saida = saida;
    }

    void executar() {
        saida.println("╔══════════════════════════════╗");
        saida.println("║   BEM-VINDO À FÁBRICA AUTO   ║");
        saida.println("╚══════════════════════════════╝");

        try {
            int op;
            do {
                exibirMenuPrincipal();
                op = lerInt("Escolha uma opção: ");

                switch (op) {
                    case 1 -> cadastrarCarro();
                    case 2 -> cadastrarMoto();
                    case 3 -> menuDetalhes();
                    case 4 -> listarTodos();
                    case 0 -> saida.println("\nEncerrando o sistema. Até logo!");
                    default -> saida.println("⚠  Opção inválida! Tente novamente.");
                }
            } while (op != 0);
        } catch (EntradaEncerradaException e) {
            saida.println("\nEntrada encerrada. Até logo!");
        }
    }

    private void exibirMenuPrincipal() {
        saida.println("\n╔════════════════════════╗");
        saida.println("║       MENU PRINCIPAL   ║");
        saida.println("╠════════════════════════╣");
        saida.println("║  1 - Cadastrar Carro   ║");
        saida.println("║  2 - Cadastrar Moto    ║");
        saida.println("║  3 - Ver detalhes      ║");
        saida.println("║  4 - Listar todos      ║");
        saida.println("║  0 - Sair              ║");
        saida.println("╚════════════════════════╝");
    }

    private void menuDetalhes() {
        if (frota.listar().isEmpty()) {
            saida.println("\n⚠  Nenhum veículo cadastrado na frota.");
            return;
        }

        int tipo;
        do {
            saida.println("\n┌─ DETALHES ─────────────┐");
            saida.println("│  1 - Ver Carros          │");
            saida.println("│  2 - Ver Motos           │");
            saida.println("│  0 - Voltar              │");
            saida.println("└──────────────────────────┘");

            tipo = lerInt("Escolha: ");

            if (tipo == 1)      exibirVeiculos(Carro.class, "Carros");
            else if (tipo == 2) exibirVeiculos(Moto.class, "Motos");
            else if (tipo != 0) saida.println("⚠  Opção inválida!");

        } while (tipo != 0);
    }

    private void cadastrarCarro() {
        saida.println("\n── Cadastro de Carro ──");
        try {
            String cor = lerTexto("Cor: ");
            String placa = lerPlaca();
            String modelo = lerTexto("Modelo: ");
            boolean ligado = lerSim("Está ligado? ");
            boolean movimento = lerMovimento(ligado);
            boolean tetoSolar = lerSim("Possui teto solar? ");
            boolean aberto = lerSim("Janelas abertas? ");

            frota.adicionar(new Carro(cor, placa, modelo, ligado, movimento, tetoSolar, aberto));
            saida.println("✔  Carro cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            saida.println("✖  Erro ao cadastrar: " + e.getMessage());
        }
    }

    private void cadastrarMoto() {
        saida.println("\n── Cadastro de Moto ──");
        try {
            String cor = lerTexto("Cor: ");
            String placa = lerPlaca();
            String modelo = lerTexto("Modelo: ");
            boolean ligado = lerSim("Está ligada? ");
            boolean movimento = lerMovimento(ligado);
            boolean freioAbs = lerSim("Possui freio ABS? ");
            boolean bau = lerSim("Possui baú? ");

            frota.adicionar(new Moto(cor, placa, modelo, ligado, movimento, freioAbs, bau));
            saida.println("✔  Moto cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            saida.println("✖  Erro ao cadastrar: " + e.getMessage());
        }
    }

    private boolean lerMovimento(boolean ligado) {
        if (!ligado) {
            saida.println("Veículo desligado será cadastrado como parado.");
            return false;
        }
        return lerSim("Está em movimento? ");
    }

    private void listarTodos() {
        List<Automovel> veiculos = frota.listar();
        if (veiculos.isEmpty()) {
            saida.println("\n⚠  Frota vazia.");
            return;
        }
        saida.println("\n── Frota completa (" + veiculos.size() + " veículo(s)) ──");
        for (int i = 0; i < veiculos.size(); i++) {
            saida.printf("  %d. %s%n", i + 1, veiculos.get(i));
        }
    }

    private <T extends Automovel> void exibirVeiculos(Class<T> tipo, String nomeCategoria) {
        List<T> filtrados = frota.listar().stream()
                .filter(tipo::isInstance)
                .map(tipo::cast)
                .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            saida.println("⚠  Nenhum(a) " + nomeCategoria.toLowerCase(Locale.ROOT) + " cadastrado(a).");
            return;
        }

        saida.println("\n── " + nomeCategoria + " (" + filtrados.size() + ") ──");
        for (int i = 0; i < filtrados.size(); i++) {
            saida.printf("  %d. %s%n", i + 1, filtrados.get(i));
        }

        int escolha = lerInt("Escolha um número (0 para cancelar): ");
        if (escolha == 0) return;

        if (escolha < 1 || escolha > filtrados.size()) {
            saida.println("⚠  Opção inválida!");
        } else {
            saida.println(filtrados.get(escolha - 1).getDetalhes());
        }
    }

    private String lerTexto(String msg) {
        String valor;
        do {
            saida.print(msg);
            valor = lerLinha().trim();
            if (valor.isEmpty()) saida.println("⚠  Campo obrigatório.");
        } while (valor.isEmpty());
        return valor;
    }

    private String lerPlaca() {
        String placa;
        do {
            saida.print("Placa: ");
            placa = lerLinha().trim();
            if (!Automovel.placaValida(placa)) {
                saida.println("⚠  Placa inválida! Use o formato ABC1234 ou ABC1D23.");
            }
        } while (!Automovel.placaValida(placa));
        return placa;
    }

    private boolean lerSim(String msg) {
        while (true) {
            saida.print(msg + " (S/N): ");
            String resp = lerLinha().trim().toUpperCase(Locale.ROOT);
            if (resp.equals("S")) return true;
            if (resp.equals("N")) return false;
            saida.println("⚠  Digite S para sim ou N para não.");
        }
    }

    private int lerInt(String msg) {
        while (true) {
            saida.print(msg);
            try {
                return Integer.parseInt(lerLinha().trim());
            } catch (NumberFormatException e) {
                saida.println("⚠  Entrada inválida! Digite um número.");
            }
        }
    }

    private String lerLinha() {
        if (!sc.hasNextLine()) {
            throw new EntradaEncerradaException();
        }
        return sc.nextLine();
    }

    private static class EntradaEncerradaException extends RuntimeException {
    }
}
