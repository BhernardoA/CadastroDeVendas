package Enums;
    public enum TipoPagamento {
    DINHEIRO("dinheiro"),
    CARTAO("cartao"),
    TRANSFERENCIA("transferencia");

    private final String valor;

    TipoPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoPagamento fromString(String valor) {
        for (TipoPagamento tipo : TipoPagamento.values()) {
            if (tipo.valor.equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de pagamento inválido: " + valor);
    }
}
