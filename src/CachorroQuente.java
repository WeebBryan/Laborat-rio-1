import java.util.List;

class CachorroQuente {
    private String proteina;
    private String queijo;
    private List<String> ingredientesAdicionais;
    private String bebida;

    public CachorroQuente(String proteina, String queijo, List<String> ingredientesAdicionais, String bebida) {
        this.proteina = proteina;
        this.queijo = queijo;
        this.ingredientesAdicionais = ingredientesAdicionais;
        this.bebida = bebida;
    }

    public String getProteina() {
        return proteina;
    }

    public String getQueijo() {
        return queijo;
    }

    public List<String> getIngredientesAdicionais() {
        return ingredientesAdicionais;
    }

    public String getBebida() {
        return bebida;
    }
}