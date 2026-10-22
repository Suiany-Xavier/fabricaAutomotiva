package fabricaAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Mantém os veículos cadastrados e garante placas únicas na frota. */
public class Frota {

    private final List<Automovel> veiculos = new ArrayList<>();

    public void adicionar(Automovel veiculo) {
        Objects.requireNonNull(veiculo, "Veículo não pode ser nulo.");
        boolean placaJaCadastrada = veiculos.stream()
                .anyMatch(cadastrado -> cadastrado.getPlaca().equalsIgnoreCase(veiculo.getPlaca()));
        if (placaJaCadastrada) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com a placa " + veiculo.getPlaca() + ".");
        }
        veiculos.add(veiculo);
    }

    public List<Automovel> listar() {
        return Collections.unmodifiableList(veiculos);
    }
}
