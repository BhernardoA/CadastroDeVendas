package Enums;
    public enum Unidade {
    QUILOS("quilos"),
    TONELADAS("toneladas");

    private final String valor;

    Unidade(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Unidade fromString(String valor) {
        for (Unidade unidade : Unidade.values()) {
            if (unidade.valor.equalsIgnoreCase(valor)) {
                return unidade;
            }
        }
        throw new IllegalArgumentException("Unidade inválida: " + valor);
    }
}
